package verificationpoints;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.tools.Report;
import framework.tools.ScreenShot;
import tasks.AddMoreDataAboutMeTask;

public class AddMoreDataAboutMeVerificationPoint {
	private WebDriver driver;
	private AddMoreDataAboutMeTask addMoreDataAboutMeTaskInstance;

	public AddMoreDataAboutMeVerificationPoint(WebDriver driver) {
		this.addMoreDataAboutMeTaskInstance = new AddMoreDataAboutMeTask(driver);
		this.driver = driver;
	}

	public void validarMensagemDeAdicaoDaInformacao() {
		if ("Your contact has been added!"
				.equalsIgnoreCase(this.addMoreDataAboutMeTaskInstance.capturarMensagemFinal())) {
			Report.log(Status.PASS, "Informa��o adicionada com sucesso", ScreenShot.capture(this.driver));
		} else {
			Report.log(Status.FAIL, "Erro na adi��o da informa��o", ScreenShot.capture(this.driver));
		}
	}

	public void validarMensagemDeRemocaoDaInformacao() {
		if ("Rest in peace, dear email!"
				.equalsIgnoreCase(this.addMoreDataAboutMeTaskInstance.capturarMensagemFinal())) {
			Report.log(Status.PASS, "E-mail removido com sucesso", ScreenShot.capture(this.driver));
		} else if ("Rest in peace, dear phone!"
				.equalsIgnoreCase(this.addMoreDataAboutMeTaskInstance.capturarMensagemFinal())) {
			Report.log(Status.PASS, "Phone removido com sucesso", ScreenShot.capture(this.driver));
		} else {
			Report.log(Status.FAIL, "Erro na remo��o da informa��o", ScreenShot.capture(this.driver));
		}
	}
}
