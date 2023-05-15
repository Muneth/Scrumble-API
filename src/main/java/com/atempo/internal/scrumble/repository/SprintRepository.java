package com.atempo.internal.scrumble.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atempo.internal.scrumble.entity.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

	@Query("select s from Sprint s where s.project.id = :projectId")
	List<Sprint> findByProjectId(@Param("projectId") Long projectId);
	
	@Query("select s from Sprint s where s.team.id = :teamId and key = :key")
	Sprint findByTeamAndKey(@Param("teamId") Long teamId, @Param("key") Long key);
}
