package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//img[@alt='Prime']")
    private WebElement primeButton;

    public void clickOnPrimeButton() {
        primeButton.click();
    }

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

}
