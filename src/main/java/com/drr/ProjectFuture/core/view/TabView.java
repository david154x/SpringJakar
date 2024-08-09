package com.drr.ProjectFuture.core.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.primefaces.model.menu.MenuItem;
import org.springframework.stereotype.Component;

import com.drr.ProjectFuture.core.dto.TabItem;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;
import lombok.Setter;

@Component("tabView")
@SessionScoped
public class TabView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String token;

	@Getter @Setter
	private int activeTab = 0;

	@Getter @Setter
	private List<TabItem> lstTabs = new ArrayList<>();
	
	@Getter @Setter
	private List<MenuItem> lstMenuItems;
	
	@PostConstruct
	private void init() {
		System.out.println("Se crea la sesion de Content View");
		lstMenuItems = new ArrayList<>();
    }

	public void agregarTab(String title, String content, String path) {
		
		TabItem newTab = new TabItem();
		newTab.setTitle(title);
		newTab.setContent(content);
		newTab.setPath(path);
		this.lstTabs.add(newTab);
		this.activeTab = lstTabs.size() - 1;
		
	}

	public Boolean closeTab(TabItem tabSeleccionado) {
		
		if ( this.lstTabs.contains(tabSeleccionado) ) {
			this.lstTabs.remove(tabSeleccionado);
			this.activeTab = lstTabs.size() - 1;
			updatetabViewContent();
		}
		
		return Boolean.TRUE;
	}
	
	private void updatetabViewContent() {
		PrimeFaces.current().ajax().update("formTabView:tabViewContent");
	}
	
}
