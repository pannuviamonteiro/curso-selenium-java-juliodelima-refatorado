package tasks;

import org.openqa.selenium.WebDriver;

import pageobjects.HiJulioPageObject;

public class HiJulioTask {
   
	private HiJulioPageObject hiJulioInstance;

	public HiJulioTask(WebDriver driver) {
		this.hiJulioInstance = new HiJulioPageObject(driver);
	}
	
	public void clicarLinkMoreDataAboutYou() {
		this.hiJulioInstance.moreDataAboutYouLink().click();
	}
	
	public void clicarBotaoAddData() {
		this.hiJulioInstance.addMoreDataButton().click();
	}
		
	public void clicarIconeLixeira(String info) {
		this.hiJulioInstance.lixeiraIcon(info).click();
	}
	
}
