package com.filipdishe.PetShop.dto;

import com.filipdishe.PetShop.enums.PetType;
import com.filipdishe.PetShop.model.User;

import java.time.LocalDate;

public class PetDto {

    private Long petId;
    private String name;
    private PetType type;
    private String description;
    private LocalDate dateOfBirth;
    private Double price;
    private Integer rating;

    private User owner;

    public PetDto() {
    }

    public PetDto(Long petId, String name, PetType type, String description, LocalDate dateOfBirth, Double price, Integer rating, User owner) {
        this.petId = petId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.rating = rating;
        this.owner = owner;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
