package com.Gojjo.house.news;

import java.util.List;

public interface NewsService {

    List<News> findAllNews();

    void save(News news);

    void deleteNews(Long id);

    News findNewsById(Long id);
}
