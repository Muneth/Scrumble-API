package com.atempo.internal.scrumble.api.model.sprint;

import java.util.Date;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.atempo.internal.scrumble.api.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Resource pour une repartition
 * 
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "repartition")
@Relation(collectionRelation = "repartitions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepartitionModel extends RepresentationModel<RepartitionModel> {

	@JsonProperty
	@JsonIgnore(value = false)
	private Long id;
	private Date date;
	private UserModel user;
	private Double points;
}
