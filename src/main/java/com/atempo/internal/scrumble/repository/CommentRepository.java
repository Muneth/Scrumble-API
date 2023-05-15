package com.atempo.internal.scrumble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atempo.internal.scrumble.entity.sprint.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
