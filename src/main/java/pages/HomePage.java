package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@data-csa-c-slot-id='nav-link-accountList']")
    private WebElement accountList;
    @FindBy(xpath = "//input[@name='field-keywords']")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@value='Go']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cartButton;
    @FindBy(xpath = "//div[@id='nav-xshop']//a[contains(text(),'Sell')]")
    private WebElement sellButton;

    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement logoButton;

    @FindBy(xpath = "//a[contains(text(), 'Registry')]")
    private WebElement registryButton;

    public void clickOnRegistryButton() {
        registryButton.click();
    }

    public void clickOnLogoButton() {
        logoButton.click();
    }

    public void enterTextToToSearchField(final String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnSellButton() {
        sellButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public void clickOnAccountList() {
        accountList.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
