package com.atempo.internal.scrumble.service.manager;

import com.atempo.internal.scrumble.entity.sprint.Retrospective;

public interface RetrospectiveManagerService {

	void saveOrUpdateComment(Retrospective retrospective);
}
