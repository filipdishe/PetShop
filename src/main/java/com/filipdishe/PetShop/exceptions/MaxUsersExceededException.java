package com.filipdishe.PetShop.exceptions;

public class MaxUsersExceededException extends RuntimeException {

    public MaxUsersExceededException(String message) {
        super(message);
    }
}
