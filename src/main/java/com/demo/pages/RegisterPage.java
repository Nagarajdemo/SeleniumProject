package com.demo.pages;

import com.demo.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Base {


    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement register;
    @FindBy(xpath="//button[@id='mat-button-toggle-2-button']")
    WebElement clickOthers;
    @FindBy(xpath="//div[@class='mat-select-value'][1]")
    WebElement selectItem;
    @FindBy(xpath = "//span[contains(text(),'External Agency')]")
    WebElement selectExternalAgency;
    @FindBy(xpath = "//button[@class='large-button-secondary mt16 width statement3']")
    WebElement continueButton;
    @FindBy(xpath ="//span[@class='mr-1']/following-sibling::span[@class='bold-text ng-star-inserted']")
    WebElement checkExternalAgency;


    WebElement password;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickRegister(){
        register.click();
        clickOthers.click();
        selectItem.click();
        selectExternalAgency.click();
//        Select category=new Select(selectExternalAgency);
//        category.selectByValue(selectExternalAgency.getText());
//        continueButton.click();
//        return checkExternalAgency.getText();
    }



}
