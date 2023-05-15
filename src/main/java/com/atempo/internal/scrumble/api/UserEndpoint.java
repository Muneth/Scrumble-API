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

import com.atempo.internal.scrumble.api.model.UserModel;
import com.atempo.internal.scrumble.api.model.assembler.UserModelAssembler;
import com.atempo.internal.scrumble.entity.User;
import com.atempo.internal.scrumble.service.UserService;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserEndpoint {

	@Autowired
	private UserService userService;

	@Autowired
	private UserModelAssembler userModelAssembler;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<CollectionModel<UserModel>> getAllUsers() {
		List<User> userEntities = userService.findAll();
		return new ResponseEntity<>(userModelAssembler.toCollectionModel(userEntities), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
		return userService.findById(id).map(userModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserModel userModel) {
		User user = mapper.map(userModel, User.class);
		userService.save(user);
		return new ResponseEntity<String>(new JSONObject("{message: Creation successfully}").toString(), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> editUser(@PathVariable("id") Long id, @RequestBody UserModel userModel) {
		User user = mapper.map(userModel, User.class);
		user.setId(id);
		userService.update(user);
		return new ResponseEntity<String>(new JSONObject("{message: Update successfully}").toString(), HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return new ResponseEntity<String>(new JSONObject("{message: Delete successfully}").toString(), HttpStatus.OK);
	}
}
