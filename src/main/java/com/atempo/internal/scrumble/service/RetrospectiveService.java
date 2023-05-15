package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.sprint.Retrospective;

public interface RetrospectiveService {

	List<Retrospective> findAll();

	Optional<Retrospective> findById(Long id);

	void save(Retrospective retrospective);

	Retrospective update(Retrospective retrospective);
}
