package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.Team;

public interface TeamService {

	List<Team> findAll();

	Optional<Team> findById(Long id);

	void save(Team team);

	Team update(Team team);

	void deleteById(Long id);

}
