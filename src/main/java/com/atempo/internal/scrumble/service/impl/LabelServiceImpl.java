package com.atempo.internal.scrumble.service.impl;

import com.atempo.internal.scrumble.entity.sprint.Label;
import com.atempo.internal.scrumble.repository.LabelRepository;
import com.atempo.internal.scrumble.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Label> findById(Long id) {
        return labelRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Label save(Label label) {
        labelRepository.save(label);
        return label;
    }

    @Override
    public Label update(Label label) {
        Label labelToUpdate = labelRepository.getOne(label.getId());
        if (labelToUpdate == null) {
            throw new NoResultException();
        }
        mapper.map(label, labelToUpdate);
        return label;
    }

    @Override
    public void deleteById(Long id) {
        labelRepository.deleteById(id);
    }
}
