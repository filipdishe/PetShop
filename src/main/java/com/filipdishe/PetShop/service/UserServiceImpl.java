package com.filipdishe.PetShop.service;

import com.filipdishe.PetShop.dto.UserDto;
import com.filipdishe.PetShop.enums.PetType;
import com.filipdishe.PetShop.exceptions.MaxUsersExceededException;
import com.filipdishe.PetShop.exceptions.UsersNotFoundException;
import com.filipdishe.PetShop.mapper.UserMapper;
import com.filipdishe.PetShop.model.BuyHistory;
import com.filipdishe.PetShop.model.Pet;
import com.filipdishe.PetShop.model.User;
import com.filipdishe.PetShop.repository.BuyHistoryRepository;
import com.filipdishe.PetShop.repository.PetRepository;
import com.filipdishe.PetShop.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PetRepository petRepository;

    private final BuyHistoryRepository buyHistoryRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PetRepository petRepository, BuyHistoryRepository buyHistoryRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.buyHistoryRepository = buyHistoryRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public List<UserDto> createUsers() {
        int maxAllowedUsers = 10;
        long numberOfUsers = userRepository.count();

        if(numberOfUsers >= maxAllowedUsers) {
            throw new MaxUsersExceededException("Maximum number of users allowed (" + maxAllowedUsers + ") has been reached");
        }

        List<User> usersToSave = generateRandomUsers(10);

        userRepository.saveAll(usersToSave);

        return usersToSave
                .stream()
                .map(user -> userMapper.userToUserDTO(user))
                .collect(Collectors.toList());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.userToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void buyPetsForUsers() {
        List<User> users = userRepository.findAll();
        List<Pet> availablePets = petRepository.findUnownedPets();
        List<User> updatedUsers = new ArrayList<>();
        List<Pet> updatedPets = new ArrayList<>();

        int successfulBuys = 0;
        int unsuccessfulBuys = 0;

        if (users.isEmpty() || availablePets.isEmpty()) {
            throw new UsersNotFoundException("You must create users and pets in order to use this endpoint.");
        }

        for (User user : users) {
            int randomIndex = new Random().nextInt(availablePets.size());
            Pet randomPet = availablePets.get(randomIndex);

            if (user.getBudget() >= randomPet.getPrice()) {
                user.setBudget(user.getBudget() - randomPet.getPrice());
                randomPet.setOwner(user);
                updatedUsers.add(user);
                updatedPets.add(randomPet);
                successfulBuys++;

                printHasOwnerMessage(randomPet, user);

                availablePets.remove(randomPet);
                } else {
                    unsuccessfulBuys++;
                }
            }

        BuyHistory buyHistory = new BuyHistory();
        buyHistory.setExecutionDate(LocalDateTime.now());
        buyHistory.setSuccessfulBuys(successfulBuys);
        buyHistory.setUnsuccessfulBuys(unsuccessfulBuys);

        userRepository.saveAll(updatedUsers);
        petRepository.saveAll(updatedPets);
        buyHistoryRepository.save(buyHistory);

    }

    private List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        List<String> availableFirstNames = new ArrayList<>(Arrays.asList("Filip", "John", "Peter", "Jane", "Maria", "Sofia", "Tom", "Mark", "Alex", "Grace"));
        List<String> availableLastNames = new ArrayList<>(Arrays.asList("Dishe", "Petrovski", "Johnson", "Jackson", "Knuth", "Anderson", "Vasilevski", "Mitrevski", "Davis", "Lewis"));

        for (int i = 0; i < count && !availableFirstNames.isEmpty() && !availableLastNames.isEmpty(); i++) {
            int randomFirstNameIndex = new Random().nextInt(availableFirstNames.size());
            int randomLastNameIndex = new Random().nextInt(availableLastNames.size());

            String randomFirstName = availableFirstNames.remove(randomFirstNameIndex);
            String randomLastName = availableLastNames.remove(randomLastNameIndex);

            User user = new User();
            user.setFirstName(randomFirstName);
            user.setLastName(randomLastName);
            user.setEmail(randomFirstName.toLowerCase() + "@company.com");
            // this line generates number between 0.00 and 50.00
            user.setBudget(Math.round(Math.random() * 5000.0) / 100.0);

            users.add(user);
        }
        return users;
    }

    private void printHasOwnerMessage(Pet pet, User user) {
        if (pet.getType() == PetType.Cat) {
            System.out.println("Meow, cat " + pet.getName() + " has owner " + user.getFirstName());
        } else if (pet.getType() == PetType.Dog) {
            System.out.println("Woof, dog " + pet.getName() + " has owner " + user.getFirstName());
        }
    }

}