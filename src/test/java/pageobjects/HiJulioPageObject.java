package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HiJulioPageObject {

	private WebDriver driver;

	public HiJulioPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement moreDataAboutYouLink() {
		return this.driver.findElement(By.linkText("MORE DATA ABOUT YOU"));
	}

	public WebElement addMoreDataButton() {
		return this.driver.findElement(By.xpath("//div[@id='moredata']/div/button[@data-target='addmoredata']"));
	}
	
	public WebElement lixeiraIcon(String info) {
		return this.driver.findElement(By.xpath("//span[text()='"+ info +"']/following-sibling::a"));
	}

}
