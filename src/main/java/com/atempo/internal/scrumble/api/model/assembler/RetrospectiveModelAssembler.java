package com.atempo.internal.scrumble.api.model.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.atempo.internal.scrumble.api.RetrospectiveEndpoint;
import com.atempo.internal.scrumble.api.model.sprint.RetrospectiveModel;
import com.atempo.internal.scrumble.entity.sprint.Retrospective;

@Component
public class RetrospectiveModelAssembler extends RepresentationModelAssemblerSupport<Retrospective, RetrospectiveModel> {

	@Autowired
	private ModelMapper mapper;

	public RetrospectiveModelAssembler() {
		super(RetrospectiveEndpoint.class, RetrospectiveModel.class);
	}

	@Override
	public RetrospectiveModel toModel(Retrospective entity) {
		RetrospectiveModel retrospectiveModel = mapper.map(entity, RetrospectiveModel.class);

		retrospectiveModel.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(RetrospectiveEndpoint.class).getRetrospectiveById(entity.getId())).withSelfRel());

		return retrospectiveModel;
	}

	@Override
	public CollectionModel<RetrospectiveModel> toCollectionModel(Iterable<? extends Retrospective> entities) {
		CollectionModel<RetrospectiveModel> retrospectiveModels = super.toCollectionModel(entities);

		retrospectiveModels.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RetrospectiveEndpoint.class).getAllRetrospectives()).withSelfRel());

		return retrospectiveModels;
	}
}
