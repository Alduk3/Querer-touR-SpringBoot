package com.riwi.querertourapi.domain.repositories;

import com.riwi.querertourapi.domain.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
