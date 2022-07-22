package br.mg.karlorms.suites;

import static br.mg.karlorms.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.karlorms.core.BaseTest;
import br.mg.karlorms.pages.LoginPage;
import br.mg.karlorms.tests.TesteSeuBarriga;

@RunWith(Suite.class)
@SuiteClasses({ TesteSeuBarriga.class })
public class SuiteGeral extends BaseTest {
	private static LoginPage login = new LoginPage();

	@BeforeClass
	public static void reset() {
		login.acessarTelaInicial();

		login.setEmail("karlorms@gmail.com");
		login.setSenha("karlorms");
		login.login();

		login.reset();

		//killDriver();
	}
	
	@AfterClass
	public static void finalizar() {
		killDriver();
	}
}
