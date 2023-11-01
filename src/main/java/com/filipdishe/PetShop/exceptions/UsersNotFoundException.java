package com.filipdishe.PetShop.exceptions;

public class UsersNotFoundException extends RuntimeException{

    public UsersNotFoundException(String message) {
        super(message);
    }
}
