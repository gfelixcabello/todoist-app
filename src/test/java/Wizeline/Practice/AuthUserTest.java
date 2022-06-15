package Wizeline.Practice;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class AuthUserTest extends Base {

	WebDriver driver;
	LoginPage login;
	HomePage home;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		//Fixed the getProperty from the properties file, I was adding the url with ""
		driver.get(getProperty("url"));
	}

	@Test
	public void validateUserLogin() throws IOException, ParseException {

		login = new LoginPage(driver);
		login.clickOnSignIn();
		home = new HomePage(driver);

		// Pending: Refactor to only call one method.
		login.typeEmail(getDataFromJson("email"));
		login.typePassword(getDataFromJson("password"));
		login.login();

		//Assert that the email that is displayed in the profile is the same as the one used to sign in . 
		Assert.assertEquals(home.getEmailLoggedIn(), getDataFromJson("email"));

	}
	
	//Added the driver.close as a tearDown method
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
