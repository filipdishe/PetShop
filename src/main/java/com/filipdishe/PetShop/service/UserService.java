package com.filipdishe.PetShop.service;

import com.filipdishe.PetShop.dto.UserDto;
import com.filipdishe.PetShop.exceptions.MaxUsersExceededException;
import com.filipdishe.PetShop.exceptions.UsersNotFoundException;

import java.util.List;

/**
 * This class is responsible for performing business logic for the users.
 */
public interface UserService {

    /**
     * Create 10 users with random fields/properties automatically the properties are completely random
     * they don't repeat, and save them in a database.
     *
     * @throws MaxUsersExceededException if clients attempt to create more than 10 users.
     */
    List<UserDto> createUsers();

    /**
     * Get all the users stored in the database.
     */
    List<UserDto> getAllUsers();

    /**
     * Goes over all users and all pets that are without user and try to buy pet for each user.
     *
     * @throws UsersNotFoundException if clients attempt to use this method when there aren't users in the database.
     */
    void buyPetsForUsers();

}
