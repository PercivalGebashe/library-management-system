package com.github.percivalgebashe.organisation.controller;

import com.github.percivalgebashe.organisation.model.Organisation;
import com.github.percivalgebashe.organisation.service.OrganisationCRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrganisationRestController {

    private final OrganisationCRUDService service;
    private Logger logger = LoggerFactory.getLogger(OrganisationRestController.class);

    OrganisationRestController(OrganisationCRUDService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Organisation>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<Organisation> getById(@PathVariable String id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<Organisation> create(@RequestBody Organisation organisation){
        service.create(organisation);
        return new ResponseEntity<>(organisation, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity update(@RequestBody Organisation organisation){
        service.update(organisation);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
