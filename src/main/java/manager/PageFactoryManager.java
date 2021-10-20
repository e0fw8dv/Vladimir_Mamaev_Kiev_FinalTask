package manager;

import org.openqa.selenium.WebDriver;

import pages.*;


public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage(driver);
    }

    public CreateAccountPage getCreateAccountPage() {
        return new CreateAccountPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public SellPage getSellPage() {
        return new SellPage(driver);
    }

    public TodaysDealsPage getTodaysDealsPage() {
        return new TodaysDealsPage(driver);
    }

    public WeddingRegistryPage getWeddingRegistryPage() {
        return new WeddingRegistryPage(driver);
    }

    public RegistryAndGiftingPage getRegistryAndGiftingPage() {
        return new RegistryAndGiftingPage(driver);
    }

    public ProductCardPage getProductCardPage() {
        return new ProductCardPage(driver);
    }

    public BestSellersPage getBestSellersPage() {
        return new BestSellersPage(driver);
    }

    public PrimePage getPrimePage() {
        return new PrimePage(driver);
    }

}

