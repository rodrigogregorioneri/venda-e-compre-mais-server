package br.com.comprevenda.neri.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/teste")
public class MyController {
	
	@GetMapping("/{id}")
	public String read() {


		return "teste";
	}

}
