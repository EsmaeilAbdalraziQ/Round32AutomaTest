package testPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
/*
#1 ___ Basic ___
Open Google Chrome
Navigate to [https://duckduckgo.com/]
Assert that the page title is [Google]
Close Google Chrome
*/
public class TestClass {
    WebDriver driver;

    @Test
    public void Test1() {
        driver = new ChromeDriver();
        driver.get("https://duckduckgo.com");
        Assert.assertEquals(driver.getTitle(),
                "Google",
                "Wrong Title");
    }

    @AfterTest
    public void Teardown() {
        driver.quit();
    }

}

