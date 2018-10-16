package com.vinicius.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinicius.model.Exercise;

@Controller
public class MinutesController {

	@Value("${message.default}")
	String palavra;
	
	@RequestMapping(value="/show-minutes")
	public String calculateAndShowMinutes(@ModelAttribute ("exercise") Exercise exercise) {		
		
		System.out.println("Exercise: " + exercise.getMinutes() + palavra);
		
		return "showMinutes";
	}
}
