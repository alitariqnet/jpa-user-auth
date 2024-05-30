package dev.ali.JPAUserAuth.service;

import dev.ali.JPAUserAuth.entity.Post;
import dev.ali.JPAUserAuth.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostService {
    private PostRepository postRepository;

    public void save(Post post){
        postRepository.save(post);
    }
    public void delete(Long id){
        postRepository.deleteById(id);
    }
    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }

    public Iterable findAll() {
        return postRepository.findAll();
    }
}
