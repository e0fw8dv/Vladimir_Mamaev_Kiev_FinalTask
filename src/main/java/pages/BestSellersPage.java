package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BestSellersPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Next page')]")
    private WebElement nextPageButton;
    @FindBy(xpath = "//span[contains(text(),'#100')]")
    private WebElement lastProductNumber;

    public boolean lastProductNumberVisibility() {
        return lastProductNumber.isDisplayed();
    }

    public void clickOnNextPageButton() {
        nextPageButton.click();
    }

    public BestSellersPage(WebDriver driver) {
        super(driver);
    }
}
