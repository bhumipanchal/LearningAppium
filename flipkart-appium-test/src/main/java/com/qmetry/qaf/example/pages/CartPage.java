package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CartPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "flipkart.cart.page.save.for.later.icon")
	private QAFWebElement cartPageSaveForLaterIcon;
	@FindBy(locator = "flipkart.cart.page.empty.text")
	private QAFWebElement cartIsEmptyMessage;
	@FindBy(locator = "flipkart.cart.page.continue.button")
	private QAFWebElement cartPageContinueButton;
	@FindBy(locator = "flipkart.cart.login.page.email.input")
	private QAFWebElement cartLoginPageEmailInput;
	@FindBy(locator = "flipkart.cart.login.page.password.input")
	private QAFWebElement cartLoginPagePasswordInput;
	@FindBy(locator = "flipkart.cart.login.page.signin.button")
	private QAFWebElement cartLoginPageSignInButton;
	@FindBy(locator = "flipkart.cart.page.dialog.remove.icon")
	private QAFWebElement cartPageDialogRemoveButton;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public QAFWebElement getCartPageDialogRemoveButton() {
		return cartPageDialogRemoveButton;
	}

	public QAFWebElement getCartLoginPageEmailInput() {
		return cartLoginPageEmailInput;
	}

	public QAFWebElement getCartLoginPagePasswordInput() {
		return cartLoginPagePasswordInput;
	}

	public QAFWebElement getCartLoginPageSignInButton() {
		return cartLoginPageSignInButton;
	}

	public QAFWebElement getCartPageContinueButton() {
		return cartPageContinueButton;
	}

	public QAFWebElement getCartIsEmptyMessage() {
		return cartIsEmptyMessage;
	}

	public QAFWebElement getCartPageSaveForLaterIcon() {
		return cartPageSaveForLaterIcon;
	}

	public QAFWebElement getCartPageItemTitle(String itemName) {
		String cartItemTitle = String.format(pageProps.getString("flipkart.cart.page.item.title"), itemName);
		QAFExtendedWebElement cartItemTitleEle = new QAFExtendedWebElement(cartItemTitle);
		return cartItemTitleEle;
	}
}
