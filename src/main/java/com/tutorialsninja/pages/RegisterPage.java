package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Utility {
    By registerAccountText = By.xpath("//h1[text()='Register Account']");
    By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By conformPassword = By.id("input-confirm");
    By agreeCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");





    public String verifyRegisterAccount(){
        return getTextFromElement(registerAccountText);
    }
    public void enterFirstName(String text){
        sendTextToElement(firstname, text + getAlphaNumericString(5));
    }
    public void enterLastName(String text){
        sendTextToElement(lastname, text + getAlphaNumericString(5));
    }
    public void enterEmail(String text){
        sendTextToElement(email, text + getAlphaNumericString(5));
    }
    public void enterTelephone(String text){
        sendTextToElement(telephone,text);
    }
    public void enterPassword(String text){
        sendTextToElement(password,text);
    }
    public void enterConformPassword(String text){
        sendTextToElement(conformPassword,text);
    }
    public void clickOnSubcribe(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }

    }
    public void clickOnAgree(){
        clickOnElement(agreeCheckBox);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }
}
