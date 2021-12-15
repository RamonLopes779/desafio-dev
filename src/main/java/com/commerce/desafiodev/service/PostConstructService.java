package com.commerce.desafiodev.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class PostConstructService {

	@Autowired
	DesafioService desafioService;

	public PostConstructService() {
		System.out.println("PostContructImpl Constructor called");
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		try {
			desafioService.initialLoad();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
