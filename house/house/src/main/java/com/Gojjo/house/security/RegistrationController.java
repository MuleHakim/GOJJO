package com.Gojjo.house.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class RegistrationController {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @ModelAttribute("signUpForm")
    public RegistrationForm registrationForm() {
        return new RegistrationForm();
    }

    @GetMapping
    public String register(Model model){
        return "signup";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute("signUpForm") RegistrationForm form, BindingResult bindingResult) {

        User existingUser = userService.findUserByUsername(form.getUsername());
        if (existingUser != null) {
            bindingResult.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
