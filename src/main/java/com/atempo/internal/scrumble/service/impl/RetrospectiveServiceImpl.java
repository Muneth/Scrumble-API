package com.atempo.internal.scrumble.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atempo.internal.scrumble.entity.sprint.Retrospective;
import com.atempo.internal.scrumble.repository.RetrospectiveRepository;
import com.atempo.internal.scrumble.service.RetrospectiveService;

@Service("retrospectiveService")
@Transactional
public class RetrospectiveServiceImpl implements RetrospectiveService {

	@Autowired
	RetrospectiveRepository retrospectiveRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Retrospective retrospective) {
		retrospective.setCreationDate(new Date());
		retrospectiveRepository.save(retrospective);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Retrospective> findById(Long id) {
		return retrospectiveRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Retrospective> findAll() {
		return retrospectiveRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Retrospective update(Retrospective retrospective) {
		Retrospective retrospectiveToUpdate = retrospectiveRepository.getOne(retrospective.getId());
		if (retrospectiveToUpdate == null) {
			throw new NoResultException();
		}
		mapper.map(retrospective, retrospectiveToUpdate);
		return retrospective;

	}
}
