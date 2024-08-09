package com.drr.ProjectFuture.core.view;

import java.io.Serializable;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

@Component("menuView")
@ViewScoped
public class MenuView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private MenuModel menuModel;
	
	@Inject
    private TabView tabView;
	
	@PostConstruct
	private void init() {
		crearMenuXUsuario();
    }
	
	public void crearMenuXUsuario() {
		
		this.menuModel = new DefaultMenuModel();
			
		if ("David".equals("David"))
			this.menuModel.getElements().add(crearMenuItem("Mascotas"));
		
		if ( Boolean.TRUE )
			this.menuModel.getElements().add(crearMenuItem("Comida"));
		
		if ( Boolean.TRUE )
			this.menuModel.getElements().add(crearMenuItem("Viajes"));

		if ( Boolean.TRUE )
			this.menuModel.getElements().add(crearMenuItem("Negocios"));
		
		if ( Boolean.TRUE )
			this.menuModel.getElements().add(crearMenuItem("Tecnologia"));
		
	}
	
	private DefaultMenuItem crearMenuItem(String nombreItem) {
		
		DefaultMenuItem item = DefaultMenuItem.builder()
							                  .value(nombreItem)
							                  .ajax(Boolean.TRUE)
							                  .update("formTabView:tabViewContent")
							                  .build();
		
		item.setCommand("#{menuView.cargarPaginaSeleccionada('"+item.getValue().toString()+"')}");
		
		return item;
	}
	
	public void cargarPaginaSeleccionada(String menuSeleccionado) {
		String msjUbicacion = "Estas en: "+menuSeleccionado;
//		this.tabView.agregarMiga(menuSeleccionado);
		String rutaRedireccion = "/views/" + menuSeleccionado.toLowerCase() + ".xhtml";
		this.tabView.agregarTab(menuSeleccionado, rutaRedireccion, msjUbicacion);

	}
	
}
