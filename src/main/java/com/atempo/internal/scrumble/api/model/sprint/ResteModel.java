package com.atempo.internal.scrumble.api.model.sprint;

import java.util.Date;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour un reste
 * 
 */
@Data
@Getter
@Setter
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
}
