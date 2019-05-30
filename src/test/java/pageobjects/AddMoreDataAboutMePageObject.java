package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddMoreDataAboutMePageObject {

	private WebDriver driver;
	
    public AddMoreDataAboutMePageObject(WebDriver driver) {
    	this.driver = driver;
    }

	public Select typeSelect() {
		Select tipoContato = new Select(driver.findElement(By.id("addmoredata")).findElement(By.name("type")));
        return tipoContato;
	}
	
	public WebElement contactTextfield() {
		return this.driver.findElement(By.id("addmoredata")).findElement(By.name("contact"));
	}
	
	public WebElement saveButton() {
		return this.driver.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE"));
	}
	
    public WebElement mensagemToast() {
        return this.driver.findElement(By.id("toast-container"));
     }
    
}
