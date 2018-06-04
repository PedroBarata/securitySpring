package com.pedro.projetoteste.projetoteste.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetoTesteController {

	@RequestMapping("/")
	public String index() {
		return "index page";
	}
	
	@RequestMapping("/showtext")
	public String showText() {
		return "Hello, teste!";
	}
}
