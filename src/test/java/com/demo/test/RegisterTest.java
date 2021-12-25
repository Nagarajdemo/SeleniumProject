package com.demo.test;

import com.demo.base.Base;
import com.demo.pages.LoginPage;
import com.demo.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends Base {
    RegisterPage registerPage;
    public RegisterTest() {
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialize();
        registerPage =new RegisterPage();
    }

    @Test
    public void validateRegisterTest(){
        registerPage.clickRegister();
//        Assert.assertEquals(checkForregister,"External Agency","check for External Agency page");

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
