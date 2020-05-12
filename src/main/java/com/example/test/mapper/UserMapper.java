package com.example.test.mapper;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper
public interface UserMapper {

    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    User asUser(UserDto userDto);

    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    UserDto asUserDto(User user);
}
