package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trulia.pages.BuyNewHomesPage;
import com.trulia.pages.HomePage;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.Driver;
import com.trulia.utilities.Driver.*;
import com.trulia.utilities.TestBase;

public class AikaTestCases extends TestBase {
	
	@Test (groups = "functional")
	public void searchFourBedroomTestCase8() {
		HomePage home = new HomePage();

		assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.trulia.com/");
		assertEquals(Driver.getDriver().getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");

		Actions actions = new Actions(Driver.getDriver());

		assertTrue(home.BuyLink.isDisplayed());

		actions.moveToElement(home.BuyLink).perform();
		home.NewHomesLink.click();

		assertTrue(Driver.getDriver().getTitle().contains("New Homes"));

		BuyNewHomesPage buyNewHomesPage = new BuyNewHomesPage();
		assertTrue(buyNewHomesPage.searchBar.isDisplayed());

		buyNewHomesPage.searchBar.clear();
		buyNewHomesPage.searchBar.sendKeys("Windermere, FL");
		buyNewHomesPage.allBeds.click();

		assertTrue(buyNewHomesPage.onePlusBedroom.isDisplayed());
		assertTrue(buyNewHomesPage.twoPlusBedroom.isDisplayed());
		assertTrue(buyNewHomesPage.threePlusBedroom.isDisplayed());
		assertTrue(buyNewHomesPage.fourPlusBedroom.isDisplayed());

		buyNewHomesPage.fourPlusBedroom.click();

		assertTrue(Driver.getDriver().getTitle().contains("Sale"));

	}

	@Test (groups = "functional")
	public void buyModuleTestCase11() {
		HomePage home = new HomePage();
		assertEquals(Driver.getDriver().getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(home.BuyLink).perform();
		home.openHousesLink.click();
		assertTrue(Driver.getDriver().getTitle().contains("Open Houses"));
		BuyNewHomesPage buyNewHomesPage = new BuyNewHomesPage();
		buyNewHomesPage.allHometypes.click();
		assertTrue(buyNewHomesPage.homeTypesAreDisplayed(buyNewHomesPage.allHometypesList));
		for (int i = 0; i < buyNewHomesPage.allHometypesList.size(); i++) {
			buyNewHomesPage.allHometypesList.get(i).click();
		}
		for (int i = 0; i < buyNewHomesPage.allHometypesList.size(); i++) {
			buyNewHomesPage.allHometypesList.get(i).click();
		}

		buyNewHomesPage.allHometypesList.get(1).click();

		assertTrue(buyNewHomesPage.noMatchText.isDisplayed());

	}

	@Test (groups = "functional")
	public void validatingPriceRange12() {
		HomePage home = new HomePage();

		assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.trulia.com/");
		assertEquals(Driver.getDriver().getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");

		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(home.BuyLink).perform();

		assertTrue(home.homesForSaleLink.isDisplayed());
		home.homesForSaleLink.click();

		assertTrue(Driver.getDriver().getTitle().contains("Homes For Sale"));

		BuyNewHomesPage buyNewHomesPage = new BuyNewHomesPage();

		buyNewHomesPage.anyPriceButton.click();
		buyNewHomesPage.minPrice.click();

		Select select = new Select(buyNewHomesPage.minPrice);
		select.selectByIndex(1);

		buyNewHomesPage.maxPrice.click();

		select = new Select(buyNewHomesPage.maxPrice);
		select.selectByIndex(2);

		assertTrue(Driver.getDriver().findElement(By.xpath("//h2")).getText().contains("does not match"));

	}

	@Test (groups = "functional")
	public void localScoop18() {
		HomePage home = new HomePage();

		assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.trulia.com/");
		assertEquals(Driver.getDriver().getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");
		assertTrue(home.logo.isDisplayed());
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(home.localScoopLink).perform();
		assertTrue(home.marketTrendsLink.isDisplayed());
		home.marketTrendsLink.click();
		assertTrue(Driver.getDriver().getCurrentUrl().contains("/market-trends/"));
		assertTrue(Driver.getDriver().getTitle().contains("Real Estate Market Trends"));

	}

	@Test (groups = "functional")
	public void searchTestCase19() {
		HomePage home = new HomePage();

		assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.trulia.com/");
		assertEquals(Driver.getDriver().getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");
		assertTrue(home.BuyLink.isDisplayed());
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(home.BuyLink).perform();
		assertTrue(home.openHousesLink.isDisplayed());
		home.openHousesLink.click();
		BuyNewHomesPage buyNewHomesPage = new BuyNewHomesPage();
		assertTrue(buyNewHomesPage.searchBar.isDisplayed());
		buyNewHomesPage.searchBar.clear();
		buyNewHomesPage.searchBar.sendKeys("Pittsburgh,PA");
		assertTrue(Driver.getDriver().getTitle().contains("Open Houses"));
		buyNewHomesPage.allBeds.click();
		assertTrue(buyNewHomesPage.onePlusBedroom.isDisplayed());
		assertTrue(buyNewHomesPage.twoPlusBedroom.isDisplayed());
		assertTrue(buyNewHomesPage.threePlusBedroom.isDisplayed());
		assertTrue(buyNewHomesPage.fourPlusBedroom.isDisplayed());
		buyNewHomesPage.onePlusBedroom.click();
	
		}
}
