package com.Gojjo.house.news;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.Gojjo.house.post.FileUploadUtil;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes("/news")
public class newsController {

    @Autowired
    private NewsRepository newsRepo;

    @Autowired
    private NewsService newsService;

    @GetMapping("/sendNews")
    public String showNewsForm(Model model){
        model.addAttribute("news", new News());
        return "newsForm";
    }


    @PostMapping("/saveNews")
    public String processNews(@Valid @ModelAttribute News news, Errors errors, SessionStatus status){
        
        if (errors.hasErrors()) {
            return "newsForm";
        }
        
        this.newsRepo.save(news);
        status.setComplete();
        return "redirect:/news";
    }

    @GetMapping("/news")
    public String getNews(Model model){
        List<News> news = newsService.findAllNews();
        model.addAttribute("news", news);

        return "news";
    }

    @RequestMapping(value = "/saveNewsForm", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("news") News news, Errors errors, @RequestParam("image") MultipartFile multipartFile) throws IOException{
        if (errors.hasErrors()) {
            return "newsForm";
        }
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            news.setImageFile(fileName);
            News savedPost = newsRepo.save(news);
            String uploadDir = "news-photos/" + savedPost.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            newsService.save(news);
        return "redirect:/news";
    }

    @GetMapping("/deleteNews/{id}")
    public String deleteNews(@PathVariable(name = "id") Long id){
        newsService.deleteNews(id);

        return "redirect:/newsList";
    }

    @GetMapping("/showNewsEditForm/{id}")
    public String ShowNewsEditForm(@PathVariable(name ="id") Long id, Model model){
        News news = newsService.findNewsById(id);
        model.addAttribute("news", news);

        return "editNews";
    }

    @GetMapping("/newsList")
    public String getPosts(Model model){
        List<News> news = newsService.findAllNews();
        model.addAttribute("news", news);

        return "newsList";
    }


   


}
