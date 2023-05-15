package com.atempo.internal.scrumble.api.model.sprint;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

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
 * Resource pour un comment
 * 
 */
@Data
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
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the positive
	 */
	public String getPositive() {
		return positive;
	}

	/**
	 * @param positive the positive to set
	 */
	public void setPositive(String positive) {
		this.positive = positive;
	}

	/**
	 * @return the negative
	 */
	public String getNegative() {
		return negative;
	}

	/**
	 * @param negative the negative to set
	 */
	public void setNegative(String negative) {
		this.negative = negative;
	}
}