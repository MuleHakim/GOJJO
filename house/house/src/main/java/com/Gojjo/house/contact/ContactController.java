package com.Gojjo.house.contact;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository repo;
    
    @GetMapping("/contact")
    public String showContact(Model model){
        model.addAttribute("contact", new Contact());

        return "contact";
    }

    @PostMapping("/contact")
	public String saveContact(@Valid Contact contact,Errors errors, Model model) {
    if(errors.hasErrors()){
        return "contact";
    }else{
        this.repo.save(contact);
        model.addAttribute("contact",contact);

        return "redirect:/index";  
        
	}
    
    }

    @GetMapping("/comment")
    public String showComments(Model model) {

        List<Contact> contact = repo.findAll();
        model.addAttribute("contact", contact);

        return "comment";
}
}
