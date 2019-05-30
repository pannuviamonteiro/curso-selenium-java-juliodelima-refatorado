package testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.datapools.CsvDatapool;
import framework.tools.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.HiJulioTask;
import tasks.HomeTask;
import tasks.SignInTask;
import tasks.TaskitTask;
import verificationpoints.AddMoreDataAboutMeVerificationPoint;
import verificationpoints.TaskitVerificationPoint;

public class RemoverInformacoesDoUsuarioTest {

	private String FILE_PATH_CONTATOS = System.getProperty("user.dir") + File.separator + "datapools" + File.separator + "contatos.csv";
	private CsvDatapool datapoolContatos;
	
	private String FILE_PATH_LOGIN = System.getProperty("user.dir") + File.separator + "datapools" + File.separator + "login.csv";
	private CsvDatapool datapoolLogin;
	
	private WebDriver driver;
	private HomeTask homeTaskInstance;
	private SignInTask signInTaskInstance;
	private TaskitTask taskitTaskInstance;
	private HiJulioTask hiJulioTaskInstance;
	private AddMoreDataAboutMeVerificationPoint addMoreDataAboutMeVerificationPointInstance;
	private TaskitVerificationPoint taskitVerificationPointInstance;
	
	@Before
	public void setUp() {
		
		Report.create("Curso Selenium WebDriver com Java", "Remover informação do usuário");
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.get("http://www.juliodelima.com.br/taskit");
		this.driver.manage().window().maximize();

		this.homeTaskInstance = new HomeTask(driver);
		this.signInTaskInstance = new SignInTask(driver);
		this.taskitTaskInstance = new TaskitTask(driver);
		this.hiJulioTaskInstance = new HiJulioTask(driver);
		this.addMoreDataAboutMeVerificationPointInstance = new AddMoreDataAboutMeVerificationPoint(driver);
		this.taskitVerificationPointInstance = new TaskitVerificationPoint(driver);
		
		this.datapoolContatos = new CsvDatapool(FILE_PATH_CONTATOS);
		this.datapoolLogin = new CsvDatapool(FILE_PATH_LOGIN);
	}

	@Test
	public void testRemoverInformacaoDoUsuario() {
		
		Report.startTest("Remover informação do usuário");
		
		this.homeTaskInstance.clicarLinkSignIn();
		
		this.datapoolLogin.reset();
		while(this.datapoolLogin.hasNext()) {
			this.signInTaskInstance.fazerLogin(this.datapoolLogin.getValue("login"), this.datapoolLogin.getValue("senha"));
			this.datapoolLogin.next();
		}
		
		this.taskitVerificationPointInstance.validarLogin();
		this.taskitTaskInstance.clicarLinkHiJulio();
		this.hiJulioTaskInstance.clicarLinkMoreDataAboutYou();

		this.datapoolContatos.reset();
		while(this.datapoolContatos.hasNext()) {
			this.hiJulioTaskInstance.clicarIconeLixeira(this.datapoolContatos.getValue("dado"));
			this.datapoolContatos.next();
		}
		
		this.driver.switchTo().alert().accept();
		this.addMoreDataAboutMeVerificationPointInstance.validarMensagemDeRemocaoDaInformacao();

		System.out.println("INFORMAÇÃO REMOVIDA");
	}

	@After
	public void tearDown() {
		if (this.driver != null) {
			this.driver.quit();
		}
			Report.close();
	}
}
