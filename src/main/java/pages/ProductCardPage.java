package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCardPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Top 100')]")
    private WebElement top100Link;

    public void clickOnTop100Link() {
        top100Link.click();
    }

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }
}
