package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    String strItemName;
    String strItemPrice;


    @BeforeTest
    public void setup() {
        // code to set up test environment
        System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // test methods go here
    @Test(priority = 1)
    @Parameters({"url"})
    public void openUrl(String url){
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),url,"Page URL is not matching");
    }

    @Test(priority = 2)
    public void selectCategory(){
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        categoryDropdown.click();

        WebElement cellPhonesCategory = driver.findElement(By.xpath("//option[text()='Cell Phones & Accessories']"));
        cellPhonesCategory.click();

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    @Test(priority = 3)
    public void filterByBrand() {
        WebElement appleBrandCheckbox = driver.findElement(By.xpath("//input[@aria-label='Apple']"));
        appleBrandCheckbox.click();

        WebElement firstSearchResult = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span"));
        firstSearchResult.click();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
