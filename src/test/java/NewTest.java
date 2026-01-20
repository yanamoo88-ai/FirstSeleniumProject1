import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class NewTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp () {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        // maximize browser to windows
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }
    @Test
    public void findElementByTagName() {
        WebElement h3 = driver.findElement(By.tagName("h3"));
        System.out.println(h3.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement strong = driver.findElement(By.tagName("strong"));
        System.out.println(strong.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        List<WebElement> links1 = driver.findElements(By.tagName("div"));
        System.out.println(links1.size());
    }
    @Test
    public void FindElementById(){
        WebElement element = driver.findElement(By.id("small-searchterms"));
        System.out.println(element.getAttribute("id"));

        WebElement element1 = driver.findElement(By.id("newsletter-email"));
        System.out.println(element1.getAttribute("id"));

        WebElement element2 = driver.findElement(By.id("nivo-slider"));
        System.out.println(element2.getAttribute("id"));
    }
    @Test
    public void FindElementByClassName() {
        WebElement element = driver.findElement(By.className("ico-register"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.className("ico-cart"));
        System.out.println(element1.getAttribute("class"));

        WebElement element2 = driver.findElement(By.className("topic-html-content-body"));
        System.out.println(element2.getText());
    }
}
