package com.atempo.internal.scrumble.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atempo.internal.scrumble.entity.sprint.Comment;
import com.atempo.internal.scrumble.repository.CommentRepository;
import com.atempo.internal.scrumble.service.CommentService;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Comment> findById(Long id) {
		return commentRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Comment update(Comment comment) {
		Comment commentToUpdate = commentRepository.getOne(comment.getId());
		if (commentToUpdate == null) {
			throw new NoResultException();
		}
		mapper.map(comment, commentToUpdate);
		return comment;

	}
}
