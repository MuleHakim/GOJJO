package com.Gojjo.house.security;

import java.security.Principal;

import com.Gojjo.house.post.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class profileController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;
    
    @RequestMapping(value = "/profile")
    public String profile(Principal principal, Model model){
        String username = principal.getName();
        User currentUser = (User) userService.findByUsername(username);
        if(currentUser.getRole().equals("ADMIN")){
            model.addAttribute("user", userService.findByUsername(username));
            model.addAttribute("userPost", postService.findAllByUsername(username));

            return "adminProfile";
        }else{
            model.addAttribute("user", userService.findByUsername(username));
            model.addAttribute("userPost", postService.findAllByUsername(username));

            return "userProfile";
        }
    }

    // @GetMapping("/updateProfile/{id}")
    // public String showUpdateForm(Principal principal, Model model){
    //     String username = principal.getName();

    //     model.addAttribute("user", userService.findUserByUsername(username));
    //     return "editAccount";
    // }
    @GetMapping("/updateProfile/{id}")
    public String updateUserbyId(@PathVariable(value="id") Long id,Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user",user);
        return "editAccount";
    }

}
