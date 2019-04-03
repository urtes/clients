package com.urte.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/client/{id}")
    public String retrieveClientsContacts(@PathVariable("id") int id) {
        return "test GetMapping " + id;
    }
}
