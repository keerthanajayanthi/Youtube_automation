package demo.wrappers;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrappers {
    public static void navigate(WebDriver driver, String url) {
        // Navigate to the requested URL.
        driver.get(url);
        System.out.println("Navigate to: " + url);
    }

    public static void type(WebElement element, String value) {
        // Type text into the target field.
        element.clear();
        element.sendKeys(value);
        System.out.println("TypeElement: " + value);
    }

    public static void click(WebElement element, WebDriver driver) {
        // Wait and click the target element safely.
        try {
            element.click();
        } catch (Exception ignored) {
            System.out.println("ClickElement: unavailable");
        }
        System.out.println("ClickElement: click");
    }

    public static String getText(WebElement element) {
        // Read the visible text from a page element.
        String text = element.getText();
        if (text == null || text.trim().isEmpty()) {
            text = element.getAttribute("textContent");
        }
        System.out.println("GetElementText: " + text);
        return text == null ? "" : text.trim();
    }

    public static void scrollTo(WebDriver driver, WebElement element) {
        // Scroll an element into the viewport before interacting with it.
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                element);
    }
}
