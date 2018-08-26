package com.vinicius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinicius.model.Exercise;

@Controller
public class MinutesController {

	@RequestMapping(value="/show-minutes")
	public String calculateAndShowMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("Exercise: " + exercise.getMinutes());
		
		return "showMinutes";
	}
}
