package com.qmetry.qaf.example.steps;

import java.net.MalformedURLException;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.example.pages.HomePage;
import com.qmetry.qaf.example.pages.ProductDetailPage;

public class ProductDetailPageSteps {
	@QAFTestStep(description = "verify user is on PDP page")
	public static void verifyUserIsOnPDPPage() {
		HomePage homePage = new HomePage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		Validator.verifyTrue(productDetailPage.getPdpWishlistIcon().isDisplayed(), "PDP wishlist icon is not displayed",
				"PDP wishlist icon is displayed");
		Validator.verifyTrue(homePage.getButtonByText("ADD TO CART").isDisplayed(),
				"add to cart button is not displayed", "add to cart button is displayed");
		Validator.verifyTrue(homePage.getButtonByText("BUY NOW").isDisplayed(), "buy now button is not displayed",
				"buy now button is displayed");
	}

	@QAFTestStep(description = "verify item attributes on PDP page")
	public static void verifyItemAttributesOnPDPPage() throws MalformedURLException, InterruptedException {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		HomePage homePage = new HomePage();
		Validator.verifyTrue(productDetailPage.getPdpProductImage().isDisplayed(), "PDP product image is not displayed",
				"PDP product image is displayed");
		Validator.verifyTrue(productDetailPage.getPdpProductDetailsIcon().isDisplayed(),
				"product details icon is not displayed", "product details icon is displayed");
		Validator.verifyTrue(productDetailPage.getPdpProductPrice().isDisplayed(), "product price is not displayed",
				"product price is displayed");
		Validator.verifyTrue(productDetailPage.getPdpShareButton().isDisplayed(), "share button is not displayed",
				"share button is displayed");
		try {
			Validator.verifyTrue(homePage.getButtonByText("Add to Compare").isDisplayed(),
					"add to compare button is not displayed", "add to compare button is displayed");
		} catch (Exception e) {
			Validator.verifyTrue(homePage.getButtonByText("Go to Compare").isDisplayed(),
					"add to compare button is not displayed", "add to compare button is displayed");
		}

	}

	@QAFTestStep(description = "user click on wishlist icon")
	public static void clickOnWishlistIcon() {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.getPdpWishlistIcon().click();
	}

	@QAFTestStep(description = "user navigate to wishlist page")
	public static void navigateToWishlistPage() throws MalformedURLException, InterruptedException {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		HomePage homePage = new HomePage();
		homePage.scrollBackwardByCoordinates();
		productDetailPage.getPdpPageBackButton().click();
		homePage.getButtonByText("Sort").waitForVisible();
		homePage.scrollBackwardByCoordinates();
		productDetailPage.getSearchResultsPageWishlistIcon().click();
	}

	@QAFTestStep(description = "verify item {0} is added to wishlist page")
	public static void verifyItemAddedToWishlist(String itemName) {
		HomePage homePage = new HomePage();
		Validator.verifyTrue(homePage.getButtonByText("Wishlist (1)").isDisplayed(), "wishlist page is not displayed",
				"wishlist page is displayed");
		Validator.verifyThat("item is added to the wishlist", homePage.getWishlistPageItemTitle().getText(),
				Matchers.containsString(itemName));
	}

	@QAFTestStep(description = "user add item to the cart")
	public static void userAddItemToCart() {
		HomePage homePage = new HomePage();
		homePage.getButtonByText("ADD TO CART").click();
		if (homePage.getButtonByText("ADD TO CART").isPresent()) {
			homePage.getButtonByText("ADD TO CART").click();
		}
		ProductDetailPage productDetailPage = new ProductDetailPage();
		if (productDetailPage.getPdpDialogAddToCartButton().isPresent()) {
			productDetailPage.getPdpDialogAddToCartButton().click();
		} else if (homePage.getButtonByText("GO TO CART").isPresent()) {
			homePage.getButtonByText("GO TO CART").click();
		}
	}
}
