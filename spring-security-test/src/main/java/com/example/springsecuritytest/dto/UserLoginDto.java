package com.example.springsecuritytest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserLoginDto {
    private String email;
    private String password;
}