package tasks;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePageObject;


public class HomeTask {
	
	private HomePageObject homeInstance;

	public HomeTask(WebDriver driver) {
		this.homeInstance = new HomePageObject(driver);
	}

	public void clicarLinkSignIn() {
		this.homeInstance.signInLink().click();
	}

}
