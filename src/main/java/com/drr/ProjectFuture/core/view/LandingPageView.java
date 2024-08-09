package com.drr.ProjectFuture.core.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

@Component("landingPageView")
@ApplicationScoped
public class LandingPageView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private List<String> migasDePan;
	
	@Getter @Setter
	private List<String> lstBreadcrumb;
	
	@PostConstruct
	private void init() {
		System.out.println("Se crea la sesion de usuario");
		this.migasDePan = new ArrayList<>();
		this.lstBreadcrumb = new ArrayList<>();
    }
	
	public void agregarMiga(String valor) {
		this.lstBreadcrumb.add(valor);
	}
	
	public void updateForm() {
		PrimeFaces.current().ajax().update("formBreadCrumb");
	}
	
}
