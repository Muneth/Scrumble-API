package com.atempo.internal.scrumble.api.model.sprint;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour un comment
 * 
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "comment")
@Relation(collectionRelation = "comments")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentModel extends RepresentationModel<CommentModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private String username;
	private String positive;
	private String negative;
}