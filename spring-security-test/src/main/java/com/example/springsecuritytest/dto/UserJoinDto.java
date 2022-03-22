package com.example.springsecuritytest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserJoinDto {
    private String email;
    private String password;
    private List<String> role;
}