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
import org.springframework.web.bind.annotation.*;

import com.atempo.internal.scrumble.api.model.TeamModel;
import com.atempo.internal.scrumble.api.model.UserModel;
import com.atempo.internal.scrumble.api.model.assembler.TeamModelAssembler;
import com.atempo.internal.scrumble.api.model.assembler.UserModelAssembler;
import com.atempo.internal.scrumble.entity.Team;
import com.atempo.internal.scrumble.entity.User;
import com.atempo.internal.scrumble.service.TeamService;
import com.atempo.internal.scrumble.service.UserService;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/teams", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamEndpoint {

	@Autowired
	private TeamService teamService;

	@Autowired
	private UserService userService;

	@Autowired
	private TeamModelAssembler teamModelAssembler;

	@Autowired
	private UserModelAssembler userModelAssembler;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<CollectionModel<TeamModel>> getAllTeams() {
		List<Team> teamEntities = teamService.findAll();
		return new ResponseEntity<>(teamModelAssembler.toCollectionModel(teamEntities), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TeamModel> getTeamById(@PathVariable("id") Long id) {
		return teamService.findById(id).map(teamModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/{id}/users")
	public ResponseEntity<CollectionModel<UserModel>> getUsersByTeamId(@PathVariable("id") Long teamId) {
		List<User> userEntities = userService.findByTeamId(teamId);
		return new ResponseEntity<>(userModelAssembler.toCollectionModelFromTeamId(userEntities, teamId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createTeam(@RequestBody TeamModel teamModel) {
		Team team = mapper.map(teamModel, Team.class);
		teamService.save(team);
		return new ResponseEntity<>(new JSONObject("{message: Creation successfully}").toString(), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> editTeam(@PathVariable("id") Long id, @RequestBody TeamModel teamModel) {
		Team team = mapper.map(teamModel, Team.class);
		team.setId(id);
		teamService.update(team);
		return new ResponseEntity<>(new JSONObject("{message: Update successfully}").toString(), HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTeam(@PathVariable("id") Long id) {
		teamService.deleteTeamById(id);
		return new ResponseEntity<>(new JSONObject("{message: Delete successfully}").toString(), HttpStatus.OK);
	}

}
