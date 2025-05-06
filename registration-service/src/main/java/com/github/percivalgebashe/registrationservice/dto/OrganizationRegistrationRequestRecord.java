package com.github.percivalgebashe.registrationservice.dto;

public record OrganizationRegistrationRequestRecord(
        String name,
        String address,
        String phone,
        String email
) {
}
