package com.Gojjo.house.news;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class newsServiceHandler implements NewsService{

    @Autowired
    private NewsRepository newsRepo;
    
    @Override
    public List<News> findAllNews() {
        return (List<News>) newsRepo.findAll();
    }

    @Override
    public void save(News news) {
        newsRepo.save(news);
        
    }

    @Override
    public void deleteNews(Long id) {
        newsRepo.deleteById(id);
    }

    @Override
    public News findNewsById(Long id) {
        Optional<News> newsResponse = newsRepo.findById(id);
        News news = null;
        if(newsResponse.isPresent()){
            news = newsResponse.get();
        }else{
            throw new RuntimeException("news with id -" + id + "does not exist.");
        }
        return news;
     }

}
