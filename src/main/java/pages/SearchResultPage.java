package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    private static final int NUMBER_OF_ITEM=0;
    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    private WebElement dropdownButton;
    @FindBy(xpath = "//a[contains(text(),' Deals')]")
    private WebElement todaysDealsLink;
    @FindBy(xpath = "//div[@id='brandsRefinements']//*[contains(text(), 'Saucony Originals')]")
    private WebElement brandFilterCheckbox;
    @FindBy(xpath = "//span[contains(text(), 'Saucony Originals ')]")
    private List<WebElement> listOfShoes;
    @FindBy(xpath = "//h2//span[contains(text(),'Saucony Men')]")
    private List<WebElement> sauconyList;
    @FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
    private WebElement reviewFilter;
    @FindBy(xpath = "//a[@role='button']//span[@class='a-icon-alt']")
    private List<WebElement> listOfStars;

    public void clickOnBrandFilterCheckbox() {
        brandFilterCheckbox.click();
    }

    public List<WebElement> gerListOfShoes() {
        return listOfShoes;
    }

    public List<WebElement> getListOfStars() {
        return listOfStars;
    }

    public void clickOnReviewFilter() {
        reviewFilter.click();
    }

    public void clickOnTodaysDealsLink() {
        todaysDealsLink.click();
    }

    public void clickSauconyListFirstProduct() {
        sauconyList.get(NUMBER_OF_ITEM).click();
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
