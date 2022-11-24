package com.demoqa.book.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/books")
public class InicioPage extends PageObject {

    By btn_Login = By.xpath("//button[@id='login']");
    By btnProfile = By.xpath("(//li[@id='item-3'])[5]");

    public By getBtnProfile() {
        return btnProfile;
    }

    public By getBtn_Login() {
        return btn_Login;
    }
}
