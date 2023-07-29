package com.hsilva.msauth.application.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
