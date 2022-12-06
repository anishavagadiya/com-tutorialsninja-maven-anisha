package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DeskTopPage;
import com.tutorialsninja.pages.HPProductPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class DeskTopPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DeskTopPage desktopPage = new DeskTopPage();
    HPProductPage hpProductPage = new HPProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Desktops");
        Map<String, ArrayList> mapArrays = desktopPage.arrangeProductInDescendingOrder();
        Assert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.clickOnCurrency();
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All DeskTops");
        // desktopPage.sortByName();
        desktopPage.clinkOnHPProductLink();
        Assert.assertEquals(hpProductPage.HpTextErrorMessage(), "HP LP3065", "Text not displayed");
        hpProductPage.selectDate("2022", "November", "30");
        hpProductPage.changeProductQuantity();
        hpProductPage.clickOnAddToCartButton();
        Assert.assertEquals(hpProductPage.addToCartErrorMessage(), "HP LP3065");
        hpProductPage.clickOnShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.shoppingCartTextErrorMessage(), "Shopping Cart  (1.00kg)", "Shopping cart is not displayed");
        Assert.assertEquals(shoppingCartPage.productNameErrorMessage(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")).contains("2022-11-30"), "Delivery date not matched");
       // Assert.assertEquals(shoppingCartPage.deliveryDateErrorMessage(),"2022-11-30", "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.modelErrorMessage(), "Product 21", "Model not matched");
        Assert.assertEquals(shoppingCartPage.priceTotalErrorMessage(), "£74.73", "Total not matched");


    }
}