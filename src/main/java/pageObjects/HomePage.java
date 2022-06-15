package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	By profileBtn = By.xpath("//button/div/img");
	By userEmail = By.cssSelector(".user_menu_email");
	By imgProfile = By.xpath("//button/div/img");

	public void clickOnProfile() {
		driver.findElement(profileBtn).click();
	}

	public String getEmailLoggedIn() {

		this.clickOnProfile();
		String displayedEmail = driver.findElement(userEmail).getText();
		return displayedEmail;
	}

}
