package com.github.percivalgebashe.organisation.service;

import com.github.percivalgebashe.organisation.exception.ResourceNotFoundException;
import com.github.percivalgebashe.organisation.model.Organisation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationCRUDService {

    List<Organisation> getAll();

    void create(Organisation organisation);

    Organisation getById(UUID id) throws ResourceNotFoundException;

    void update(Organisation organisation);

    void delete(UUID id);
}
