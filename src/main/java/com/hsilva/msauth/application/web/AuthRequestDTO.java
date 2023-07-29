package com.hsilva.msauth.application.web;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String username;

    private String password;

    private Long time;
}
