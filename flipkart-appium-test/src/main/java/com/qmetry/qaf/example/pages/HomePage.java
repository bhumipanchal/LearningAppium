package com.qmetry.qaf.example.pages;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "flipkart.home.page.logo")
	private QAFWebElement flipkartLogo;
	@FindBy(locator = "flipkart.home.page.drawer.button")
	private QAFWebElement drawerButton;
	@FindBy(locator = "flipkart.category.page.title")
	private QAFWebElement categoryPageTitle;
	@FindBy(locator = "flipkart.subcategory.page.title")
	private QAFWebElement subCategoryPageTitle;
	@FindBy(locator = "flipkart.home.page.view.all.button")
	private QAFWebElement viewAllButton;
	@FindBy(locator = "flipkart.category.page.counter.view")
	private QAFWebElement counterView;
	@FindBy(locator = "flipkart.home.page.search.textbox")
	private QAFWebElement searchTextbox;
	@FindBy(locator = "flipkart.home.page.search.autocomplete.textview")
	private QAFWebElement searchAutocompleteTextview;
	@FindBy(locator = "flipkart.home.page.search.suggestion.result")
	private QAFWebElement searchSuggestionResult;
	@FindBy(locator = "flipkart.search.results.page.item.image")
	private QAFWebElement searchResultItemImage;
	@FindBy(locator = "flipkart.search.results.page.item.price")
	private List<QAFWebElement> searchResultItemPrice;
	@FindBy(locator = "flipkart.search.results.page.item.wishlist.icon")
	private QAFWebElement searchResultItemWishlistIcon;
	@FindBy(locator = "flipkart.wishlist.page.item.title")
	private QAFWebElement wishlistPageItemTitle;
	@FindBy(locator = "flipkart.home.page.close.icon")
	private QAFWebElement closeIcon;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public QAFWebElement getCloseIcon() {
		return closeIcon;
	}

	public QAFWebElement getWishlistPageItemTitle() {
		return wishlistPageItemTitle;
	}

	public QAFWebElement getSearchResultItemImage() {
		return searchResultItemImage;
	}

	public List<QAFWebElement> getSearchResultItemPrice() {
		return searchResultItemPrice;
	}

	public QAFWebElement getSearchResultItemWishlistIcon() {
		return searchResultItemWishlistIcon;
	}

	public QAFWebElement getSearchSuggestionResult() {
		return searchSuggestionResult;
	}

	public QAFWebElement getSearchAutocompleteTextview() {
		return searchAutocompleteTextview;
	}

	public QAFWebElement getSearchTextbox() {
		return searchTextbox;
	}

	public QAFWebElement getCounterView() {
		return counterView;
	}

	public QAFWebElement getViewAllButton() {
		return viewAllButton;
	}

	public QAFWebElement getSubCategoryPageTitle() {
		return subCategoryPageTitle;
	}

	public QAFWebElement getFlipkartLogo() {
		return flipkartLogo;
	}

	public QAFWebElement getDrawerButton() {
		return drawerButton;
	}

	public QAFWebElement getCategoryPageTitle() {
		return categoryPageTitle;
	}

	@SuppressWarnings("rawtypes")
	public void scrollBackwardByCoordinates() throws MalformedURLException, InterruptedException {
		TouchAction action = new TouchAction(DriverUtils.getAndroidDriver());
		Dimension size = driver.manage().window().getSize();
		int startx = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.2);
		int endy = (int) (size.getHeight() * 0.8);
		action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(startx, endy)).release().perform();
	}

	public void clickOnButton(String buttonText) {
		getButtonByText(buttonText).click();
	}

	public void scrollToElement(QAFWebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitForAjaxToComplete();
	}

	@Override
	public void waitForAjaxToComplete() {
		try {
			(new WebDriverWait(getTestBase().getDriver(), 30)).until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					JavascriptExecutor js = getTestBase().getDriver();
					return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");

				}
			});
		} catch (Exception e) {
		}
	}

	public List<QAFWebElement> getSearchResultsItemList(String itemName) {
		List<QAFWebElement> searchResultsItemsList = getTestBase().getDriver()
				.findElements(String.format(pageProps.getString("flipkart.search.results.page.item.name"), itemName));
		return searchResultsItemsList;
	}

	public QAFWebElement getButtonByText(String buttonText) {
		String buttonElement = String.format(pageProps.getString("flipkart.app.button.by.text"), buttonText);
		QAFExtendedWebElement button = new QAFExtendedWebElement(buttonElement);
		return button;
	}

	public QAFWebElement getCategoryOption(String categoryName) {
		String category = String.format(pageProps.getString("flipkart.home.page.drawer.category.option"), categoryName);
		QAFExtendedWebElement categoryOption = new QAFExtendedWebElement(category);
		return categoryOption;
	}

	public QAFWebElement getSubCategoryOption(String subCategoryName) {
		String subCategory = String.format(pageProps.getString("flipkart.home.page.drawer.subcategory.option"),
				subCategoryName);
		QAFExtendedWebElement subCategoryOption = new QAFExtendedWebElement(subCategory);
		return subCategoryOption;
	}

	public QAFWebElement getSortOptionInput(String sortOptionName) {
		String sortOptionInput = String.format(pageProps.getString("flipkart.search.results.page.sort.option.input"),
				sortOptionName);
		QAFExtendedWebElement sortOptionInputByName = new QAFExtendedWebElement(sortOptionInput);
		return sortOptionInputByName;
	}

	public QAFWebElement getFilterOption(String filterOptionName) {
		String filterOption = String.format(pageProps.getString("flipkart.search.results.page.filter.option"),
				filterOptionName);
		QAFExtendedWebElement filterOptionByName = new QAFExtendedWebElement(filterOption);
		return filterOptionByName;
	}

	public void verifyItemIsSortedByPrice() {
		List<String> itemPrice = new ArrayList<String>();
		for (QAFWebElement webElement : getSearchResultItemPrice()) {
			if (webElement.getText() != null && webElement.getText().length() != 0) {
				itemPrice.add(webElement.getText());
			}
		}
		List<String> priceSorted = new ArrayList<String>(itemPrice);
		Collections.sort(priceSorted);
		Validator.verifyThat("item is sorted by price", priceSorted, Matchers.equalTo(itemPrice));
	}
}
