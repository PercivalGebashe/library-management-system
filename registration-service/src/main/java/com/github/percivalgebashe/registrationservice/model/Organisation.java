package com.github.percivalgebashe.registrationservice.model;

import com.github.percivalgebashe.registrationservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Organisation {
    @Id
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Status status;
    private Timestamp created_at;
    private Timestamp updated_at;
}

