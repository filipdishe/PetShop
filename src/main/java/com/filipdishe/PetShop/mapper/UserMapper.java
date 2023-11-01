package com.filipdishe.PetShop.mapper;

import com.filipdishe.PetShop.dto.UserDto;
import com.filipdishe.PetShop.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDTO(User user);

    User userDtoToUser(UserDto userDTO);
}
