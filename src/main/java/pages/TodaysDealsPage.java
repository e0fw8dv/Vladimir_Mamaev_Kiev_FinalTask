package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodaysDealsPage extends BasePage{
    @FindBy(xpath = "//div[@class='a-section backGround layer']")
    private List<WebElement>  listOfProducts;

    public List<WebElement> getListOfProducts(){return listOfProducts;}
    @FindBy(xpath = "//span[contains(text(),'Showing')]")
    private WebElement showingProductAmount;
    public WebElement getShowingProductAmount(){return showingProductAmount;}

    public TodaysDealsPage(WebDriver driver) {
        super(driver);
    }
}
