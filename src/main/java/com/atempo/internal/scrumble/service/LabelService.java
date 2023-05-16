package com.atempo.internal.scrumble.service;

import com.atempo.internal.scrumble.entity.sprint.Label;

import java.util.List;
import java.util.Optional;

public interface LabelService {

    List<Label> findAll();

    Optional<Label> findById(Long id);

    Label save(Label label);

    Label update(Label label);

    void deleteById(Long id);
}
