package com.qmetry.qaf.example.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductDetailPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "flipkart.pdp.page.wishlist.icon")
	private QAFWebElement pdpWishlistIcon;
	@FindBy(locator = "flipkart.pdp.page.add.to.cart.button")
	private QAFWebElement pdpAddToCartButton;
	@FindBy(locator = "flipkart.pdp.page.buy.now.button")
	private QAFWebElement pdpBuyNowButton;
	@FindBy(locator = "flipkart.pdp.page.product.image")
	private QAFWebElement pdpProductImage;
	@FindBy(locator = "flipkart.pdp.page.product.price")
	private QAFWebElement pdpProductPrice;
	@FindBy(locator = "flipkart.pdp.page.back.button")
	private QAFWebElement pdpPageBackButton;
	@FindBy(locator = "flipkart.search.results.page.wishlist.icon")
	private QAFWebElement searchResultsPageWishlistIcon;
	@FindBy(locator = "flipkart.pdp.page.dialog.add.to.cart.button")
	private QAFWebElement pdpDialogAddToCartButton;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public QAFWebElement getPdpDialogAddToCartButton() {
		return pdpDialogAddToCartButton;
	}

	public QAFWebElement getSearchResultsPageWishlistIcon() {
		return searchResultsPageWishlistIcon;
	}

	public QAFWebElement getPdpPageBackButton() {
		return pdpPageBackButton;
	}

	public QAFWebElement getPdpProductImage() {
		return pdpProductImage;
	}

	public QAFWebElement getPdpProductPrice() {
		return pdpProductPrice;
	}

	public QAFWebElement getPdpWishlistIcon() {
		return pdpWishlistIcon;
	}

	public QAFWebElement getPdpAddToCartButton() {
		return pdpAddToCartButton;
	}

	public QAFWebElement getPdpProductDetailsIcon() {
		return pdpBuyNowButton;
	}

	public WebElement getPdpShareButton() throws MalformedURLException, InterruptedException {
		WebElement element = DriverUtils.getAndroidDriver()
				.findElementByAndroidUIAutomator(pageProps.getString("flipkart.pdp.page.share.button"));
		return element;
	}

}
