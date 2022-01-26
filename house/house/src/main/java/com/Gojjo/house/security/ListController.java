package com.Gojjo.house.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ListController {

    @Autowired
    UserService userService;
    

    @GetMapping("/UserList")
    public String getUserList(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "UserList";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
        return "redirect:/UserList";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
        return "redirect:/login";
    }

    @GetMapping("/showUserEditForm/{id}")
    public String showUserEditForm(@PathVariable(name ="id") Long id, Model model){
       
        User user = userService.findUserById(id);
        model.addAttribute("user", user);

        return "editUser";
    }
}

