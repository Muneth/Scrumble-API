package com.atempo.internal.scrumble.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atempo.internal.scrumble.entity.Sprint;
import com.atempo.internal.scrumble.entity.sprint.Repartition;
import com.atempo.internal.scrumble.repository.SprintRepository;
import com.atempo.internal.scrumble.service.SprintService;

@Service("sprintService")
@Transactional
public class SprintServiceImpl implements SprintService {

	@Autowired
	SprintRepository sprintRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Sprint sprint) {
		sprint.setCreationDate(new Date());
		sprintRepository.saveAndFlush(sprint);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Sprint> findById(Long id) {
		return sprintRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sprint> findAll() {
		return sprintRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sprint> findByProjectId(Long projectId) {
		return sprintRepository.findByProjectId(projectId);
	}

	@Override
	@Transactional(readOnly = true)
	public Sprint findByTeamAndKey(Long teamId, Long key) {
		return sprintRepository.findByTeamAndKey(teamId, key);
	}

	@Override
	@Transactional(readOnly = false)
	public Sprint update(Sprint sprint) {
		Sprint sprintToUpdate = sprintRepository.getOne(sprint.getId());
		if (sprintToUpdate == null) {
			throw new NoResultException();
		}
		List<Repartition> repartitions = new ArrayList<Repartition>();
		if (sprint.getRepartitions() != null) {
			List<Repartition> repartitionsToUpdate =  sprintToUpdate.getRepartitions();
			
			for (Repartition repartition : sprint.getRepartitions()) {
				for (Repartition repartitionToUpdate : repartitionsToUpdate) {
					if (repartitionToUpdate.getId().equals(repartition.getId())) {
						repartitionToUpdate.setPoints(repartition.getPoints());
						repartitions.add(repartitionToUpdate);
					}
				}
			}
			
		}
		mapper.map(sprint, sprintToUpdate);
		sprintToUpdate.setRepartitions(repartitions);
		return sprint;

	}
}
