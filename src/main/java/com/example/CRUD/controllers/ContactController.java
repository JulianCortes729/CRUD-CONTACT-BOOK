package com.example.CRUD.controllers;

import com.example.CRUD.entities.Contact;
import com.example.CRUD.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class ContactController {

    @Autowired
    private ContactService service;


    @GetMapping({"/contacts","/"})
    public String allContacts(Model model){
        model.addAttribute("allContacts",service.findAllContacts());
        return "index";
    }


    @GetMapping("/contacts/new")
    public String contactLog(Model model){
        Contact newContact = new Contact();
        model.addAttribute("contactNew",newContact);
        return "log";
    }


    @PostMapping("/contacts")
    public String saveContact(@ModelAttribute("contactNew") Contact contact){
        service.saveContact(contact);

        return "redirect:/contacts";
    }


    @GetMapping("/contacts/update/{id}")
    public String updateLog(@PathVariable Long id, Model model){

        Optional<Contact> op = service.findByIdContact(id);
        if(op.isPresent()){

            model.addAttribute("updateContact",op.get());

            return "update";
        }

        return "redirect:/contacts";
    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute("updateContact") Contact contact, Model model){

        Optional<Contact> op = service.findByIdContact(id);

        if(op.isPresent()){

            op.get().setEmail(contact.getEmail());
            op.get().setName(contact.getName());
            op.get().setSurname(contact.getSurname());
            op.get().setCellPhone(contact.getCellPhone());

            service.updateContact(op.get());

            return "redirect:/contacts";
        }

        return "redirect:/contacts";


    }


    @GetMapping("/contacts/{id}")
    public String deleteContact(@PathVariable Long id){
        service.deleteContactById(id);
        return "redirect:/contacts";
    }





}
