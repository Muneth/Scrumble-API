package com.atempo.internal.scrumble.api.model.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.atempo.internal.scrumble.api.SprintEndpoint;
import com.atempo.internal.scrumble.api.model.SprintModel;
import com.atempo.internal.scrumble.entity.Sprint;

@Component
public class SprintModelAssembler extends RepresentationModelAssemblerSupport<Sprint, SprintModel> {

	@Autowired
	private ModelMapper mapper;

	/**
	 * @param controllerClass
	 * @param resourceType
	 */
	public SprintModelAssembler() {
		super(SprintEndpoint.class, SprintModel.class);
	}

	@Override
	public SprintModel toModel(Sprint entity) {
		SprintModel sprintModel = mapper.map(entity, SprintModel.class);

		sprintModel.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(SprintEndpoint.class).getSprintById(entity.getId())).withSelfRel());

		return sprintModel;
	}

	public CollectionModel<SprintModel> toCollectionModelFromProjectId(Iterable<? extends Sprint> entities,
			Long ProjectId) {
		CollectionModel<SprintModel> sprintModels = super.toCollectionModel(entities);

		sprintModels.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SprintEndpoint.class).getAllSprintsByProjectId(ProjectId))
				.withSelfRel());

		return sprintModels;
	}
}
