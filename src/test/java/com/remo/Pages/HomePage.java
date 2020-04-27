package com.remo.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private static final String URL = "https://www.gsmarena.com/";

    @FindBy(id = "topsearch-text")
    private WebElement searchInput;

    public static HomePage openPage(WebDriver driver) {
        driver.get(URL);
        HomePage page = new HomePage(driver);
        return page;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage search(String query){
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
