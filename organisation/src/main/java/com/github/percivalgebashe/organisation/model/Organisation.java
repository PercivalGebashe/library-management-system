package com.github.percivalgebashe.organisation.model;

import com.github.percivalgebashe.organisation.enums.OrgStatus;
import com.github.percivalgebashe.organisation.enums.OrgType;
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
    private OrgStatus status;
    private OrgType type;
    private Timestamp created_at;
    private Timestamp updated_at;
}
