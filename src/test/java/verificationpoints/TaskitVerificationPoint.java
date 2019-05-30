package verificationpoints;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.tools.Report;
import framework.tools.ScreenShot;
import pageobjects.TaskitPageObject;

public class TaskitVerificationPoint {
	private WebDriver driver;
	private TaskitPageObject taskitPageObjectInstance;

	public TaskitVerificationPoint(WebDriver driver) {
		this.taskitPageObjectInstance = new TaskitPageObject(driver);
		this.driver = driver;
	}

	public void validarLogin() {
		if (this.taskitPageObjectInstance.hiJulioLink().isDisplayed()) {
			Report.log(Status.PASS, "Login realizado com sucesso", ScreenShot.capture(this.driver));
		} else {
			Report.log(Status.FAIL, "Login não realizado", ScreenShot.capture(this.driver));
		}
	}

}
