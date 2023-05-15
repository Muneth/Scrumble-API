package com.atempo.internal.scrumble.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atempo.internal.scrumble.entity.sprint.Reste;
import com.atempo.internal.scrumble.repository.ResteRepository;
import com.atempo.internal.scrumble.service.ResteService;

@Service("resteService")
@Transactional
public class ResteServiceImpl implements ResteService {

	@Autowired
	ResteRepository resteRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Reste reste) {
		resteRepository.save(reste);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reste> findById(Long id) {
		return resteRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reste> findAll() {
		return resteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Reste update(Reste reste) {
		Reste resteToUpdate = resteRepository.getOne(reste.getId());
		if (resteToUpdate == null) {
			throw new NoResultException();
		}
		mapper.map(reste, resteToUpdate);
		return reste;

	}
}
