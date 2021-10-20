package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    private static final int NUMBER_OF_ITEM=1;

   @FindBy(xpath = "//span[@id='nav-cart-count']")
   private WebElement totalProductOnCart;
   @FindBy(xpath = "//input[@name='submit.addToCart']")
   private List<WebElement> listOfRecommendations;
   public void clickAddSecondProduct(){listOfRecommendations.get(NUMBER_OF_ITEM).click();}
    public WebElement getTotalProductOnCart(){return totalProductOnCart;}


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
}
