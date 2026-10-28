package dev.ali.JPAUserAuth.repository;

import dev.ali.JPAUserAuth.entity.Post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
