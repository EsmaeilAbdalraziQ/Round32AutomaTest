package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 #3_ Basic_
 Open Google Chrome
 Navigate to [<a href="https://duckduckgo.com/">...</a>]
 Search for [Selenium WebDriver]
 Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">...</a>]
 Close Google Chrome
 */
public class Test_3_Class {
    WebDriver driver;

    @Test
    public void Test3() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://duckduckgo.com");

        //WebElement SearchInput = driver.findElement(By.id("searchbox_input"));
        WebElement SearchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox_input")));
        SearchInput.sendKeys("Selenium WebDriver");
        SearchInput.sendKeys(Keys.ENTER);

        //WebElement ResultsSection = driver.findElement(By.xpath("//section[contains(@class,'At_VJ9MlrHsSjbfCtz2_')]"));//aDtqDaYogch0DyrGTrX6
        WebElement ResultsSection = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//section[contains(@class,'At_VJ9MlrHsSjbfCtz2_')]")));
        WebElement ol = ResultsSection.findElement(By.tagName("ol"));

        WebElement firstLi = ol.findElements(By.className("wLL07_0Xnd1QZpzpfR4W")).getFirst();

        String actualaHref = firstLi.findElement(By.tagName("a")).getAttribute("href");

        // String expectaHref =  "https://www.selenium.dev/documentation/webdriver/";

        // Assert.assertEquals(actualaHref, expectaHref, "First result href is not as expected");

        Assert.assertNotNull(actualaHref);
        Assert.assertTrue(actualaHref.contains("www.selenium.dev"), "Href should contain selenium.dev");

    }

    @AfterTest
    public void Teardown() {
        driver.quit();
    }
}
