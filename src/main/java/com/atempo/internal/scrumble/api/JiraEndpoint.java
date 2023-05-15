package com.atempo.internal.scrumble.api;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atempo.internal.scrumble.jira.ExecutePython;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/jira", produces = MediaType.APPLICATION_JSON_VALUE)
public class JiraEndpoint {

	@GetMapping("/boards")
	public ResponseEntity<String> getAllBoards() throws JsonMappingException, JsonProcessingException {
		String result = ExecutePython.launch("https://engineering.atempo.com/jira/rest/agile/1.0/board");
		return new ResponseEntity<>(    
				result, HttpStatus.OK);
	}

	@GetMapping("/boards/{boardId}/sprints")
	public ResponseEntity<String> getActiveSprints(@PathVariable("boardId") Long boardId) {
		String result = ExecutePython.launch("https://engineering.atempo.com/jira/rest/agile/1.0/board/"+boardId+ "/sprint?state=active");
		return new ResponseEntity<>(    
				result, HttpStatus.OK);
	}

	@GetMapping("/boards/{boardId}/sprints/{sprintId}/issues")
	public ResponseEntity<String> getIssuesFromSprint(@PathVariable("boardId") Long boardId, @PathVariable("sprintId") Long sprintId) {
		String result = ExecutePython.launch("https://engineering.atempo.com/jira/rest/agile/1.0/board/"+boardId+ "/sprint/"+sprintId+"/issue");
		return new ResponseEntity<>(    
				new JSONObject(result).toString(), HttpStatus.OK);
	}

	@GetMapping("/users/{userKey}")
	public ResponseEntity<String> getUser(@PathVariable("userKey") String userKey) throws JsonMappingException, JsonProcessingException {
		String result = ExecutePython.launch("https://engineering.atempo.com/jira/rest/api/2/user?username="+userKey);
		return new ResponseEntity<>(    
				result, HttpStatus.OK);
	}
}
