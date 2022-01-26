package com.Gojjo.house.request;
import java.util.Arrays;
import java.util.List;
// import java.util.Optional;

import javax.validation.Valid;

// import java.util.ArrayList;
// import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestRepository repo;

    @Autowired
    RequestService requestService;

    @ModelAttribute("request")
    public Request request(){
        return new Request();
    }
    
    @GetMapping("/request")
    public  String ShowRequestForm(Model model){

        List <String> types = Arrays.asList("Large","Middle","small","other");
        model.addAttribute("type", types);
        return "requestForm";
    }
    @PostMapping("/processrequest")
    public String requestProcess(@Valid @ModelAttribute("request")Request request,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "requestForm";
        }
        repo.save(request);
        return "redirect:/Success";
    }
    @GetMapping("/requestList")
    public String getAllRequests(Model model){
       List<Request> request= requestService.findAllRequests();
        model.addAttribute("request",request);
        return "requestList";
    }
    @GetMapping("/remove/{id}")
    public String deleteRequest(@PathVariable(value = "id") Long id){
        requestService.deleteRequest(id);
        return "redirect:/requestList";
    }
    @GetMapping("/Success")
    public String SuccessMsg(){
        return "Successmsg";
    }
    
    
}