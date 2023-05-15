package com.atempo.internal.scrumble.api.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour une equipe
 *
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "team")
@Relation(collectionRelation = "teams")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamModel extends RepresentationModel<TeamModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private String name;
	private Integer daysPerSprint;
	private Double velocity;
	private Long boardId;
}