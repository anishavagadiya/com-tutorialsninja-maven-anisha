package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    HomePage homePage = new HomePage();
    DeskTopPage desktopPage = new DeskTopPage();
    HPProductPage hpProductPage = new HPProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    SucessPage sucessPage = new SucessPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    LogOutPage logOutPage = new LogOutPage();


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.verifyRegisterAccount(), "Register Account", "Text is not displayed");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.returningcustomer(), "Returning Customer", "Text isnot display");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Wong");
        registerPage.enterEmail("jo@example.com");
        registerPage.enterTelephone("235665656");
        registerPage.enterPassword("test123");
        registerPage.enterConformPassword("test123");
        registerPage.clickOnSubcribe();
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();
        Assert.assertEquals(sucessPage.verifyYourAccountMessage(), "Your Account Has Been Created!", "Text is not display");
        sucessPage.clickOnSucessContinueButton();
        myAccountPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logOutPage.verifyAccountLogoutText(), "Account Logout", "Text is not Display");
        logOutPage.clickOnContinue();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLogin();
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logOutPage.verifyAccountLogoutText(), "Account Logout", "Text is not Display");
        logOutPage.clickOnContinue();


    }


}
