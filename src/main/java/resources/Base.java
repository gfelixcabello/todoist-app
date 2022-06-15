package resources;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	WebDriver driver;

	public WebDriver initializeDriver() {

		System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Added 3 seconds delay for the page to completely load for the profile button to work correctly. Just as a quick solution. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;

	}

	public String getProperty(String propertyName) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/resources/config.properties");
		prop.load(fis);
		return prop.get(propertyName).toString();

	}

	public String getDataFromJson(String property) throws IOException, ParseException {
		FileReader reader = new FileReader("src/main/java/resources/testData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject element = (JSONObject) obj;

		return element.get(property).toString();

	}

}
