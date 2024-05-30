package dev.ali.JPAUserAuth.listener;

import dev.ali.JPAUserAuth.entity.Post;
import jakarta.persistence.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PostListener {
    private static Log log = LogFactory.getLog(PostListener.class);

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Post post) {
        if (post.getId() == 0) {
            log.info("[POST AUDIT] About to add a post");
        } else {
            log.info("[POST AUDIT] About to update/delete post: " + post.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Post post) {
        log.info("[POST AUDIT] add/update/delete complete for post: " + post.getId());
    }

    @PostLoad
    private void afterLoad(Post user) {
        log.info("[POST AUDIT] post loaded from database: " + user.getId());
    }
}
