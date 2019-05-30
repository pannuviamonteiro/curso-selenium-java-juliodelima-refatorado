package tasks;

import org.openqa.selenium.WebDriver;

import framework.tools.Report;
import framework.tools.ScreenShot;
import pageobjects.TaskitPageObject;

public class TaskitTask {

	private WebDriver driver;
	private TaskitPageObject taskItInstance;

	public TaskitTask(WebDriver driver) {
		this.taskItInstance = new TaskitPageObject(driver);
		this.driver = driver;
	}

	public void clicarLinkHiJulio() {
		this.taskItInstance.hiJulioLink().click();
	}

}
