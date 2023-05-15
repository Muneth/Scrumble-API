package com.atempo.internal.scrumble.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atempo.internal.scrumble.api.model.ProjectModel;
import com.atempo.internal.scrumble.api.model.assembler.ProjectModelAssembler;
import com.atempo.internal.scrumble.entity.Project;
import com.atempo.internal.scrumble.service.ProjectService;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectEndpoint {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectModelAssembler projectModelAssembler;

	@GetMapping
	public ResponseEntity<CollectionModel<ProjectModel>> getAllProjects() {
		List<Project> projectEntities = projectService.findAll();
		return new ResponseEntity<>(projectModelAssembler.toCollectionModel(projectEntities), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectModel> getProjectById(@PathVariable("id") Long id) {
		return projectService.findById(id).map(projectModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
