package com.atempo.internal.scrumble.api.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour un user
 * 
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel extends RepresentationModel<UserModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private String key;
	private String name;
	private String emailAddress;
	private String displayName;
	private Boolean active;
	private String avatarSmall;
	private String avatarMedium;
	private String avatarLarge;
	private String avatarBig;
	private TeamModel team;
}