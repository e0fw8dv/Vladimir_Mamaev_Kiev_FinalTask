package stepdefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final int BEGIN_OF_THE_SUBSTRING=10;
    private static final int END_OF_THE_SUBSTRING=12;
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    CreateAccountPage createAccountPage;
    ShoppingCartPage shoppingCartPage;
    SearchResultPage searchResultPage;
    SellPage sellPage;
    TodaysDealsPage todaysDealsPage;
    WeddingRegistryPage weddingRegistryPage;
    RegistryAndGiftingPage registryAndGiftingPage;
    BestSellersPage bestSellersPage;
    ProductCardPage productCardPage;
    PrimePage primePage;


    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User clicks 'Hello,Sign in'  button")
    public void clickHelloSignInButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnAccountList();
    }

    @And("User enters {string} in email  field")
    public void enterValidEmail(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterEmail(email);
    }

    @And("User clicks 'Continue' button")
    public void clickOnContinueButton() {
        signInPage.waitUntilElementElementToBeClickable(DEFAULT_TIMEOUT, signInPage.getContinueButton());
        signInPage.clickOnContinueButton();
    }

    @And("User enters {string} in password field")
    public void enterPassword(final String password) {
        signInPage.enterPassword(password);
    }

    @Then("User checks that current url contains {string}")
    public void checkThatCurrentUrlContainsKeyword(final String keyword) {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("User clicks 'rememberMeCheckBox' button")
    public void clickRememberMeCheckBoxButton() {
        signInPage.clickOnRememberMeCheckBox();
    }

    @And("User clicks 'Sign in' button")
    public void userClicksSignInButton() {
        signInPage.clickOnContinueButton();
    }

    @And("User clicks 'Create your Amazon account' button")
    public void clickOnCreateYourAmazonAccountButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickOnCreateAccountButton();
    }

    @And("User enters your name field with {string}")
    public void enterValidNameValue(final String validName) {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        createAccountPage.enterValidName(validName);
    }

    @And("User enters email field with {string}")
    public void enterValidEmailValue(final String validEmail) {
        createAccountPage.enterValidEmail(validEmail);
    }

    @And("User enters password field with {string}")
    public void enterValidPassword(final String validPassword) {
        createAccountPage.enterValidPassword(validPassword);
    }

    @And("User enters check password with {string}")
    public void enterInvalidPassword(final String invalidPassword) {
        createAccountPage.enterInvalidPassword(invalidPassword);
    }

    @And("User clicks 'Create your Amazon account' button'")
    public void clickOnCreateYourAccountButton() {
        createAccountPage.clickOnCreateYourAccountButton();
    }

    @Then("User gets password mismatch error message")
    public void checkPasswordMismatchErrorMessageVisible() {
        assertTrue(createAccountPage.isPasswordMismatchAlertVisible());
    }

    @When("User clicks 'Cart' button")
    public void clickOnCartButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnCartButton();
    }

    @And("User clicks add to 'Cart' on second product")
    public void clickAddToCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickAddSecondProduct();
    }

    @And("User checks that amount of products in 'Cart' are {string}")
    public void checkThatAmountOfProductsInCart(final String amountOfProducts) {
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(amountOfProducts, shoppingCartPage.getTotalProductOnCart().getText());
    }

    @When("User clicks on 'Sell' button")
    public void clickOnSellButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnSellButton();
    }

    @And("User chooses business location")
    public void chooseBusinessLocation() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickOnSelectCountryButton();
        signInPage.clickCountryListOnSecondCountry();
    }

    @And("User chooses business type")
    public void chooseBusinessType() {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getSelectBusinessTypeButton());
        signInPage.clickOnSelectBusinessTypeButton();
        signInPage.clickOnCharityOption();
    }

    @And("User enters {string} in business name")
    public void enterValidName(final String businessName) {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getBusinessNameField());
        signInPage.enterBusinessName(businessName);
    }

    @And("User clicks on 'Agree and confirm' button")
    public void clickOnAgreeButton() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickOnAgreeButton();
    }

    @Then("User gets confirmation alert message")
    public void getConfirmationAlertMessage() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(signInPage.confirmAlertMassageVisible());
    }

    @And("User clicks on 'Sign up seller' button")
    public void clickOnSignUpSellerButton() {
        sellPage = pageFactoryManager.getSellPage();
        sellPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellPage.clickOnSignUpSellerButton();
    }


    @When("User makes search by keyword {string}")
    public void makeSearchByKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.enterTextToToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickOnSearchButton();
    }

    @And("User chooses sort by 'Avg.Customer Review'")
    public void chooseSortByAvgCustomerReview() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnReviewFilter();
    }

    @And("User checks the sorting of products by reviews")
    public void checkThatProductsSortByReview() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        List<String> actualResult = searchResultPage.getListOfStars().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedResult = searchResultPage.getListOfStars().stream().map(WebElement::getText).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        assertEquals(actualResult, expectedResult);
    }

    @And("User clicks 'Today's Deals' button")
    public void clickTodaySDealsButton() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnTodaysDealsLink();
    }

    @Then("User checks amount of search results")
    public void checkAmountOfSearchResults() {
        todaysDealsPage = pageFactoryManager.getTodaysDealsPage();
        todaysDealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        String actualResult = valueOf(todaysDealsPage.getListOfProducts().size());
        String expectedResult = todaysDealsPage.getShowingProductAmount().getText().substring(BEGIN_OF_THE_SUBSTRING, END_OF_THE_SUBSTRING);
        assertEquals(actualResult, expectedResult);
    }

    @And("User clicks 'Registry' button")
    public void clickRegistryButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnRegistryButton();
    }

    @And("User clicks 'Wedding Registry' button")
    public void clickWeddingRegistry() {
        registryAndGiftingPage = pageFactoryManager.getRegistryAndGiftingPage();
        registryAndGiftingPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        registryAndGiftingPage.clickOnWeddingRegistryButton();
    }

    @And("User clicks 'Create your registry' button")
    public void clickCreateYourRegistryButton() {
        weddingRegistryPage = pageFactoryManager.getWeddingRegistryPage();
        weddingRegistryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        weddingRegistryPage.clickOnCreateYourRegistryButton();
    }

    @And("User clicks 'Next' button")
    public void clickNextButton() {
        weddingRegistryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        weddingRegistryPage.waitUntilElementElementToBeClickable(DEFAULT_TIMEOUT, weddingRegistryPage.getNextButton());
        weddingRegistryPage.clickOnNextButton();
    }

    @And("User enters {string} in name first partner")
    public void enterNameOne(final String nameOne) {
        weddingRegistryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        weddingRegistryPage.enterNamePartnerOne(nameOne);
    }

    @And("User enters {string} surname first partner")
    public void enterSurnameOne(final String surnameOne) {
        weddingRegistryPage.enterSurnamePartnerOne(surnameOne);
    }

    @And("User enters {string} name second partner")
    public void userEntersNameTwo(final String nameTwo) {
        weddingRegistryPage.enterNamePartnerTwo(nameTwo);
    }

    @And("User enters {string}surname second partner")
    public void userEntersSurnameTwo(final String surnameTwo) {
        weddingRegistryPage.enterSurnamePartnerTwo(surnameTwo);
    }

    @Then("User gets alert message")
    public void userGetsAlertMessage() {
        weddingRegistryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, weddingRegistryPage.getAlertMessage());
        assertTrue(weddingRegistryPage.alertMessageVisible());
    }


    @And("User clicks brand filer value")
    public void userClicksBrandFilerValue() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnBrandFilterCheckbox();
    }

    @Then("User checks all products contains {string}")
    public void userChecksAllProductsContainsBrandWords(final String brandWords) {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement i : searchResultPage.gerListOfShoes()) {
            assertTrue(i.getText().contains(brandWords));
        }
    }

    @When("User clicks logo")
    public void userClicksLogo() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnLogoButton();
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickSauconyListFirstProduct();
    }

    @And("User clicks on 'Top 100' link")
    public void userClicksOnTopLink() {
        productCardPage = pageFactoryManager.getProductCardPage();
        productCardPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productCardPage.clickOnTop100Link();
    }

    @And("User clicks 'Next page' button")
    public void userClicksNext() {
        bestSellersPage = pageFactoryManager.getBestSellersPage();
        bestSellersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bestSellersPage.clickOnNextPageButton();
    }

    @Then("User checks last product number")
    public void checkLustProductNumber() {
        bestSellersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(bestSellersPage.lastProductNumberVisibility());
    }

    @And("User clicks 'Prime' button")
    public void clickOnPrimeButton() {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        myAccountPage.clickOnPrimeButton();
    }

    @And("User clicks 'Try Prime free' button")
    public void clickOnTryPrimeFreeButton() {
        primePage = pageFactoryManager.getPrimePage();
        primePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        primePage.clickOnTryPrimeFreeButton();
    }

    @And("User gets warning message")
    public void getWarningMessage() {
        primePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        primePage.moveToElement(primePage.getContinueButton());
        primePage.clickOnContinueButton();
        primePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, primePage.getAlertMessage());
        assertTrue(primePage.checkThatAlertMessageIsVisible());
    }



 @After
    public void tearDown() {
        driver.close();
    }

}


