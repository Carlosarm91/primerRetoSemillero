package com.demoqa.book.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

  By userName  = By.id("userName");
  By contrasena= By.id("password");
  public By getUserName() { return userName; }
  public By getContrasena() {
        return contrasena;
    }

}
