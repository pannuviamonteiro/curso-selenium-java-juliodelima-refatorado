package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPageObject {

	private WebDriver driver;
	
	public SignInPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement loginTextfield() {
		return this.driver.findElement(By.id("signinbox")).findElement(By.name("login"));
	}
	
    public WebElement passwordTextfield() {
        return this.driver.findElement(By.id("signinbox")).findElement(By.name("password"));
     }
    
    public WebElement signInLink(){
        return this.driver.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN"));
    }
    
}

