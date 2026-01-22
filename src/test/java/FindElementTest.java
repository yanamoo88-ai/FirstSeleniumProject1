import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
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
    public void findElementByTagName() {
        // find one element
        //tag name -> h1
        WebElement h1 = driver.findElement(By.tagName("h1")); // ybedilis chto text est
        System.out.println(h1.getText()); // vuveli text

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getAttribute("class"));


        //list
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }

    @Test
    public void findElementById() {
// find id
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement partialLink = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLink.getText());
    }

    @Test
    public void findElementByCssSelector() {
        // driver.findElement(By.tagName("h1"));
        //tag name "h1" -> scc "h1"
        driver.findElement(By.cssSelector("h1"));

        //driver.findElement(By.id("city"));
        //id "city" -> css "#city"
        driver.findElement(By.cssSelector("#city"));

        //driver.findElement(By.className("telephone"));
        //class "telephone" -> scc ".telephone"
        driver.findElement(By.cssSelector(".telephone"));

        //[attr='par']
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='city']"));

        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));

        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));

        //end to -> $
        driver.findElement(By.cssSelector("[href$='work']"));

        // composite cssSelector
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']")); // tag + class + pare
        driver.findElement(By.cssSelector("div.social-networks")); // tag + class

        // step/s below
        driver.findElement(By.cssSelector(".logo>img")); // > one step below (vniz)

        driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space> one or more steps below

        //super sposob
        //vubor opredelennogo tovara iz spiska
        //<tag> or <id> or <class>:nth-child(number)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(5)"));
        System.out.println(feedback.getText());

    }

    @Test
    public void findElementByXpath() {
        //                  //some_tag or *[@attribute='value']
        //                  // tag[2]
        //                  //tag[@attr='value1' and/or/not @attr2 = 'value2']
        //                  metodhs -> text(); contains()

        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        // driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//a[@class='telephone']"));

        //driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.xpath("//a[@href='/search']"));


        //driver.findElement(By.cssSelector("[for='city']"));
        driver.findElement(By.xpath("//label[@for='city']"));


                        //contains ->*
        //driver.findElement(By.cssSelector("[href*='car']"));
        driver.findElement(By.xpath("//a[contains(@href,'car')]"));

        //start -> ^
        //driver.findElement(By.cssSelector("[href^='/let']"));
        driver.findElement(By.xpath("//a[starts-with(@href,'/let')]"));

        // text
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'This car exceeded my expectations')]"));
        System.out.println(element.getText());

        driver.findElement(By.xpath("//span[text()=' Latest feedback from our customers ']"));
        driver.findElement(By.xpath("//span[.=' Latest feedback from our customers ']"));

        // driver.findElement(By.cssSelector("a.navigation-link[href='/search']")); // tag + class + pare
        driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/search']"));
        // driver.findElement(By.cssSelector("div.social-networks")); // tag + class
        driver.findElement(By.xpath("//div[@class='social-networks']"));




        // step/s below

        //  cssSelector -> div>a        xpath -> div/a  - one step
        //  cssSelector -> div a        xpath -> div//a - one or more steps

        //driver.findElement(By.cssSelector(".logo>img")); // > one step below (vniz)
        driver.findElement(By.xpath("//a[@class='logo']/img"));

        //driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space> one or more steps below
        driver.findElement(By.xpath("//div[@class='feedback']//*[@class='feedback-date']"));


    }

}
