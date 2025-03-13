package com.github.percivalgebashe.organisation.dao;

import com.github.percivalgebashe.organisation.enums.OrgStatus;
import com.github.percivalgebashe.organisation.model.Organisation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrganisationRowMapper implements RowMapper<Organisation> {

    @Override
    public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organisation organisation = new Organisation();

        organisation.setId(UUID.fromString(rs.getString("id")));
        organisation.setName(rs.getString("name"));
        organisation.setAddress(rs.getString("address"));
        organisation.setPhone(rs.getString("phone_number"));
        organisation.setEmail(rs.getString("email"));
        organisation.setStatus(OrgStatus.valueOf(rs.getString("status")));
        organisation.setCreated_at(LocalDateTime.parse(rs.getString("created_at")));
        organisation.setUpdated_at(LocalDateTime.parse(rs.getString("updated_at")));

        return organisation;

    }
}
