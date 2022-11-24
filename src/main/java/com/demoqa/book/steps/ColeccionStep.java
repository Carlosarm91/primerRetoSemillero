package com.demoqa.book.steps;

import com.demoqa.book.pages.ColeccionPage;
import com.demoqa.book.pages.InicioPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ColeccionStep {
    ColeccionPage coleccionPage;
    InicioPage inicioPage;
    @Step
    public void validarLibroAgregado(String libro){
        getDriver().findElement(inicioPage.getBtnProfile()).click();
        String xpath = coleccionPage.getLibro()+libro.substring(1,7)+"')]";
        Assert.assertEquals(libro, getDriver().findElement(By.xpath(xpath)).getText());
    }

    @Step
    public void eliminoLibrosColeccion(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement btnProfile= getDriver().findElement(inicioPage.getBtnProfile());
        js.executeScript("arguments[0].scrollIntoView();", btnProfile);
        getDriver().findElement(inicioPage.getBtnProfile()).click();
        WebElement btnDelete= getDriver().findElement(coleccionPage.getBtnDeleteAllBooks());
        js.executeScript("arguments[0].scrollIntoView();", btnDelete);
        getDriver().findElement(coleccionPage.getBtnDeleteAllBooks()).click();
        getDriver().findElement(coleccionPage.getBtnOkDelete()).click();
    }
}
