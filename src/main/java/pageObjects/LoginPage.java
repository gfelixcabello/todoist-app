package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// This is an alternative as an xpath that wouldn't require the button text
	// 'Iniciar sesión' : By.xpath"(//a[@href='/auth/login'])[2]"
	By linkName = By.partialLinkText("Iniciar sesión");
	By emailTxtBox = By.id("labeled-input-1");
	By passwordTxtBox = By.id("labeled-input-3");
	By loginBtn = By.cssSelector("button[type='submit']");

	public void clickOnSignIn() {

		driver.findElement(linkName).click();

	}

	public void typeEmail(String email) {

		driver.findElement(emailTxtBox).sendKeys(email);
	}

	public void typePassword(String passWord) {

		driver.findElement(passwordTxtBox).sendKeys(passWord);
	}

	public void login() {

		driver.findElement(loginBtn).click();
	}

}
