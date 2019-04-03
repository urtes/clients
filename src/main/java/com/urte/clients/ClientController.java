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

        Sort.Direction sort = sortingOrder.toUpperCase().equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        List<Contact> contacts = new ArrayList();

        switch (sortByColumn.toLowerCase()) {
            case "firstname":
                contacts = contactService.getSortedByFirstName(sort, clientId);
                break;
            case "lastname":
                contacts = contactService.getSortedByLastName(sort, clientId);
                break;
            case "company":
                contacts = contactService.getSortedByCompany(sort, clientId);
                break;
            case "address":
                contacts = contactService.getSortedByAddress(sort, clientId);
                break;
            case "phone":
                contacts = contactService.getSortedByPhone(sort, clientId);
                break;
            case "birthday":
                contacts = contactService.getSortedByBirthday(sort, clientId);
                break;
            default:
                contacts = contactService.getSortedByFirstName(sort, clientId);
        }

        return contacts;
    }

    @PostMapping("/client/{id}")
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }
}
