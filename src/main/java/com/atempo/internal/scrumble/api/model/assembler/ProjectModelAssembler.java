package com.atempo.internal.scrumble.api.model.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.atempo.internal.scrumble.api.ProjectEndpoint;
import com.atempo.internal.scrumble.api.model.ProjectModel;
import com.atempo.internal.scrumble.entity.Project;

@Component
public class ProjectModelAssembler extends RepresentationModelAssemblerSupport<Project, ProjectModel> {

	@Autowired
	private ModelMapper mapper;

	public ProjectModelAssembler() {
		super(ProjectEndpoint.class, ProjectModel.class);
	}

	@Override
	public ProjectModel toModel(Project entity) {
		ProjectModel projectModel = mapper.map(entity, ProjectModel.class);

		projectModel.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProjectEndpoint.class).getProjectById(entity.getId())).withSelfRel());
		
		return projectModel;
	}

	@Override
	public CollectionModel<ProjectModel> toCollectionModel(Iterable<? extends Project> entities) {
		CollectionModel<ProjectModel> projectModels = super.toCollectionModel(entities);

		projectModels.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjectEndpoint.class).getAllProjects()).withSelfRel());

		return projectModels;
	}
}
