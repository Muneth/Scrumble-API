package com.atempo.internal.scrumble.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.atempo.internal.scrumble.entity.sprint.Label;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.lang.Nullable;

/**
 * Entity User
 */
@Schema(description = "Entity User")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_user", uniqueConstraints = @UniqueConstraint(columnNames = { "key" }))
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String key;
	@NotNull
	private String name;
	@NotNull
	private String emailAddress;
	@NotNull
	private String displayName;
	private Boolean active;
	private String avatarSmall;
	private String avatarMedium;
	private String avatarLarge;
	private String avatarBig;

	@Nullable
	@ManyToOne()
	@JoinColumn(name = "team_id")
	private Team team;

	@ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<Label> labels;
}
