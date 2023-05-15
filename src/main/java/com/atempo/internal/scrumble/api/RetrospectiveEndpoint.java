package com.atempo.internal.scrumble.api;

import java.util.List;

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

import com.atempo.internal.scrumble.api.model.assembler.RetrospectiveModelAssembler;
import com.atempo.internal.scrumble.api.model.sprint.RetrospectiveModel;
import com.atempo.internal.scrumble.entity.sprint.Retrospective;
import com.atempo.internal.scrumble.service.RetrospectiveService;
import com.atempo.internal.scrumble.service.manager.RetrospectiveManagerService;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/retrospectives", produces = MediaType.APPLICATION_JSON_VALUE)
public class RetrospectiveEndpoint {

	@Autowired
	private RetrospectiveService retrospectiveService;

	@Autowired
	private RetrospectiveManagerService retrospectiveManagerService;

	@Autowired
	private RetrospectiveModelAssembler retrospectiveModelAssembler;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<CollectionModel<RetrospectiveModel>> getAllRetrospectives() {
		List<Retrospective> retrospectiveEntities = retrospectiveService.findAll();
		return new ResponseEntity<>(retrospectiveModelAssembler.toCollectionModel(retrospectiveEntities), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RetrospectiveModel> getRetrospectiveById(@PathVariable("id") Long id) {
		return retrospectiveService.findById(id).map(retrospectiveModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<String> createRetrospective(@RequestBody RetrospectiveModel retrospectiveModel) {
		Retrospective retrospective = mapper.map(retrospectiveModel, Retrospective.class);
		retrospectiveService.save(retrospective);
		return new ResponseEntity<String>(new JSONObject("{message: Creation succesfully}").toString(), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> editRetrospective(@PathVariable("id") Long id, @RequestBody RetrospectiveModel retrospectiveModel) {
		Retrospective retrospective = mapper.map(retrospectiveModel, Retrospective.class);
		retrospective.setId(id);
		retrospectiveManagerService.saveOrUpdateComment(retrospective);
		return new ResponseEntity<String>(new JSONObject("{message: Update succesfully}").toString(), HttpStatus.CREATED);
	}
}
