package com.atempo.internal.scrumble.repository;

import com.atempo.internal.scrumble.entity.sprint.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}
