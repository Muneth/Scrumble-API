package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.sprint.Reste;

public interface ResteService {

	List<Reste> findAll();

	Optional<Reste> findById(Long id);

	void save(Reste reste);

	Reste update(Reste reste);
}
