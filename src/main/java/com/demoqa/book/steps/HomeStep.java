package com.demoqa.book.steps;

import com.demoqa.book.pages.InicioPage;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomeStep {
    InicioPage InicioPage;
    @Step
    public void abrirNavegador() {
        InicioPage.open();
    }
    @Step
    public void clickBotonLogin() {
        getDriver().findElement(InicioPage.getBtn_Login()).click();
    }

}
