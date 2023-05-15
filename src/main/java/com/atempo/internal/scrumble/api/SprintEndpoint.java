package com.atempo.internal.scrumble.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atempo.internal.scrumble.api.model.SprintModel;
import com.atempo.internal.scrumble.api.model.assembler.SprintModelAssembler;
import com.atempo.internal.scrumble.api.model.sprint.ResteModel;
import com.atempo.internal.scrumble.entity.Sprint;
import com.atempo.internal.scrumble.entity.sprint.Reste;
import com.atempo.internal.scrumble.service.ResteService;
import com.atempo.internal.scrumble.service.SprintService;
import com.atempo.internal.scrumble.service.manager.SprintManagerService;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/sprints", produces = MediaType.APPLICATION_JSON_VALUE)
public class SprintEndpoint {

	@Autowired
	private SprintService sprintService;

	@Autowired
	private ResteService resteService;

	@Autowired
	private SprintManagerService sprintManagerService;

	@Autowired
	private SprintModelAssembler sprintModelAssembler;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<CollectionModel<SprintModel>> getAllSprintsByProjectId(@PathParam("projectId") Long projectId) {
		List<Sprint> sprintEntities = sprintService.findByProjectId(projectId);
		return new ResponseEntity<>(sprintModelAssembler.toCollectionModelFromProjectId(sprintEntities, projectId), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SprintModel> getSprintById(@PathVariable("id") Long id) {
		return sprintService.findById(id).map(sprintModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<String> createSprint(@RequestBody SprintModel sprintModel) {
		Sprint sprint = mapper.map(sprintModel, Sprint.class);
		sprintManagerService.saveNewSprint(sprint);
		return new ResponseEntity<String>(new JSONObject("{message: Creation successfully}").toString(), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> editSprint(@PathVariable("id") Long id, @RequestBody SprintModel sprintModel) {
		Sprint sprint = mapper.map(sprintModel, Sprint.class);
		sprint.setId(id);
		sprintService.update(sprint);
		return new ResponseEntity<String>(new JSONObject("{message: Update successfully}").toString(), HttpStatus.CREATED);
	}

	@PostMapping("{id}/restes")
	public ResponseEntity<String> createReste(@PathVariable("id") Long sprintId, @RequestBody ResteModel resteModel) {
		Reste reste = mapper.map(resteModel, Reste.class);
		reste.setSprint(sprintService.findById(sprintId).get());
		resteService.save(reste);
		return new ResponseEntity<String>(new JSONObject("{message: Creation successfully}").toString(), HttpStatus.OK);
	}
}
