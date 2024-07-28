package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class EBayTestingApp {

    public static final String SEARCHFIELD = "_nkw";
    public static final String COOKIES_ACCEPT_BUTTON = "gdpr-banner-accept";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
            driver.get("https://www.ebay.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement acceptCookiesButton = driver.findElement(By.id(COOKIES_ACCEPT_BUTTON));
        acceptCookiesButton.click();

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("Laptop");
        searchField.submit();}
}




