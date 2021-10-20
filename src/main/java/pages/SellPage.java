package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellPage extends BasePage {
    @FindBy(xpath = "//a[@class='link  button button-type-primary font-size-regular']")
    private WebElement signUpSellerButton;

    public void clickOnSignUpSellerButton() {
        signUpSellerButton.click();
    }

    public SellPage(WebDriver driver) {
        super(driver);
    }
}
