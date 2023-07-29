package com.hsilva.msauth.application.web;

import com.hsilva.msauth.application.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDTO {

    private String uuid;

    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean active;

    public UserDetailDTO(User user){
        this.uuid = user.getUuid();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.active = user.isActive();
    }
}
