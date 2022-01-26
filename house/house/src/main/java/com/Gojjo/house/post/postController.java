package com.Gojjo.house.post;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;


@Controller
@SessionAttributes("createpost")
@RequiredArgsConstructor
public class postController {

    private final PostRepository repository;

    @Autowired
    PostService postService;

    @GetMapping("/createPost")
    public String showPostForm(Model model){
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping("/posts")
    public String postProcess(@Valid @ModelAttribute("post") Post post, Errors errors, SessionStatus status){
        if (errors.hasErrors()) {
            return "createPost";
        }
        this.repository.save(post);
        status.setComplete();
        return "redirect:/index";
    }

    @GetMapping("/postList")
    public String getPosts(Model model){
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable(name = "id") Long id){
        postService.deletePost(id);
        return "redirect:/postList";
    }

    @GetMapping("/deletePost/{id}")
    public String deleteUserPost(@PathVariable(name = "id") Long id){
        postService.deleteUserPost(id);
        return "redirect:/profile";
    }

    @GetMapping("/showEditForm/{id}")
    public String ShowEditForm(@PathVariable(name ="id") Long id, Model model){
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "editPost";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePost(@Valid @ModelAttribute("post") Post post, Errors errors, @RequestParam("image") MultipartFile multipartFile) throws IOException{
        if (errors.hasErrors()) {
            return "createPost";
        }
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            post.setImageFIle(fileName);
            Post savedPost = repository.save(post);
            String uploadDir = "user-photos/" + savedPost.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            postService.save(post);
        return "redirect:/homelist";
        }

}
