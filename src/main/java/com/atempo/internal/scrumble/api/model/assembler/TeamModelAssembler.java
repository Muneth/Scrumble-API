package com.atempo.internal.scrumble.api.model.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.atempo.internal.scrumble.api.TeamEndpoint;
import com.atempo.internal.scrumble.api.model.TeamModel;
import com.atempo.internal.scrumble.entity.Team;

@Component
public class TeamModelAssembler extends RepresentationModelAssemblerSupport<Team, TeamModel> {

	@Autowired
	private ModelMapper mapper;

	public TeamModelAssembler() {
		super(TeamEndpoint.class, TeamModel.class);
	}

	@Override
	public TeamModel toModel(Team entity) {
		TeamModel teamModel = mapper.map(entity, TeamModel.class);

		teamModel.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TeamEndpoint.class).getTeamById(entity.getId())).withSelfRel());

		return teamModel;
	}

	@Override
	public CollectionModel<TeamModel> toCollectionModel(Iterable<? extends Team> entities) {
		CollectionModel<TeamModel> teamModels = super.toCollectionModel(entities);

		teamModels.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamEndpoint.class).getAllTeams()).withSelfRel());

		return teamModels;
	}
}
