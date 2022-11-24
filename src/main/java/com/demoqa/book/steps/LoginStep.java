package com.demoqa.book.steps;

import com.demoqa.book.pages.InicioPage;
import com.demoqa.book.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginStep {
    InicioPage InicioPage;
    LoginPage login;
    @Step
    public void digitarUsuarioYContrasena(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement btnLogin = getDriver().findElement(InicioPage.getBtn_Login());
        js.executeScript("arguments[0].scrollIntoView();", btnLogin);
        getDriver().findElement(login.getUserName()).sendKeys("carlosarmiento");
        getDriver().findElement(login.getContrasena()).sendKeys("Carlos123*");
        getDriver().findElement(InicioPage.getBtn_Login()).click();
    }
}
