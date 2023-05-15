package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.Project;

public interface ProjectService {

	List<Project> findAll();

	Optional<Project> findById(Long id);

	void save(Project project);

	Project update(Project project);
}
