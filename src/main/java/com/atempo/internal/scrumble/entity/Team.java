package com.atempo.internal.scrumble.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Entity Team
 */
@Schema(description = "Entity Team")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_team")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	private Integer daysPerSprint;
	private Double velocity;
	private Long boardId;
	
	@OneToMany(targetEntity=User.class, mappedBy="team")
	private List<User> users;
}
