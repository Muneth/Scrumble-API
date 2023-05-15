package com.atempo.internal.scrumble.api.model.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.atempo.internal.scrumble.api.TeamEndpoint;
import com.atempo.internal.scrumble.api.UserEndpoint;
import com.atempo.internal.scrumble.api.model.UserModel;
import com.atempo.internal.scrumble.entity.User;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {

	@Autowired
	private ModelMapper mapper;

	public UserModelAssembler() {
		super(UserEndpoint.class, UserModel.class);
	}

	@Override
	public UserModel toModel(User entity) {
		UserModel userModel = mapper.map(entity, UserModel.class);

		userModel.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(UserEndpoint.class).getUserById(entity.getId())).withSelfRel());

		return userModel;
	}

	@Override
	public CollectionModel<UserModel> toCollectionModel(Iterable<? extends User> entities) {
		CollectionModel<UserModel> userModels = super.toCollectionModel(entities);

		userModels.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserEndpoint.class).getAllUsers()).withSelfRel());

		return userModels;
	}

	public CollectionModel<UserModel> toCollectionModelFromTeamId(Iterable<? extends User> entities,
			Long teamId) {
		CollectionModel<UserModel> sprintModels = super.toCollectionModel(entities);

		sprintModels.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamEndpoint.class).getUsersByTeamId(teamId))
				.withSelfRel());

		return sprintModels;
	}
}
