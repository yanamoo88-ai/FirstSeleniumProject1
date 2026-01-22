import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_NewTest2{
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        // maximize browser to windows
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Computers"));
        System.out.println(linkText.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement returns = driver.findElement(By.partialLinkText("Returns"));
        System.out.println(returns.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tag "h3"
        WebElement h3 = driver.findElement(By.cssSelector("h3"));
        System.out.println(h3.getText());

        WebElement h2 = driver.findElement(By.cssSelector("h2"));
        System.out.println(h2.getText());

        //id -> css #
        driver.findElement(By.cssSelector("#small-searchterms"));

        driver.findElement(By.cssSelector("#newsletter-email"));

        driver.findElement(By.cssSelector("#nivo-slider"));

        //className -> .
        driver.findElement(By.cssSelector(".ico-register"));

        driver.findElement(By.cssSelector(".ico-cart"));

        driver.findElement(By.cssSelector(".topic-html-content-body"));

        //[attr='par']
        WebElement element = driver.findElement(By.cssSelector("[href='/sitemap']"));
        System.out.println(element.getText());

        driver.findElement(By.cssSelector("[href='/privacy-policy']"));

        //contains -> * - soderjanie texta
        WebElement element1 = driver.findElement(By.cssSelector("[href*='/recently']"));
        System.out.println(element1.getText());

        //start -> ^ - nachalo stroki
        WebElement element2 = driver.findElement(By.cssSelector("[href*='viewed']"));
        System.out.println(element2.getText());

        //end to -> $ - konec stroky
        WebElement element3 = driver.findElement(By.cssSelector("[href$='products']"));
        System.out.println(element3.getText());

        // composite cssSelector
        driver.findElement(By.cssSelector("div.block-manufacturer-navigation"));

        driver.findElement(By.cssSelector("div.tags"));

        // step/s below
        driver.findElement(By.cssSelector(".nivo-imageLink>img"));// > one step below (vniz)

        driver.findElement(By.cssSelector(".header-selectors-wrapper .language-selector")); // <space> one or more steps below

        //<tag> or <id> or <class>:nth-child(number)
        WebElement element6 = driver.findElement(By.cssSelector(".inactive:nth-child(4)"));
        System.out.println(element6.getText());
    }
}
