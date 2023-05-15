package com.atempo.internal.scrumble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atempo.internal.scrumble.entity.sprint.Repartition;

public interface RepartitionRepository extends JpaRepository<Repartition, Long> {
}
