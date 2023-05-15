package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.Sprint;

public interface SprintService {

	List<Sprint> findAll();

	List<Sprint> findByProjectId(Long projectId);
	
	Sprint findByTeamAndKey(Long teamId, Long key);

	Optional<Sprint> findById(Long id);

	void save(Sprint sprint);

	Sprint update(Sprint sprint);
}
