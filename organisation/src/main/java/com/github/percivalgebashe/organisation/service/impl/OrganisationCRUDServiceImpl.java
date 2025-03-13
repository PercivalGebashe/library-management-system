package com.github.percivalgebashe.organisation.service.impl;

import com.github.percivalgebashe.organisation.dao.OrganisationjbdcDAO;
import com.github.percivalgebashe.organisation.exception.ResourceNotFoundException;
import com.github.percivalgebashe.organisation.model.Organisation;
import com.github.percivalgebashe.organisation.service.OrganisationCRUDService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganisationCRUDServiceImpl implements OrganisationCRUDService {

    private final OrganisationjbdcDAO organisationDao;

    OrganisationCRUDServiceImpl(OrganisationjbdcDAO organisationDao) {
        this.organisationDao = organisationDao;
    }
    @Override
    public List<Organisation> getAll() {
        return organisationDao.getAll();
    }

    @Override
    public void create(Organisation organisation) {
        organisation.setId(generateId());
        organisationDao.create(organisation);
    }

    @Override
    public Organisation getById(String id) throws ResourceNotFoundException {
        return organisationDao.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No organisation found with %s: ", id)));
    }

    @Override
    public void update(Organisation organisation) {
        organisationDao.update(organisation);
    }

    @Override
    public void delete(String id) {
        try {
            organisationDao.delete(id);
        }catch (DataAccessException e){
            throw new ResourceNotFoundException(String.format("No organisation found with %s: ", id));
        }
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
