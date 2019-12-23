package com.biz.pets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/condition")
@Controller
public class ConditionController {
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("BODY","CONDITION-LIST");
		return "home";
	}

}
