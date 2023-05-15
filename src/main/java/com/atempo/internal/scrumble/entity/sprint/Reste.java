package com.atempo.internal.scrumble.entity.sprint;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.atempo.internal.scrumble.entity.Sprint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Entity Repartition
 */
@Schema(description = "Entity Reste")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_sprint_reste")
public class Reste implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Date date;

	@NotNull
	private Double points;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;

}
