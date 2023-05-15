package com.atempo.internal.scrumble.api.model;

import java.time.LocalDate;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour un projet
 * 
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "project")
@Relation(collectionRelation = "projects")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectModel extends RepresentationModel<ProjectModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private String code;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String description;
}