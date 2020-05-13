package com.example.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about the user")
public class UserDto {

    @Getter
    @Setter
    @ApiModelProperty(notes = "The user's first name")
    private String firstName;

    @Getter
    @Setter
    @ApiModelProperty(notes = "The user's last name")
    private String lastName;

}
