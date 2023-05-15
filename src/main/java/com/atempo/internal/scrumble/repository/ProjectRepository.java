package com.atempo.internal.scrumble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atempo.internal.scrumble.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
