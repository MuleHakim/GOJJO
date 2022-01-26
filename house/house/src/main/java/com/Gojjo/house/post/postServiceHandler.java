package com.Gojjo.house.post;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class postServiceHandler implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return (List<Post>) postRepository.findAll(); 
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post findPostById(Long id) {
        Optional<Post> postResponse = postRepository.findById(id);
        Post post = null;
        if(postResponse.isPresent()){
            post = postResponse.get();
        }else{
            throw new RuntimeException("user with id -" + id + "does not exist.");
        }

        return post;
     }

    @Override
    public List<Post> findByKeyword(String keyword) {
        return postRepository.findByCity(keyword);
    }

    @Override
    public void save(Post post) {
       postRepository.save(post);
        
    }

    @Override
    public List<Post> findAllByUsername(String username) {
        return (List<Post>) postRepository.findAllByUsername(username);
    }

    @Override
    public void deleteUserPost(Long id) {
        postRepository.deleteById(id);
    }
}
