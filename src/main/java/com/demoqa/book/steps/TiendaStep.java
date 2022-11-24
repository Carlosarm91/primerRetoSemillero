package com.demoqa.book.steps;

import com.demoqa.book.pages.TiendaPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class TiendaStep {
    TiendaPage tienda;
    @Step
    public void validarLogin(){
        Assert.assertEquals("carlosarmiento", getDriver().findElement(tienda.getCampoUsuario()).getText().toLowerCase());
    }

    @Step
    public void busquedaLibro(String libro){
        getDriver().findElement(tienda.getCuadroBusqueda()).sendKeys(libro);
    }

    @Step
    public void clicLibro(String libro){
        String xpath = tienda.getLibro()+libro.substring(1,7)+"')]";
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement linkLibro = getDriver().findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", linkLibro);
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Step
    public void validarNoResultados(){
        String textoCopiado = "";
        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            textoCopiado = (String) t.getTransferData(DataFlavor.stringFlavor);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(textoCopiado.contains("No rows found"));
    }


}
