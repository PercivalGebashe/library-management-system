package com.github.percivalgebashe.organisation.dao;

import com.github.percivalgebashe.organisation.model.Organisation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrganisationjbdcDAO implements DAO<Organisation> {

    private static final Logger log = LoggerFactory.getLogger(OrganisationjbdcDAO.class);
    private JdbcTemplate jdbcTemplate;

    OrganisationjbdcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Organisation> getAll() {
        String sql = "select * from organisations";
        try {
            List<Organisation> orgs = jdbcTemplate.query(sql,new OrganisationRowMapper());
            log.info("Results Found: " + orgs.size());
            return orgs;
        }catch (DataAccessException e){
            log.error(e.getMessage());
            throw new DataAccessException(e.getMessage()) {
            };
        }

    }

    @Override
    public void create(Organisation organisation) {
        String sql = "INSERT INTO organisations (name, address, phone_number, email, status, created_at, updated_at)" +
                " values (?, ?, ?, ?, ?, ?, ?);";

        try {
            int affectedRows = jdbcTemplate.update(
                    sql,
                    organisation.getName(),
                    organisation.getAddress(),
                    organisation.getPhone(),
                    organisation.getEmail(),
                    organisation.getStatus().name(),
                    organisation.getCreated_at(),
                    organisation.getUpdated_at());
            if (affectedRows == 1) {
                log.info(String.format("%s created", organisation.getName()));
            }else {
                log.error(String.format("%s could not be created", organisation.getName()));
            }
        }catch (DataAccessException e){
            log.error(e.getMessage());
            throw new DataAccessException(e.getMessage()) {};
        }
    }

    @Override
    public Optional<Organisation> getById(UUID id) {
        String sql = "SELECT * FROM organisations WHERE id = ?";
        Organisation organisation = null;
        try {
            organisation = jdbcTemplate.queryForObject(sql, new OrganisationRowMapper(), id);
            if (organisation == null){
                log.info("Could not find organisation with id", id);
            }
        }catch (DataAccessException e){
            log.error(e.getMessage());
            throw new DataAccessException(e.getMessage()) {};
        }
        return Optional.ofNullable(organisation);
    }

    @Override
    public void update(Organisation organisation) {
        String sql = "UPDATE organisation SET name = ?, address = ?, phone_number = ?, email = ?, status = ?, updated_at = ? " +
                " WHERE id = ?";
        try {
            jdbcTemplate.update(sql,
                    organisation.getName(),
                    organisation.getAddress(),
                    organisation.getPhone(),
                    organisation.getEmail(),
                    organisation.getStatus().name(),
                    organisation.getCreated_at(),
                    organisation.getUpdated_at(),
                    organisation.getId());
        }catch (DataAccessException e){
            log.error(e.getMessage());
            throw new DataAccessException(e.getMessage()) {};
        }
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM organisations WHERE id = ?";

        try {
            jdbcTemplate.update(sql, id);
        }catch (DataAccessException e){
            log.error(e.getMessage());
            throw new DataAccessException(e.getMessage()) {};
        }
    }
}
