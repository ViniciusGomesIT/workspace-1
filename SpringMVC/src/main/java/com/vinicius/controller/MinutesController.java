package com.vinicius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MinutesController {

	@RequestMapping(value="/show-minutes")
	public String calculateAndShowMinutes(Model model) {
		Long g = 1L;
		for (int i = 1; i <= 10; i++) {
			g = g * i;
		}

		model.addAttribute("minutes", String.valueOf(g));
		
		return "showMinutes";
	}
}
