package com.Gojjo.house.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements   WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/homelist").setViewName("homelist");
        registry.addViewController("/createPost").setViewName("createPost");
        registry.addViewController("/UserList").setViewName("UserList");
        registry.addViewController("/editPost/{id}").setViewName("editPost/{id}");
        registry.addViewController("/adminProfile").setViewName("adminProfile");
        registry.addViewController("/userProfile").setViewName("userProfile");
        registry.addViewController("/newsForm").setViewName("newsForm");
        registry.addViewController("/news").setViewName("news");
        registry.addViewController("/newsList").setViewName("newsList");
        //registry.addViewController("/reques").setViewName("newsList");
    }
}

