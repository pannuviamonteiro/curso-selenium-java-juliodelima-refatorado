package testsuites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testcases.AdicionarInformacoesDoUsuarioTest;
import testcases.RemoverInformacoesDoUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	AdicionarInformacoesDoUsuarioTest.class, 
	RemoverInformacoesDoUsuarioTest.class 
})
public class RegressionTestSuite {

	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando execução do teste de regressão do site TaskIt");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando teste de regressão do site TaskIt");
	}

}
