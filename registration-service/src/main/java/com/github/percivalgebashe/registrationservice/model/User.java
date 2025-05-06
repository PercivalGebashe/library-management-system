package com.github.percivalgebashe.registrationservice.model;

import com.github.percivalgebashe.registrationservice.enums.Role;
import com.github.percivalgebashe.registrationservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private Status status;
    private Role role;
    private UUID organizationId;
    private Timestamp created_at;
    private Timestamp updated_at;
}