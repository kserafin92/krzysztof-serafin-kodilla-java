package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span";
    public static final String CSS_CREATE_ACCOUNT = "[data-testid='open-registration-form-button']";
    public static final String XPATH_DAY = "//select[@name='birthday_day']";
    public static final String XPATH_MONTH = "//select[@name='birthday_month']";
    public static final String XPATH_YEAR = "//select[@name='birthday_year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.pl/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_ACCEPT_COOKIES)));
        acceptCookiesButton.click();

        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CSS_CREATE_ACCOUNT)));
        createAccountButton.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_DAY)));


        WebElement dayDropdown = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByValue("10");


        WebElement monthDropdown = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByValue("11");

        WebElement yearDropdown = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue("1990");

    }
}
