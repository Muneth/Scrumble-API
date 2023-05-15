package com.atempo.internal.scrumble.jira;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

public class ExecutePython {

	public static String launch(String url) {
		ProcessBuilder processBuilder = new ProcessBuilder("python3", "/home/tinaui/jira/call-jira.py", url);
		processBuilder.redirectErrorStream(true);

		try {
			return IOUtils.toString(new InputStreamReader(processBuilder.start().getInputStream())); 
		} catch (IOException e) {
			return "";
		}
	}

}
