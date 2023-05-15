package com.atempo.internal.scrumble.service;

import java.util.List;
import java.util.Optional;

import com.atempo.internal.scrumble.entity.User;

public interface UserService {

	List<User> findAll();

	Optional<User> findById(Long id);

	List<User> findByTeamId(Long teamId);

	void save(User user);

	User update(User user);

	void deleteById(Long id);
}
