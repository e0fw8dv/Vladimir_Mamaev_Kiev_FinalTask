package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrimePage extends BasePage {
    @FindBy(xpath = "//input[@value='Try Prime free for 30 days']")
    private WebElement tryPrimeFreeButton;
    @FindBy(xpath = "//div[text()='Please enter your payment information to continue.']")
    private WebElement alertMessage;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;

    public void clickOnContinueButton() {
        continueButton.click();
    }
    public WebElement getContinueButton(){
        return continueButton;
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public boolean checkThatAlertMessageIsVisible() {
        return alertMessage.isDisplayed();
    }

    public void clickOnTryPrimeFreeButton() {
        tryPrimeFreeButton.click();
    }

    public PrimePage(WebDriver driver) {
        super(driver);
    }
}
