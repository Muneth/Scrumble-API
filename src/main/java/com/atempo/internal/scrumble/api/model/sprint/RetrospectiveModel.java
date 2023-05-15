package com.atempo.internal.scrumble.api.model.sprint;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.atempo.internal.scrumble.api.model.SprintModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Resource pour une retrospective
 * 
 */
@Data
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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the sprint
	 */
	public SprintModel getSprint() {
		return sprint;
	}

	/**
	 * @param sprint the sprint to set
	 */
	public void setSprint(SprintModel sprint) {
		this.sprint = sprint;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the comments
	 */
	public List<CommentModel> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentModel> comments) {
		this.comments = comments;
	}
}