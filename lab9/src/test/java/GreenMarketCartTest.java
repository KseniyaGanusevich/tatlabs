import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.*;

public class GreenMarketCartTest {
    private WebDriver driver = new ChromeDriver();;
    @Test
    public void addItemInCart(){
        //WebDriver driver = new ChromeDriver();
        driver.get("https://green-dostavka.by/product/grudinka-po-derevenski-mestnoe-izvestnoe-1458514/");
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button_size-m__pom7w product-modal_productBtn__BvDQz button_btnGreen__VYPVu']")));
        WebElement searchCartButton = driver.findElement(By.xpath("//*[@class='button_size-m__pom7w product-modal_productBtn__BvDQz button_btnGreen__VYPVu']"));
        searchCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='add-remove-product-button_fieldWrap__1KvKJ']")));
        List<WebElement> searchAddRemove = driver.findElements(By.xpath("//*[@class='add-remove-product-button_fieldWrap__1KvKJ']"));
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='nav_quantity__qTiah']")));
        List<WebElement> searchNavQuantity = driver.findElements(By.xpath("//*[@class='nav_quantity__qTiah'][text()=1]" ));
        Assert.assertTrue( "Adding item to cart is incorrect", searchAddRemove.size()>0 && searchNavQuantity.size()>0);
    }
    @After
    public void browserQuit(){
        driver.quit();
    }

}
