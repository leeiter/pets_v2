package com.biz.pets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/ingredient")
@Controller
public class IngredientController {
		
		@RequestMapping(value="/list",method=RequestMethod.GET)
		public String list(Model model) {
			model.addAttribute("BODY","INGREDIENT-LIST");
			return "home";
		}

}
