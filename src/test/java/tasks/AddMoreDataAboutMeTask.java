package tasks;

import org.openqa.selenium.WebDriver;

import framework.tools.Report;
import pageobjects.AddMoreDataAboutMePageObject;

public class AddMoreDataAboutMeTask {

	private AddMoreDataAboutMePageObject addMoreDataAboutMeInstance;

	public AddMoreDataAboutMeTask(WebDriver driver) {
		this.addMoreDataAboutMeInstance = new AddMoreDataAboutMePageObject(driver);
	}

	public void selecionarTipoEContato(String tipo, String contato) {
		this.addMoreDataAboutMeInstance.typeSelect().selectByVisibleText(tipo);
		this.addMoreDataAboutMeInstance.contactTextfield().sendKeys(contato);
		this.addMoreDataAboutMeInstance.saveButton().click();
	}
	
	public String capturarContato() {
		String contato = this.addMoreDataAboutMeInstance.contactTextfield().getText();
		return contato;
	}
	
	public String capturarMensagemFinal() {
		String mensagem = this.addMoreDataAboutMeInstance.mensagemToast().getText();
		return mensagem;
	}
	
}
