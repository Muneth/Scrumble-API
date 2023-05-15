package com.atempo.internal.scrumble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atempo.internal.scrumble.entity.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
