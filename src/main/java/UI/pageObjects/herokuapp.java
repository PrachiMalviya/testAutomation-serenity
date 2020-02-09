package UI.pageObjects;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@DefaultUrl("https://www.etsy.com")
public class herokuapp extends PageObject{
    @FindBy(css="#content > a[text='Basic Auth']")
    WebElement basicAuthButton;
    WebDriver driver = getDriver();
    public void login()
    {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("admin" + Keys.TAB + "admin" + Keys.TAB);
        alert.accept();
        driver.switchTo().defaultContent();
    }

}
