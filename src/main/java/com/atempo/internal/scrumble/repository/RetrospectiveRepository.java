package com.atempo.internal.scrumble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atempo.internal.scrumble.entity.sprint.Retrospective;

public interface RetrospectiveRepository extends JpaRepository<Retrospective, Long> {
}
