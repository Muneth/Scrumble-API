package com.atempo.internal.scrumble.service;

import com.atempo.internal.scrumble.entity.sprint.RepartitionLabel;

import java.util.List;
import java.util.Optional;

public interface RepartitionLabelService {

    List<RepartitionLabel> findAll();

    Optional<RepartitionLabel> findById(Long id);

    void save(RepartitionLabel repartitionLabel);

    RepartitionLabel update(RepartitionLabel repartitionLabel);
}