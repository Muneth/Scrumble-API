package com.atempo.internal.scrumble.api.model;

import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.atempo.internal.scrumble.api.model.sprint.RepartitionModel;
import com.atempo.internal.scrumble.api.model.sprint.ResteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour un sprint
 * 
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "sprint")
@Relation(collectionRelation = "sprints")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SprintModel extends RepresentationModel<SprintModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private Long key;
	private Date creationDate;
	private Date startDate;
	private Date endDate;
	private String goal;
	private Long jiraId;
	private String jiraName;
	private Double velocity;
	private Double points;
	private Boolean active;
	private TeamModel team;
	private ProjectModel project;
	private List<RepartitionModel> repartitions;
	private List<ResteModel> restes;
}
