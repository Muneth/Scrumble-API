package com.atempo.internal.scrumble.api.model.sprint;

import com.atempo.internal.scrumble.api.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 * Resource pour une repartitionLabel
 *
 */
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "repartitionLabel")
@Relation(collectionRelation = "repartitionLabels")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepartitionLabelModel extends RepresentationModel<RepartitionModel> {

    @JsonProperty
    @JsonIgnore(value = false)
    private Long id;
    private LabelModel label;
    private Double points;
    private UserModel user;
}
