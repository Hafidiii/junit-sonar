package com.example.test.dto;

import com.example.test.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;

    public UserDto(User user){
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
    }

    @Override
    public String toString() {
        return "{" +
                "firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                '}';
    }
}
