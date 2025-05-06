package com.github.percivalgebashe.registrationservice.dto;

import com.github.percivalgebashe.registrationservice.enums.Role;
import com.github.percivalgebashe.registrationservice.enums.Status;

import java.util.UUID;

public record UserRecord(String name, String email, Status status, Role role, UUID organizationId) {
}
