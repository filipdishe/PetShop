package com.filipdishe.PetShop.dto;

import com.filipdishe.PetShop.model.Pet;

import java.util.List;

public class UserDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Double budget;

    private List<Pet> pets;

    public UserDto() {
    }

    public UserDto(Long userId, String firstName, String lastName, String email, Double budget, List<Pet> pets) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
        this.pets = pets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
