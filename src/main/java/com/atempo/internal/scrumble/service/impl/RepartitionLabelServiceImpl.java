package com.atempo.internal.scrumble.service.impl;

import com.atempo.internal.scrumble.entity.sprint.RepartitionLabel;
import com.atempo.internal.scrumble.repository.RepartitionLabelRepository;
import com.atempo.internal.scrumble.service.RepartitionLabelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service("repartitionLabelService")
@Transactional
public class RepartitionLabelServiceImpl implements RepartitionLabelService {

    @Autowired
    RepartitionLabelRepository repartitionLabelR;

    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<RepartitionLabel> findAll() {
        return repartitionLabelR.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RepartitionLabel> findById(Long id) {
        return repartitionLabelR.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(RepartitionLabel repartitionLabel) {
        repartitionLabelR.save(repartitionLabel);
    }

    @Override
    @Transactional(readOnly = false)
    public RepartitionLabel update(RepartitionLabel repartitionLabel) {
        RepartitionLabel repartitionLabelToUpdate = repartitionLabelR.getOne(repartitionLabel.getId());
        if (repartitionLabelToUpdate == null) {
            throw new NoResultException();
        }
        mapper.map(repartitionLabel, repartitionLabelToUpdate);
        return repartitionLabel;
    }
}
