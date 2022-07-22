package br.mg.karlorms.core;

import static br.mg.karlorms.core.DriverFactory.getDriver;
import static br.mg.karlorms.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.mg.karlorms.pages.LoginPage;


public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void testeLogin() {
		page.acessarTelaInicial();
		page.setEmail("karlorms@gmail.com");
		page.setSenha("karlorms");
		page.login();
	}

	@After
	public void finaliza() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("C:\\Workspace\\ws-eclipse\\CursoSelenium\\target\\screenshot\\" + testName.getMethodName() + ".jpg"));

		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
