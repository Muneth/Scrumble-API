package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.sprint.Comment;

public interface CommentService {

	List<Comment> findAll();

	Optional<Comment> findById(Long id);

	void save(Comment comment);

	Comment update(Comment comment);
}
