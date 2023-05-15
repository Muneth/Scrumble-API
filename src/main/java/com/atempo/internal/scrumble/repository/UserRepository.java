package com.atempo.internal.scrumble.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atempo.internal.scrumble.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select t.users from Team t where t.id = :teamId")
	List<User> findByTeamId(@Param("teamId") Long teamId);

}
