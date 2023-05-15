package com.atempo.internal.scrumble.entity.sprint;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Entity Comment
 */
@Schema(description = "Entity Comment")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_sprint_retrospective_comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String username;

	@NotNull
	private String positive;

	@NotNull
	private String negative;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "retrospective_id")
	private Retrospective retrospective;

}
