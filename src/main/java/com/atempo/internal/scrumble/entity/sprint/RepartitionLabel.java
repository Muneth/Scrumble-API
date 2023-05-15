package com.atempo.internal.scrumble.entity.sprint;


import com.atempo.internal.scrumble.entity.Sprint;
import com.atempo.internal.scrumble.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity Repartition
 */
@Schema(description = "Entity RepartitionLabel")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_sprint_repartitionLabel")
public class RepartitionLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    String label;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private Double points;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
}
