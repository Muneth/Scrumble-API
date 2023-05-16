package com.atempo.internal.scrumble.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.atempo.internal.scrumble.entity.sprint.RepartitionLabel;
import com.atempo.internal.scrumble.entity.sprint.Reste;
import com.atempo.internal.scrumble.entity.sprint.Repartition;
import com.atempo.internal.scrumble.entity.sprint.Retrospective;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Entity Sprint
 */
@Schema(description = "Entity Sprint")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_sprint", uniqueConstraints = @UniqueConstraint(columnNames = { "key", "team_id" }))
public class Sprint implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Long key;
	@NotNull
	private Date creationDate;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	private String goal;
	private Double velocity;
	private Double points;
	private Boolean active;
	private Long jiraId;
	private String jiraName;
	
	@OneToMany(targetEntity=Repartition.class, mappedBy="sprint")
	private List<Repartition> repartitions;
	
	@OneToMany(targetEntity=Reste.class, mappedBy="sprint")
	private List<Reste> restes;

	@OneToMany(targetEntity= RepartitionLabel.class, mappedBy="sprint")
	private List<RepartitionLabel> repartitionLabels;

	@OneToOne(mappedBy = "sprint")
  	@PrimaryKeyJoinColumn
	private Retrospective retrospective;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;
}
