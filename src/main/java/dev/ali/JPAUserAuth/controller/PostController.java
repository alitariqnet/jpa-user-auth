package dev.ali.JPAUserAuth.controller;

import dev.ali.JPAUserAuth.entity.Post;
import dev.ali.JPAUserAuth.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public Iterable findAll(){
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public Post findById(@PathVariable Post post){
        return post;
    }
}
