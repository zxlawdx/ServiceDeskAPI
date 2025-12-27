package com.example.servicedesk.ui.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.example.servicedesk.entity.Client;
import com.example.servicedesk.ui.interfaces.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clients")//http://localhost:8080/clients
public class ClientController {
    private final ClientService service;    
    private Client client;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findByName(
        @RequestParam(required = false) String name) {
        
        if(name == null) {
            List<Client> clients = service.findAll();
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } else {
            List<Client> clients = service.findByName(name);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(
        @RequestParam String name
    ) {
        Client newClient = service.createClient(name);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

}