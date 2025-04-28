package com.user.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String newPassword;
}
