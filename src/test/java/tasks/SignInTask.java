package tasks;

import org.openqa.selenium.WebDriver;

import pageobjects.SignInPageObject;

public class SignInTask {
	
	private SignInPageObject signInTaskInstance;

	public SignInTask(WebDriver driver) {
		this.signInTaskInstance = new SignInPageObject(driver);
	}

	public void fazerLogin(String login, String password) {
		this.signInTaskInstance.loginTextfield().sendKeys(login);
		this.signInTaskInstance.passwordTextfield().sendKeys(password);
		this.signInTaskInstance.signInLink().click();
	}
}
