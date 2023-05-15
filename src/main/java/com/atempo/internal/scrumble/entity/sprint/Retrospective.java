package com.atempo.internal.scrumble.entity.sprint;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.atempo.internal.scrumble.entity.Sprint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Entity Retrospective
 */
@Schema(description = "Entity Retrospective")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_sprint_retrospective", uniqueConstraints = @UniqueConstraint(columnNames = { "sprint_id" }))
public class Retrospective implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Date creationDate;

	@NotNull
	@OneToOne(fetch=FetchType.EAGER)
  	@JoinColumn(name = "sprint_id")
	private Sprint sprint;
	
	@OneToMany(targetEntity=Comment.class, mappedBy="retrospective")
	private List<Comment> comments;

}
