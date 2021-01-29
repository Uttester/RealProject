package com.r09.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.AbtractPage;

public class Level_03_Page_Object extends AbtractPage {
	WebDriver driver;
	WebElement element;
	String email = "Nguyenut" + randomNumber() + "@gmail.com";
	String lastName = "Nguyen";
	String firstName = "Ut" + randomNumber();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		openPageUrl(driver, "https://staff.newpas-dev.cf/login");
		setImplicitWait(driver, 3);

	}

	@BeforeMethod
	public void beforeMethord() {

	}

	@Test
	public void Login_System() {
//		sendkeyToElement(driver, "//input[@id='email']", "R09admin@scuti.asia");
//		sendkeyToElement(driver, "//input[@id='password']", "123645");
//		clickToElement(driver, "//button[@id='btn-login']");
//		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='help-block']")).getText(), "Emailアドレスかパスワードが正しくありません。");
		sendkeyToElement(driver, "//input[@id='email']", "R09admin@scuti.asia");
		sendkeyToElement(driver, "//input[@id='password']", "secret");
		clickToElement(driver, "//button[@id='btn-login']");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='R09 Staff - Admin']")).isDisplayed());
		clickToElement(driver, "//span[text()='パートナー管理']");
		clickToElement(driver, "//a[@href='https://staff.newpas-dev.cf/partners/create']");
		selectItemInDropdown(driver, "//select[@id='select_registration_type']", "個人パートナー");
		sendkeyToElement(driver, "//input[@name='email']", email);
		clickToElement(driver, "//a[contains(text(),'プロフィール')]");
		sendkeyToElement(driver, "//input[@name='last_name']", lastName);
		sendkeyToElement(driver, "//input[@name='first_name']", firstName);
		sendkeyToElement(driver, "//input[@name='last_name_kana']", "グエン");
		sendkeyToElement(driver, "//input[@name='first_name_kana']", "ウット");
		selectItemInDropdown(driver, "//select[@name='gender_id']", "女");
		sendkeyToElement(driver, "//input[@name='date_of_birth']", "1991-02-11");
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='avatar_upload']"));
		String fileUpload = "D:\\Auto test\\02-Selenium-API\\uploadFile\\2mb.jpg";
		fileInput.sendKeys(fileUpload);
		// sendkeyToElement(driver, "//input[@id='avatar_upload']", fileUpload);
		String filePdf = "D:\\Auto test\\02-Selenium-API\\uploadFile\\201210_グエン　テイ　ウット御中_3月請求書.pdf";
		sendkeyToElement(driver, "//input[@name='first_resume_file']", filePdf);
		sendkeyToElement(driver, "//input[@name='emergency_email']", email);
		sendkeyToElement(driver, "//input[@name='phone_number']", "0988587623");
		sendkeyToElement(driver, "//input[@name='phone_number_home']", "0224535682");
		sendkeyToElement(driver, "//input[@name='postal_code']", "1" + randomNumber());
		scrollToElement(driver, "//span[@id='select2-prefecture_id-container']");
		selectItemInCustomDropdown(driver, "//span[@id='select2-prefecture_id-container']", "//ul[@id='select2-prefecture_id-results']/li", "福岡県");
		sendkeyToElement(driver, "//input[@name='street_address']", "Thai Binh 県　－　An Thanh 区");
		sendkeyToElement(driver, "//input[@name='nearest_station']", "Cau Nghin");
		sendkeyToElement(driver, "//input[@name='destination_zip_code']", "1" + randomNumber());
		sendkeyToElement(driver, "//input[@name='delivery_address']", "Thai Nguyen 県");
		sendkeyToElement(driver, "//input[@name='destination_name']", "An Thai 区");
		scrollToElement(driver, "//a[contains(text(),'社内管理情報')]");
		clickToElement(driver, "//a[contains(text(),'社内管理情報')]");
		selectItemInCustomDropdown(driver, "//span[@title='--R09担当者--']", "//ul[@class='select2-results__options']/li", "Oleta Becker IV");
		selectItemInCustomDropdown(driver, "//span[@title='--応募経路--']", "//ul[@class='select2-results__options']/li", "パートナー紹介");
		selectItemInCustomDropdown(driver, "//span[@title='面談者']", "//ul[@class='select2-results__options']/li", "R09 Staff - Admin");
		sendkeyToElement(driver, "//input[@name='interview_date']", "2021-01-20");
		selectItemInDropdown(driver, "//select[@id='cv_passed_id']", "合格");
		selectItemInDropdown(driver, "//select[@id='interview_passed_id']", "合格");
		if (!isElementEnable(driver, "//a[text()='パートナーfee']")) {
			clickToElement(driver, "//a[text()='パートナーfee']");
			scrollToBottomPage(driver);
		}

		selectItemInCustomDropdown(driver, "//span[@title='--カード送付時差出人--']", "//ul[@class='select2-results__options']/li", "R09 Staff - Admin");
		selectItemInDropdown(driver, "//select[@id='billing_and_contract_type_id']", "法人");
		if (!isElementDisplay(driver, "//input[@name='percentage_tax']")) {
			selectItemInDropdown(driver, "//select[@id='billing_and_contract_type_id']", "海外");
			if (isElementDisplay(driver, "//input[@name='percentage_tax']")) {
				sendkeyToElement(driver, "//input[@name='percentage_tax']", "20");
			}

		}
		checkToCheckbox(driver, "//input[@id='home_only']//following-sibling::ins");
		if (!isElementDisplay(driver, "//input[@id='not_subject_to_the_mail']")) {
			checkToCheckbox(driver, "//input[@id='not_subject_to_the_mail']//following-sibling::ins");
			if (isElementDisplay(driver, "//input[@name='reason_not_get_consultation']")) {
				sendkeyToElement(driver, "//input[@name='reason_not_get_consultation']", "Khong dung mail real");
			}
		}
		selectItemInDropdown(driver, "//select[@name='number_submission_id']", "未対応");
		checkToCheckbox(driver, "//input[@value='3' and @name ='search_targets[]']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@value='4' and @name ='search_targets[]']//following-sibling::ins");
		scrollToElement(driver, "//a[contains(text(),'ログイン情報')]");
		clickToElement(driver, "//a[contains(text(),'キャリア')]");
		scrollToElement(driver, "//select[@name='education_type_id']");
		selectItemInDropdown(driver, "//select[@name='education_type_id']", "大学院卒");
		sendkeyToElement(driver, "//input[@name='school_name']", "ĐH Thai Nguyen");
		sendkeyToElement(driver, "//input[@name='undergraduate_major']", "CNPM");
		sendkeyToElement(driver, "//textarea[@name='education_introduce']", "cham chi\nngoan ngoan\nle phep\nkha nang chiu ap luc cong viec");
		sendkeyToElement(driver, "//textarea[@name='self_pr']", "co trach nhiem voi cong viec\nhao dong\nvui ve\nkha nang lam viec nhom tot");
		clickToElement(driver, "//a[contains(text(),'スキル')]");
		checkToCheckbox(driver, "//input[@value='3' and @name ='qualifications[]']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@value='2' and @name ='qualifications[]']//following-sibling::ins");
		sendkeyToElement(driver, "//input[@name='number_toeic']", "450");
		sendkeyToElement(driver, "//textarea[@name='other_qualifications']", "ISTQB\nNhat Ngu N3");
		selectItemInDropdown(driver, "//select[@name='eng_skill_id']", "ビジネス会話レベル等");
		sendkeyToElement(driver, "//input[@name='note_pc']", "Lenovo 320");
		sendkeyToElement(driver, "//input[@name='ex_connect_terminal']", "HDMI");
		checkToCheckbox(driver, "//input[@id='dvd_drive']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='wifi']//following-sibling::ins");
		clickToElement(driver, "//a[contains(text(),'経験')]");
		checkToCheckbox(driver, "//input[@text-data='サービス']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@text-data='ソフトウエア、通信']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@text-data='広告、出版、マスコミ']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='new_group_discussion']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='new_personal_interview']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='new_school_around']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='mid_briefing_presentation']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='mid_agent_control']//following-sibling::ins");
		checkToCheckbox(driver, "//input[@id='mid_seminar']//following-sibling::ins");
		clickToElement(driver, "//a[contains(text(),'銀行情報')]");
		selectItemInDropdown(driver, "//select[@name='bank_type_id']", "普通");
		sendkeyToElement(driver, "//input[@name='bank_name']", "TPbank");
		sendkeyToElement(driver, "//input[@name='branch_name']", "Ha Noi");
		sendkeyToElement(driver, "//input[@name='account_number']", randomNumber() + "3");
		sendkeyToElement(driver, "//input[@name='account_holder']", "グエン ウット");
		clickToElement(driver, "//button[@class='btn btn-primary']");
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'未契約パートナー')]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//tr[1]/td[1]/a[1]")).getText(), lastName + " " + firstName);
		clickToElement(driver, "//a[@class='btn btn-primary btn-sm']");
		getElementAttribute(driver, "//input[@name='email']", "value");

	}

}
