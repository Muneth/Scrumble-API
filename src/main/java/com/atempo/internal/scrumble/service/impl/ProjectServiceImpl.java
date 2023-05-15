package com.atempo.internal.scrumble.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atempo.internal.scrumble.entity.Project;
import com.atempo.internal.scrumble.repository.ProjectRepository;
import com.atempo.internal.scrumble.service.ProjectService;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Project project) {
		projectRepository.save(project);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Project> findById(Long id) {
		return projectRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Project update(Project project) {
		Project projectToUpdate = projectRepository.getOne(project.getId());
		if (projectToUpdate == null) {
			throw new NoResultException();
		}
		mapper.map(project, projectToUpdate);
		return project;

	}
}
