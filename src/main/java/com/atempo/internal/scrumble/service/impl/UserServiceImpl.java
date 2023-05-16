package com.atempo.internal.scrumble.service.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atempo.internal.scrumble.entity.User;
import com.atempo.internal.scrumble.repository.UserRepository;
import com.atempo.internal.scrumble.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByTeamId(Long teamId) {
		return userRepository.findByTeamId(teamId);
	}

	@Override
	@Transactional(readOnly = false)
	public User update(User user) {
		User userToUpdate = userRepository.getOne(user.getId());
		if (userToUpdate == null) {
			throw new NoResultException();
		}
		if(user.getTeam() == null) {
			userToUpdate.setTeam(null);
		}
		mapper.map(user, userToUpdate);
		return user;
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
