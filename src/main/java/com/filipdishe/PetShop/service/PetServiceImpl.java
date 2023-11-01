package com.filipdishe.PetShop.service;

import com.filipdishe.PetShop.dto.PetDto;
import com.filipdishe.PetShop.enums.PetType;
import com.filipdishe.PetShop.exceptions.MaxUsersExceededException;
import com.filipdishe.PetShop.mapper.PetMapper;
import com.filipdishe.PetShop.model.Pet;
import com.filipdishe.PetShop.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    @Transactional
    @Override
    public List<PetDto> createPets() {
        int maxAllowedPets = 20;
        long numberOfPets = petRepository.count();

        if(numberOfPets >= maxAllowedPets) {
            throw new MaxUsersExceededException("Maximum number of pets allowed (" + maxAllowedPets + ") has been reached");
        }

        List<Pet> petsToSave = generateRandomPets(maxAllowedPets);

        petRepository.saveAll(petsToSave);

        return petsToSave
                .stream()
                .map(pet -> petMapper.petToPetDto(pet))
                .collect(Collectors.toList());
    }

    @Override
    public List<PetDto> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(pet -> petMapper.petToPetDto(pet))
                .collect(Collectors.toList());
    }

    private List<Pet> generateRandomPets(int count) {
        List<Pet> pets = new ArrayList<>();
        List<String> availableNames =
                new ArrayList<>(Arrays.asList("Nala", "Simba", "Mufasa", "Morty", "Rick", "Rex", "Luna", "Fizz", "Ahre", "Ashe",
                        "Bard", "Azir", "Gnar", "Lulu", "Bella", "Daisy", "Leo", "Coco", "Teddy", "Pongo"));

        for (int i = 0; i < count && !availableNames.isEmpty(); i++) {
            int randomNameIndex = new Random().nextInt(availableNames.size());
            String randomName = availableNames.remove(randomNameIndex);
            int randomRating = new Random().nextInt(11);

            PetType randomPetType = generateRandomPetType();
            LocalDate randomDateOfBirth = generateRandomDateOfBirth(randomPetType);

            Pet pet = new Pet();
            pet.setName(randomName);
            pet.setType(randomPetType);
            pet.setDescription(generateRandomDescription());
            pet.setDateOfBirth(randomDateOfBirth);
            pet.setRating((randomPetType == PetType.Dog) ? randomRating : null);
            pet.setPrice(calculatePrice(randomPetType, randomDateOfBirth, randomRating));

            pets.add(pet);
        }

        return pets;
    }

    private PetType generateRandomPetType() {
        PetType[] petTypes = PetType.values();
        int randomIndex = new Random().nextInt(petTypes.length);
        return petTypes[randomIndex];
    }

    private String generateRandomDescription() {
        String[] availableDescriptions = {"Friendly", "Loyal", "Fun", "Calm"};
        int randomIndex = new Random().nextInt(availableDescriptions.length);
        return availableDescriptions[randomIndex];
    }

    private LocalDate generateRandomDateOfBirth(PetType petType) {
        LocalDate currentDate = LocalDate.now();

        //1. This is the maximum year that a cat or dog can live.
        int maxYear = (petType == PetType.Cat) ? 15 : 20;

        //2. This is random year in range between maximum dog/cat year and 0
        int randomYears = new Random().nextInt(maxYear + 1);

        //3. This is a random date between the year(now, when this method runs) minus the dog/cat birth year
        LocalDate randomDate = currentDate.minusYears(randomYears);

        //4. Getting random month for the birth year of dog/cat
        int randomMonth = new Random().nextInt(12) + 1;

        //5. Getting the max number of days in the month of the dog/cat birth year.
        int maxDaysInMonth = YearMonth.of(randomDate.getYear(), randomMonth).lengthOfMonth();

        //6. Getting random day between the available days in the month
        int randomDay = new Random().nextInt(maxDaysInMonth) + 1;

        //7. Creating the date with all elements year + month + day
        randomDate = randomDate.withMonth(randomMonth).withDayOfMonth(randomDay);

        return randomDate;
    }

    private Double calculatePrice(PetType petType, LocalDate dateOfBirth, int rating) {
        int ageInYears = LocalDate.now().getYear() - dateOfBirth.getYear();
        Double price = (double) ((petType == PetType.Cat) ? ageInYears : ageInYears + rating);

        return price;
    }
}