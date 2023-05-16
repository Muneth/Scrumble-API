package com.atempo.internal.scrumble.api.model.sprint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "label")
@Relation(collectionRelation = "labels")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelModel extends RepresentationModel<LabelModel> {

    @JsonProperty
    @JsonIgnore(value = false)
    private Long id;
    private String name;
    private String key;
}
