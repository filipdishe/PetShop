package com.filipdishe.PetShop.mapper;

import com.filipdishe.PetShop.dto.PetDto;
import com.filipdishe.PetShop.model.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetDto petToPetDto(Pet pet);

    Pet petDtoToPet(PetDto petDto);
}
