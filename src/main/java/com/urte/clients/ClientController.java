package com.urte.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/client/{id}")
    public String getContacts(@PathVariable("id") long id) {
        return "test GetMapping " + id;
    }

//    @PostMapping("/client/{id}")
//    public Contact addContact(@RequestBody Contact contact) {
//        return clientRepository.save(contact);
//    }

    @PostMapping("/client/{id}")
    public void addContact(@RequestBody Contact contact) {
        clientRepository.save(contact);
        System.out.println(clientRepository.findById(1L));
    }
}
