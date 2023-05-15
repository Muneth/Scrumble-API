package com.atempo.internal.scrumble.api.model.sprint;

import java.util.Date;

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
 * Resource pour un reste
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "reste")
@Relation(collectionRelation = "restes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResteModel extends RepresentationModel<ResteModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;

	private Date date;

	private Double points;

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the points
	 */
	public Double getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(Double points) {
		this.points = points;
	}
}
