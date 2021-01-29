package pageObjects.r09;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUI.R09.LoginPageUI;

public class LoginPageObject extends AbtractPage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToLoginEmailTextBox() {
		sendkeyToElement(driver, LoginPageUI.LOGIN_EMAIL_TEXTBOX, "R09admin@scuti.asia");
		
	}

	public void inputToPasswordTextBox() {
		sendkeyToElement(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX, "1234");
		
	}

	public void clickToLoginButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrorMessageAtEmailTextBox() {
		waitElementVisibale(driver, LoginPageUI.LOGIN_INFOR_INCORRECTMESSAGE);
		return getElementText(driver, LoginPageUI.LOGIN_INFOR_INCORRECTMESSAGE);
	}


}
