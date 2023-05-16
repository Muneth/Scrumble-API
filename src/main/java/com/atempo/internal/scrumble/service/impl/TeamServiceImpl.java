package com.atempo.internal.scrumble.service.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atempo.internal.scrumble.entity.Team;
import com.atempo.internal.scrumble.repository.TeamRepository;
import com.atempo.internal.scrumble.service.TeamService;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Team team) {
		teamRepository.save(team);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Team> findById(Long id) {
		return teamRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Team update(Team team) {
		Team teamToUpdate = teamRepository.getOne(team.getId());
		if (teamToUpdate == null) {
			throw new NoResultException();
		}
		mapper.map(team, teamToUpdate);
		return team;
	}

	@Override
	public void deleteById(Long id) {
		teamRepository.deleteById(id);
	}
}
