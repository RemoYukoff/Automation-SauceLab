package com.remo.Tests;

import com.remo.Pages.HomePage;
import com.remo.Pages.SearchResultsPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class Testing extends TestBase {
    @Test(dataProvider = "hardCodedBrowsers")
    public void searchTest(String browser, String version, String os, Method method) throws IOException {
        String query = "samsung";

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Opening GSMArena homepage...");
        HomePage page = HomePage.openPage(driver);

        this.annotate("Searching for "+query);
        SearchResultsPage resultsPage = page.search(query);

        this.annotate("Asserting that results page contain items with "+query+"...");
        for (WebElement phoneNameSpan: resultsPage.getReviewResults()){
            String phoneName = phoneNameSpan.getText();
            Assert.assertTrue(StringUtils.containsIgnoreCase(phoneName, query), "Invalid search results!");
        }
    }
}
