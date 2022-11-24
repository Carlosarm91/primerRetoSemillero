package com.demoqa.book.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class TiendaPage extends PageObject {
    By campoUsuario = By.xpath("//label[@id='userName-value']");
    By cuadroBusqueda = By.xpath("//input[@id='searchBox']");
    String libro = "//*[contains(@id,'";

    public String getLibro() {
        return libro;
    }

    public By getCampoUsuario() {
        return campoUsuario;
    }
    public By getCuadroBusqueda() {
        return cuadroBusqueda;
    }
}
