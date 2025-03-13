package com.github.percivalgebashe.organisation.controller;

import com.github.percivalgebashe.organisation.model.Organisation;
import com.github.percivalgebashe.organisation.service.OrganisationCRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organisations")
public class OrganisationCRUDRestController {

    private final OrganisationCRUDService service;
    private Logger logger = LoggerFactory.getLogger(OrganisationCRUDRestController.class);

    OrganisationCRUDRestController(OrganisationCRUDService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Organisation>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<Organisation> getById(@PathVariable UUID id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
}
