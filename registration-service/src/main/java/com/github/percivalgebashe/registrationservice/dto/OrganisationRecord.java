package com.github.percivalgebashe.registrationservice.dto;

import com.github.percivalgebashe.registrationservice.enums.Status;

public record OrganisationRecord(
        String id,
        String name,
        String address,
        String phone,
        String email,
        Status status) {
}
