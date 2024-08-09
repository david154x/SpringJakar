package com.drr.ProjectFuture.core.view;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

@Component("exampleView")
@ViewScoped
public class ExampleView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String saludo;
	
	@PostConstruct
	private void init() {
		System.out.println("Eres un maquina");
		this.saludo = "Hola mundo";
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
}
