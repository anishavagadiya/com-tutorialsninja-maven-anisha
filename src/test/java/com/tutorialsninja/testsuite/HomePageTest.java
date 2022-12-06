package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DeskTopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DeskTopPage deskTopPage = new DeskTopPage();
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    ComponentsPage componentsPage = new ComponentsPage();


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All DeskTops");
        String expectedDeskTopText = "Desktops";
        Assert.assertEquals(deskTopPage.navigateToDesktopErrorMessage(), expectedDeskTopText, "DeskTops isnot displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedLaptopsandNotebooksText = "Laptops & Notebooks";
        Assert.assertEquals(laptopsAndNoteBooksPage.navigateToLaptopsNotebooksErrorMessage(), expectedLaptopsandNotebooksText, "Text isnot display");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverToComponentsAndClick();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(componentsPage.navigateToComponentsErrorMessage(), "Components", "Text isnot display");
    }

}