package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.*;

public class NewHomesPage {
	private WebDriver driver;

	public NewHomesPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "locationInputs")
	public WebElement searchBar;

	@FindBy(id = "bedroomsToggle")
	public WebElement allBeds;
	
	@FindBy(xpath = "(//button[contains(text(),'1+')])[1]")
	public WebElement onePlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'2+')])[1]")
	public WebElement twoPlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'3+')])[1]")
	public WebElement threePlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'4+')])[1]")
	public WebElement fourPlusBedroom;
	
}
