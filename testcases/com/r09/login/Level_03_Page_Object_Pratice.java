package com.r09.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.AbtractPage;
import pageObjects.r09.DashboardPageObject;
import pageObjects.r09.LoginPageObject;
import pageObjects.r09.ManagementUnitPageObject;

public class Level_03_Page_Object_Pratice extends AbtractPage {
	WebDriver driver;
	WebElement element;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ManagementUnitPageObject managementPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		openPageUrl(driver, "https://staff.newpas-dev.cf/login");
		setImplicitWait(driver, 3);
		loginPage = new LoginPageObject(driver);

	}

	@BeforeMethod
	public void beforeMethord() {

	}

	@Test
	public void Login_System() {
		loginPage.inputToLoginEmailTextBox();
		loginPage.inputToPasswordTextBox();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Emailアドレスかパスワードが正しくありません。");

	}

}
