package framework.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollToElementUtil {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor jsExecutor;

    public ScrollToElementUtil(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void scrollToElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        boolean elementVisible = false;

        while (!elementVisible) {
            try {
                // Scroll to the element
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                // Check if the element is now visible
                elementVisible = wait.until(ExpectedConditions.visibilityOf(element)) != null;
            } catch (Exception e) {
                // Catch any exceptions and continue scrolling
            }
        }
    }
}
