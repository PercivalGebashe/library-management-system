package com.github.percivalgebashe.organisation.service;

import com.github.percivalgebashe.organisation.exception.ResourceNotFoundException;
import com.github.percivalgebashe.organisation.model.Organisation;

import java.util.List;

public interface OrganisationCRUDService {

    List<Organisation> getAll();

    void create(Organisation organisation);

    Organisation getById(String id) throws ResourceNotFoundException;

    void update(Organisation organisation);

    void delete(String id) throws ResourceNotFoundException;
}
