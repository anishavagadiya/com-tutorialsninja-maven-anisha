package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LogOutPage extends Utility {
    By accountLogOutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueButton = By.xpath("//a[contains(text(),'Continue')]");




    public String verifyAccountLogoutText(){
        return getTextFromElement(accountLogOutText);

    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }
}
