package com.Gojjo.house.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class httpController {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/homelist")
    public String getPosts(Model model, String keyword){
        List<Post> postList = postService.findByKeyword(keyword);
        List<Post> posts = postService.findAllPosts();
        if(keyword != null){
            model.addAttribute("postList", postList);
        }else{
            model.addAttribute("posts", posts);
        }
        return "homelist";
    }

    
    
}
