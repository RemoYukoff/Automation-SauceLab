package com.remo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    @FindBy(id = "//*[@id='review-body']//li//span")
    private List<WebElement> reviewResults;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getReviewResults(){
        return reviewResults;
    }
}
