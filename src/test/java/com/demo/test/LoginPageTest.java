package com.demo.test;

import com.demo.base.Base;
import com.demo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialize();
        loginPage=new LoginPage();
    }

    @Test
    public void testLoginPage(){
       String loginWithUN= loginPage.enterUserName("aikpa4006a");
        Assert.assertEquals(loginWithUN,"AIKPA4006A" );

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
