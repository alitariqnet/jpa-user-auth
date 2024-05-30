package dev.ali.JPAUserAuth.repository;

import dev.ali.JPAUserAuth.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
