package com.hsilva.msauth.controller.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String username;

    private String password;

    private Long time;
}
