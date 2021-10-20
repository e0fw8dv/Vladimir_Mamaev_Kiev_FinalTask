package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistryAndGiftingPage extends BasePage {
    @FindBy(xpath = "//img[@alt='Your Wedding Registry']")
    private WebElement weddingRegistryButton;

    public void clickOnWeddingRegistryButton() {
        weddingRegistryButton.click();
    }

    public RegistryAndGiftingPage(WebDriver driver) {
        super(driver);
    }
}
