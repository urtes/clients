package com.urte.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactService contactService;

    @GetMapping("/client/{id}")
    public List<Contact> getContacts(@PathVariable("id") long clientId,
                                     @RequestParam("sortByColumn") String sortByColumn,
                                     @RequestParam(value = "sortingOrder", defaultValue = "ASC") String sortingOrder) {

        Sort.Direction sort = sortingOrder.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        List<Contact> contacts = new ArrayList();

        if (sortByColumn.toLowerCase().equals("firstname")) {
            contacts = contactService.getSortedByFirstName(sort, clientId);
        }

        return contacts;
    }

    @PostMapping("/client/{id}")
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }
}
