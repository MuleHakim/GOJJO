package com.Gojjo.house.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value="select * from Post post where post.city like %:keyword%", nativeQuery = true)
    public List<Post> findByCity(@Param ("keyword") String keyword);

    public Object findAllById(String username);

    public List<Post> findAllByUsername(String username);
    
}


