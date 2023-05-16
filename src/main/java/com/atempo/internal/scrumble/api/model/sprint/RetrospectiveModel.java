package com.atempo.internal.scrumble.api.model.sprint;

import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.atempo.internal.scrumble.api.model.SprintModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour une retrospective
 * 
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "retrospective")
@Relation(collectionRelation = "retrospectives")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetrospectiveModel extends RepresentationModel<RetrospectiveModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private Date creationDate;
	private SprintModel sprint;
	private List<CommentModel> comments;
}