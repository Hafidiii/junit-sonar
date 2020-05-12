package com.example.test.dto;

import com.example.test.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    public UserDto(User user){
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
    }
}
