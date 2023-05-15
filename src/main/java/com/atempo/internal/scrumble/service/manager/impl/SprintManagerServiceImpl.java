package com.atempo.internal.scrumble.service.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atempo.internal.scrumble.entity.Sprint;
import com.atempo.internal.scrumble.entity.sprint.Repartition;
import com.atempo.internal.scrumble.service.RepartitionService;
import com.atempo.internal.scrumble.service.SprintService;
import com.atempo.internal.scrumble.service.manager.SprintManagerService;

@Service("sprintManagerService")
@Transactional
public class SprintManagerServiceImpl implements SprintManagerService {
	
	@Autowired
	SprintService sprintService;
	
	@Autowired
	RepartitionService repartitionService;
	
	public void saveNewSprint(Sprint sprint) {
		List<Repartition> repartitions = new ArrayList<Repartition>(sprint.getRepartitions());
		sprint.setRepartitions(null);
		sprintService.save(sprint);
		Sprint sprintReference = sprintService.findByTeamAndKey(sprint.getTeam().getId(), sprint.getKey());
		if (repartitions != null) {
			sprintReference.setRepartitions(new ArrayList<Repartition>());
			for (Repartition repartition : repartitions) {
				repartition.setSprint(sprintReference);
				repartitionService.save(repartition);
			}
		}
	}
}
