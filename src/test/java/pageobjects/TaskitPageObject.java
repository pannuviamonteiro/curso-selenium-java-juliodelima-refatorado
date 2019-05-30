package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskitPageObject {

	private WebDriver driver;

	public TaskitPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement hiJulioLink() {
		return this.driver.findElement(By.className("me"));
	}

}
