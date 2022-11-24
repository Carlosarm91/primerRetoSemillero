package com.demoqa.book.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ColeccionPage extends PageObject{
    By btnDeleteAllBooks = By.xpath("//div[@class='text-right button di']/button");
    By btnOkDelete = By.xpath("//button[@id='closeSmallModal-ok']");
    By btnGoBookStore = By.xpath("//button[@id='gotoStore']");

    String libro = "//*[contains(@id,'";

    public String getLibro() {
        return libro;
    }
    public By getBtnDeleteAllBooks() {
        return btnDeleteAllBooks;
    }

    public By getBtnGoBookStore() {
        return btnGoBookStore;
    }
    public By getBtnOkDelete() {
        return btnOkDelete;
    }
}
