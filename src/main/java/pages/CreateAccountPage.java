package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='passwordCheck']")
    private WebElement passwordCheckInput;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement createYourAmazonAccountButton;


    public void enterValidName(final String validName) {
        nameInput.sendKeys(validName);
    }

    public void enterValidEmail(final String validEmail) {
        emailInput.sendKeys(validEmail);
    }

    public void enterValidPassword(final String validPassword) {
        passwordInput.sendKeys(validPassword);
    }

    public void enterInvalidPassword(final String invalidPassword) {
        passwordCheckInput.sendKeys(invalidPassword);
    }

    public boolean isPasswordMismatchAlertVisible() {
        return passwordInput.isDisplayed();
    }

    public void clickOnCreateYourAccountButton() {
        createYourAmazonAccountButton.click();
    }

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

}
