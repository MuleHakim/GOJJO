package com.Gojjo.house.post;

import java.util.List;

public interface PostService {
    public List<Post> findAllPosts();

    public void deletePost(Long id);

    public Post findPostById(Long id);

    public List<Post> findByKeyword(String keyword);

    public void save(Post post);

    public  List<Post> findAllByUsername(String username);

    public void deleteUserPost(Long id);
}
