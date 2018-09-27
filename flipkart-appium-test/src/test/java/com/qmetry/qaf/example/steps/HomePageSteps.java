package com.qmetry.qaf.example.steps;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.example.pages.HomePage;

public class HomePageSteps {

	@QAFTestStep(description = "user is on flipkart home page")
	public static void verifyUserOnFlipkartHomePage() {
		HomePage homePage = new HomePage();
		if (homePage.getCloseIcon().isDisplayed()) {
			homePage.getCloseIcon().click();
		}
		Validator.verifyTrue(homePage.getFlipkartLogo().isDisplayed(), "flipkart logo is not displayed",
				"flipkart logo is displayed");
	}

	@QAFTestStep(description = "user open navigation menu")
	public static void clickOnNavigationMenu() {
		HomePage homePage = new HomePage();
		homePage.getDrawerButton().click();
	}

	@QAFTestStep(description = "user click on category {0}")
	public static void clickOnCategory(String categoryName) {
		HomePage homePage = new HomePage();
		homePage.getCategoryOption(categoryName).click();
	}

	@QAFTestStep(description = "verify category page {0} is displayed")
	public static void verifyCategoryPage(String categoryName) {
		HomePage homePage = new HomePage();
		Validator.verifyThat("category page " + categoryName + " is displayed",
				homePage.getCategoryPageTitle().getText(), Matchers.containsString(categoryName));
	}

	@QAFTestStep(description = "user click on subcategory {0}")
	public static void clickOnSubCategory(String subCategoryName) {
		HomePage homePage = new HomePage();
		homePage.getSubCategoryOption(subCategoryName).click();
	}

	@QAFTestStep(description = "verify subcategory page {0} is displayed")
	public static void verifySubCategoryPage(String subcategoryName) {
		HomePage homePage = new HomePage();
		Validator.verifyThat("subcategory page " + subcategoryName + " is displayed",
				homePage.getSubCategoryPageTitle().getText(), Matchers.containsString(subcategoryName));
	}

	@QAFTestStep(description = "verify view all button functionality")
	public static void verifyViewAllButtonFunctionality() {
		HomePage homePage = new HomePage();
		homePage.getViewAllButton().click();
		Validator.verifyThat("counter is displayed with correct count", homePage.getCounterView().getText(),
				Matchers.containsString(ConfigurationManager.getBundle().getString("counter.text")));
	}

	@QAFTestStep(description = "user search for item {0}")
	public static void searchForItem(String itemName) {
		HomePage homePage = new HomePage();
		homePage.getSearchTextbox().click();
		homePage.getSearchAutocompleteTextview().sendKeys(itemName);
		homePage.getSearchSuggestionResult().click();
	}

	@QAFTestStep(description = "verify search results are displayed for the item {0}")
	public static void verifySearchResultsDisplayedForItem(String itemName) {
		HomePage homePage = new HomePage();
		homePage.getSearchResultItemImage().waitForVisible();
		homePage.getSearchResultItemWishlistIcon().waitForVisible();
		Validator.verifyThat("search results are displayed", homePage.getSearchResultsItemList(itemName.trim()).size(),
				Matchers.greaterThan(0));
		for (int i = 0; i < homePage.getSearchResultsItemList(itemName.trim()).size(); i++) {
			Validator.verifyTrue(homePage.getSearchResultsItemList(itemName.trim()).get(i).isDisplayed(),
					"search results are not displayed for the item " + itemName,
					"search results are displayed for the item " + itemName);
		}
	}

	@QAFTestStep(description = "verify item attributes on category page")
	public static void verifyItemAttributesOnCategoryPage() {
		HomePage homePage = new HomePage();
		homePage.waitForPageToLoad();
		homePage.waitForAjaxToComplete();
		Validator.verifyTrue(homePage.getSearchResultItemImage().isDisplayed(), "product image is not displayed",
				"product image is displayed");
		Validator.verifyTrue(homePage.getSearchResultItemPrice().get(0).isDisplayed(), "product price is not displayed",
				"product price is displayed");
		Validator.verifyTrue(homePage.getSearchResultItemWishlistIcon().isDisplayed(), "wishlist icon is not displayed",
				"wishlist icon is displayed");
	}

	@QAFTestStep(description = "verify Sort and Filter functionality on search results page")
	public static void verifySortAndFilterFunctionality() {
		HomePage homePage = new HomePage();
		homePage.getSearchResultItemImage().waitForVisible();
		homePage.getSearchResultItemWishlistIcon().waitForVisible();
		homePage.clickOnButton("Sort");
		homePage.getSortOptionInput(ConfigurationManager.getBundle().getString("sort.option.name")).click();
		homePage.verifyItemIsSortedByPrice();
		homePage.clickOnButton("Filter");
		homePage.getFilterOption(ConfigurationManager.getBundle().getString("filter.option.name")).click();
		homePage.getSortOptionInput(ConfigurationManager.getBundle().getString("brand.name")).click();
		homePage.getSortOptionInput(ConfigurationManager.getBundle().getString("brand.name")).waitForVisible();
		homePage.getSortOptionInput(ConfigurationManager.getBundle().getString("brand.name")).click();
		homePage.clickOnButton("DONE");
		homePage.clickOnButton("APPLY");
		verifySearchResultsDisplayedForItem(ConfigurationManager.getBundle().getString("brand.name"));
	}

	@QAFTestStep(description = "user select item from the search result")
	public static void selectItemFromSearchResult() {
		HomePage homePage = new HomePage();
		homePage.getSearchResultItemImage().waitForVisible();
		homePage.getSearchResultItemWishlistIcon().waitForVisible();
		new WebDriverTestBase().getDriver().findElements("flipkart.search.results.page.item.image").get(3).click();
	}
}
