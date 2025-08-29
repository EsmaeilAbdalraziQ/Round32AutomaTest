package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
/*
#2 ___ Basic ___
Open Google Chrome
Navigate to [https://duckduckgo.com/]
Assert that the DuckDuckGo logo is displayed
Close Google Chrome
*/
public class Test2Class {
    WebDriver driver;

    @Test
    public void Test2() {
        driver = new ChromeDriver();

        driver.get("https://duckduckgo.com");

        //WebElement Logo = driver.findElement(By.cssSelector("a[aria-label=\"Learn about DuckDuckGo\"]img"));
        //WebElement Logo = driver.findElement(By.cssSelector("a[href='/about'] img"));
        //Logo.getAttribute("src").startsWith("data:image/svg+xml");

        WebElement Logo = driver.findElement(By.className("header_logoHorizontal__KABN4"));

        Assert.assertTrue(Logo.isDisplayed(), "No duck duck go Logo should be displayed on the page.");

    }

    @AfterTest
    public void Teardown() {
        driver.quit();
    }
}
