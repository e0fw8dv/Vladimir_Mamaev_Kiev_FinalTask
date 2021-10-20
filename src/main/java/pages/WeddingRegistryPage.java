package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeddingRegistryPage extends BasePage{
    @FindBy(xpath = "//a[@class='wedding__btn wedding-hero__cta']")
    private WebElement createYourRegistryButton;
    public void clickOnCreateYourRegistryButton(){createYourRegistryButton.click();}
    @FindBy(xpath = "//input[@name='firstNamePartner1']")
    private WebElement firstNamePartnerOneInput;
    @FindBy(xpath = "//input[@name='surnamePartner1']")
    private WebElement surnamePartnerOneInput;
    @FindBy(xpath = "//input[@name='firstNamePartner2']")
    private WebElement firstNamePartnerTwoInput;
    @FindBy(xpath = "//input[@name='surnamePartner2']")
    private WebElement surnamePartnerTwoInput;
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    private WebElement nextButton;
    public void clickOnNextButton(){nextButton.click();}
    @FindBy(xpath = "//div[text()='Please enter a valid date']")
    private WebElement alertMessage;
    public WebElement getAlertMessage(){return alertMessage;}
    public WebElement getNextButton(){return nextButton;}
    public boolean alertMessageVisible(){return alertMessage.isDisplayed();}
    public void enterNamePartnerOne(final String nameOne){
        firstNamePartnerOneInput.sendKeys(nameOne);
    }
    public void enterSurnamePartnerOne(final String surnameOne){
        surnamePartnerOneInput.sendKeys(surnameOne);
    }
    public void enterNamePartnerTwo(final String nameTwo){
        firstNamePartnerTwoInput.sendKeys(nameTwo);
    }
    public void enterSurnamePartnerTwo(final String surnameTwo){
        surnamePartnerTwoInput.sendKeys(surnameTwo);
    }

    public WeddingRegistryPage(WebDriver driver) {
        super(driver);
    }
}
