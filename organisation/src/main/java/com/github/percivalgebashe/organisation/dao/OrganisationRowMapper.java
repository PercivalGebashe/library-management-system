package com.github.percivalgebashe.organisation.dao;

import com.github.percivalgebashe.organisation.enums.OrgStatus;
import com.github.percivalgebashe.organisation.model.Organisation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrganisationRowMapper implements RowMapper<Organisation> {

    @Override
    public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organisation organisation = new Organisation();

        organisation.setId(rs.getString("id"));
        organisation.setName(rs.getString("name"));
        organisation.setAddress(rs.getString("address"));
        organisation.setPhone(rs.getString("phone_number"));
        organisation.setEmail(rs.getString("email"));
        organisation.setStatus(OrgStatus.valueOf(rs.getString("status")));
        organisation.setCreated_at(Timestamp.valueOf(rs.getString("created_at")));
        organisation.setUpdated_at(Timestamp.valueOf(rs.getString("updated_at")));

        return organisation;

    }
}
