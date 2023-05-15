package com.atempo.internal.scrumble.service.manager.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atempo.internal.scrumble.entity.sprint.Comment;
import com.atempo.internal.scrumble.entity.sprint.Retrospective;
import com.atempo.internal.scrumble.service.CommentService;
import com.atempo.internal.scrumble.service.RetrospectiveService;
import com.atempo.internal.scrumble.service.manager.RetrospectiveManagerService;

@Service("retrospectiveManagerService")
@Transactional
public class RetrospectiveManagerServiceImpl implements RetrospectiveManagerService {

	@Autowired
	RetrospectiveService retrospectiveService;

	@Autowired
	CommentService commentService;

	public void saveOrUpdateComment(Retrospective retrospective) {
		Comment comment = retrospective.getComments().get(0);
		if (comment.getId() == null) {
			comment.setRetrospective(retrospective);
			commentService.save(comment);
		} else {
			commentService.update(comment);
		}
	}
}
