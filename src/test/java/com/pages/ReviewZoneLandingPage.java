package com.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

public class ReviewZoneLandingPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ReviewZoneLandingPage.class);

    public void openBrowser(){
        logger.info(Thread.currentThread().getId() +":Test started..!!" + driver.toString());
    }

    public void openUrl(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info(Thread.currentThread().getId() +":Launched URL.:" + url);
    }

    public void loginWithUser(String user) {
        waitForElementToBeClickable("//button[.='Log in']");
        driver.findElement(By.xpath("//button[.='Log in']")).click();
        waitForElementToBeClickable("//input[@name='email']");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1qaz!QAZ");
        driver.findElement(By.xpath("//button[.='Sign in']")).click();
        waitForElementToBeVisible("//h3[.='Total Reviews']");

    }

    public String getTitle() {
        logger.info(":Get Title:");
        return driver.getTitle();
    }
}
