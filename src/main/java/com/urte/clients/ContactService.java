package com.urte.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getSortedByFirstName(Sort.Direction sortDirection, Long clientId) {
        return contactRepository.findByClientId(clientId, sortByFirstName(sortDirection));
    }

    public List<Contact> getSortedByLastName(Sort.Direction sortDirection, Long clientId) {
        return contactRepository.findByClientId(clientId, sortByLastName(sortDirection));
    }

    public List<Contact> getSortedByCompany(Sort.Direction sortDirection, Long clientId) {
        return contactRepository.findByClientId(clientId, sortByCompany(sortDirection));
    }

    public List<Contact> getSortedByAddress(Sort.Direction sortDirection, Long clientId) {
        return contactRepository.findByClientId(clientId, sortByAddress(sortDirection));
    }

    public List<Contact> getSortedByBirthday(Sort.Direction sortDirection, Long clientId) {
        return contactRepository.findByClientId(clientId, sortByBirthday(sortDirection));
    }

    private Sort sortByFirstName(Sort.Direction sortDirection) {
        return new Sort(sortDirection, "firstName");
    }

    private Sort sortByLastName(Sort.Direction sortDirection) {
        return new Sort(sortDirection, "lastName");
    }

    private Sort sortByCompany(Sort.Direction sortDirection) {
        return new Sort(sortDirection, "company");
    }

    private Sort sortByAddress(Sort.Direction sortDirection) {
        return new Sort(sortDirection, "address");
    }

    private Sort sortByBirthday(Sort.Direction sortDirection) {
        return new Sort(sortDirection, "birthday");
    }
}
