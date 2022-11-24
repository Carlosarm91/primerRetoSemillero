package com.demoqa.book.steps;

import com.demoqa.book.pages.ColeccionPage;
import com.demoqa.book.pages.InicioPage;
import com.demoqa.book.pages.LibroPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LibroSteps {
    LibroPage libroPage;
    InicioPage inicioPage;
    ColeccionPage coleccionPage;
    TiendaStep tiendaStep;
    String mensajeAlerta;
    @Step
    public void clicAddToYourCollection() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement btnAdd= getDriver().findElement(libroPage.getBtnAdd());
        js.executeScript("arguments[0].scrollIntoView();", btnAdd);
        getDriver().findElement(libroPage.getBtnAdd()).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        mensajeAlerta =  getDriver().switchTo().alert().getText();
    }

    @Step
    public void validarVentanaEmergente(String mensaje){
        Assert.assertEquals(mensajeAlerta,mensaje);
    }
}
