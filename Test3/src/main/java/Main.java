import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.microsoft.com/es-mx/");
        driver.findElement(By.id("shellmenu_2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("Hero-Item-panel-1")) ));
        driver.findElement(By.id("search")).click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("cli_shellHeaderSearchInput")) ));
        driver.findElement(By.id("cli_shellHeaderSearchInput")).sendKeys("XBox");
        driver.findElement(By.id("search")).click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='comprar tablas dinámicas']")) ));
        driver.findElement(By.cssSelector("[aria-label='comprar tablas dinámicas']")).click();

        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Refine by Aplicaciones']")) ));
        driver.findElement(By.cssSelector("[aria-label='Refine by Aplicaciones']")).click();

        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='c-group f-wrap-items context-list-page']")) ));

        List<WebElement> elements = driver.findElements(By.cssSelector("div[id^='coreui-productplacementlist-']"));
        for (WebElement element : elements) {
            WebElement temp= element.findElement(By.cssSelector("h3[class='c-subheading-6']"));
            //findElement(By.cssSelector("div[class='c-subheading-6'] > div"))
            System.out.println(temp.getText());
        }
            driver.quit();
    }
}