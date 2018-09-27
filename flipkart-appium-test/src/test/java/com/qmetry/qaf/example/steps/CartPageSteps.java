package com.qmetry.qaf.example.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.example.pages.CartPage;
import com.qmetry.qaf.example.pages.HomePage;

public class CartPageSteps {
	@QAFTestStep(description = "verify item {0} is added on cart page")
	public static void verifyItemAddedOnCartPage(String itemName) {
		CartPage cartPage = new CartPage();
		HomePage homePage = new HomePage();
		homePage.getButtonByText("My Cart").waitForVisible();
		Validator.verifyTrue(cartPage.getCartPageItemTitle(itemName).isDisplayed(), "item is not added to the cart",
				"item is successfully added to the cart");
	}

	@QAFTestStep(description = "user click save for later on cart page")
	public static void removeItemFromCart() {
		CartPage cartPage = new CartPage();
		cartPage.getCartPageSaveForLaterIcon().click();
	}

	@QAFTestStep(description = "verify item {0} is displayed on saved for later section")
	public static void verifyEmptyCartDisplayed(String itemName) {
		CartPage cartPage = new CartPage();
		Validator.verifyTrue(cartPage.getCartPageItemTitle(itemName).isDisplayed(),
				"item is not displayed on saved for later section", "item is displayed on saved for later section");
	}

	@QAFTestStep(description = "user click on continue button")
	public static void clickOnContinueButton() {
		CartPage cartPage = new CartPage();
		cartPage.getCartPageContinueButton().waitForVisible();
		cartPage.getCartPageContinueButton().click();
	}

	@QAFTestStep(description = "verify login screen is displayed")
	public static void verifyCartLoginScreen() {
		CartPage cartPage = new CartPage();
		Validator.verifyTrue(cartPage.getCartLoginPageEmailInput().isDisplayed(),
				"login email text box is not displayed", "login email text box is displayed");
		Validator.verifyTrue(cartPage.getCartLoginPagePasswordInput().isDisplayed(),
				"login password text box is not displayed", "login password text box is displayed");
		Validator.verifyTrue(cartPage.getCartLoginPageSignInButton().isDisplayed(),
				"login sign in button is not displayed", "login sign in button is displayed");
	}
}
