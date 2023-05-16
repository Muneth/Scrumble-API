package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.sprint.Repartition;

public interface RepartitionService {

	List<Repartition> findAll();

	Optional<Repartition> findById(Long id);

	void save(Repartition repartition);

	Repartition update(Repartition repartition);
}