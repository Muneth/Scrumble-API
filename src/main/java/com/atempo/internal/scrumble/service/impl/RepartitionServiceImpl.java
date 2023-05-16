package com.atempo.internal.scrumble.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atempo.internal.scrumble.entity.sprint.Repartition;
import com.atempo.internal.scrumble.repository.RepartitionRepository;
import com.atempo.internal.scrumble.service.RepartitionService;

@Service("repartitionService")
@Transactional
public class RepartitionServiceImpl implements RepartitionService {

	@Autowired
	RepartitionRepository repartitionRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Repartition repartition) {
		repartitionRepository.save(repartition);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Repartition> findById(Long id) {
		return repartitionRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Repartition> findAll() {
		return repartitionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Repartition update(Repartition repartition) {
		Repartition repartitionToUpdate = repartitionRepository.getOne(repartition.getId());
		if (repartitionToUpdate == null) {
			throw new NoResultException();
		}
		mapper.map(repartition, repartitionToUpdate);
		return repartition;
	}
}
