package com.demo.pages;

import com.demo.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {


    @FindBy(xpath = "//input[@name='panAdhaarUserId']")
    WebElement userName;
    @FindBy(xpath = "//button[@class='large-button-primary width marTop16']")
    WebElement continueButton;
    @FindBy(xpath = "//span[contains(text(),'PAN')]/following-sibling::span[@class='boldFont']")
    WebElement validatePan;
    @FindBy(xpath = "//input[@id='loginPasswordField']")
    WebElement password;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String enterUserName(String un){
        userName.sendKeys(un);
        continueButton.click();
        return validatePan.getText();
    }



}
