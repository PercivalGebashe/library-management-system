package com.github.percivalgebashe.registrationservice.dto;

import com.github.percivalgebashe.registrationservice.enums.Role;

import java.util.UUID;

public record UserRegistrationRequestRecord(
        String fullName,
        String email,
        String password,
        Role role,
        UUID organizationId
) {
}
