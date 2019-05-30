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
import tasks.AddMoreDataAboutMeTask;
import tasks.HiJulioTask;
import tasks.HomeTask;
import tasks.SignInTask;
import tasks.TaskitTask;
import verificationpoints.AddMoreDataAboutMeVerificationPoint;
import verificationpoints.TaskitVerificationPoint;

public class AdicionarInformacoesDoUsuarioTest {

	private String FILE_PATH_CONTATOS = System.getProperty("user.dir") + File.separator + "datapools" + File.separator + "contatos.csv";
	private CsvDatapool datapoolContatos;
	
	private String FILE_PATH_LOGIN = System.getProperty("user.dir") + File.separator + "datapools" + File.separator + "login.csv";
	private CsvDatapool datapoolLogin;
	
	private WebDriver driver;
	private HomeTask homeTaskInstance;
	private SignInTask signInTaskInstance;
	private HiJulioTask hiJulioTaskInstance;
	private TaskitTask taskitTaskInstance;
	private AddMoreDataAboutMeTask addMoreDataAboutMeTaskInstance;
	private TaskitVerificationPoint taskitVerificationPointInstance;
	private AddMoreDataAboutMeVerificationPoint addMoreDataAboutMeVerificationPointInstance;

	@Before
	public void setUp() {
		
		Report.create("Curso Selenium WebDriver com Java", "Adicionar informação do usuário");
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.get("http://www.juliodelima.com.br/taskit");
		this.driver.manage().window().maximize();
		
		this.homeTaskInstance = new HomeTask(driver);
		this.signInTaskInstance = new SignInTask(driver);
		this.taskitTaskInstance = new TaskitTask(driver);
		this.taskitVerificationPointInstance = new TaskitVerificationPoint(driver);
		this.hiJulioTaskInstance = new HiJulioTask(driver);
		this.addMoreDataAboutMeTaskInstance = new AddMoreDataAboutMeTask(driver);
		this.addMoreDataAboutMeVerificationPointInstance = new AddMoreDataAboutMeVerificationPoint(driver);
		
		this.datapoolContatos = new CsvDatapool(FILE_PATH_CONTATOS);
		this.datapoolLogin = new CsvDatapool(FILE_PATH_LOGIN);
	}

	@Test
	public void testAdicionarInformacaoDoUsuario() {
		
		Report.startTest("Adicionar informação do usuário");
				
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
			this.hiJulioTaskInstance.clicarBotaoAddData();
			this.addMoreDataAboutMeTaskInstance.selecionarTipoEContato(this.datapoolContatos.getValue("tipo"), this.datapoolContatos.getValue("dado"));
			this.addMoreDataAboutMeVerificationPointInstance.validarMensagemDeAdicaoDaInformacao();
			this.datapoolContatos.next();
		}
		
		System.out.println("INFORMAÇÃO ADICIONADA");
	}

	@After
	public void tearDown() {
		if (this.driver != null) {
			this.driver.quit();
		}
		
		Report.close();
	}
}
