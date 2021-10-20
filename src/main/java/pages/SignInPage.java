package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignInPage extends BasePage {
    private static final int NUMBER_OF_ITEM=1;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@name='rememberMe']")
    private WebElement rememberMeCheckBox;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//a[@id='ap-account-fixup-phone-skip-link']")
    private WebElement notNowButton;
    @FindBy(xpath = "//div[@class='a-section']//select[contains(@class,'ccDropdownSelect')]")
    private WebElement selectCountryButton;
    @FindBy(xpath = "//div[@class='a-section']//option")
    private List<WebElement> countryList;
    @FindBy(xpath = "//select[@data-ng-model='selectedBusinessOrOwnershipType']//option[@label='Charity']")
    private WebElement charityOption;
    @FindBy(xpath = "//select[@data-ng-model='selectedBusinessOrOwnershipType']")
    private WebElement selectBusinessTypeButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Business name')]")
    private WebElement businessNameField;
    @FindBy(xpath = "//input[@name='Submit']")
    private WebElement agreeButton;
    @FindBy(xpath = "//div[contains(text(), 'Please confirm your selection is correct')]")
    private WebElement confirmAlertMassage;

    public boolean confirmAlertMassageVisible() {
        return confirmAlertMassage.isDisplayed();
    }

    public void clickOnAgreeButton() {
        agreeButton.click();
    }

    public void clickOnSelectCountryButton() {
        selectCountryButton.click();
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public void enterBusinessName(final String businessName) {
        businessNameField.sendKeys(businessName);
    }

    public void clickOnSelectBusinessTypeButton() {
        selectBusinessTypeButton.click();
    }

    public void clickOnCharityOption() {
        charityOption.click();
    }

    public void clickCountryListOnSecondCountry() {
        countryList.get(NUMBER_OF_ITEM).click();
    }

    public WebElement getSelectBusinessTypeButton() {
        return selectBusinessTypeButton;
    }

    public WebElement getBusinessNameField() {
        return businessNameField;
    }

    public void enterEmail(final String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(final String password) {
        inputPassword.sendKeys(password);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

    public void clickOnRememberMeCheckBox() {
        rememberMeCheckBox.click();
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
}