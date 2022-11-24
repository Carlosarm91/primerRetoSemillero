package com.demoqa.book.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LibroPage extends PageObject {
    By btnAdd = By.xpath("(//button[@id='addNewRecordButton'])[2]");

    public By getBtnAdd() {
        return btnAdd;
    }
}
