package br.mg.karlorms.pages;

import static br.mg.karlorms.core.DriverFactory.getDriver;

import br.mg.karlorms.core.BasePage;

public class LoginPage extends BasePage{
	
	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void login() {
		ClicarBotaoPorTexto("Entrar");
	}
	
	public void reset() {
		//clicarBotao(By.xpath("/html/body/footer/span/a"));
		clicarLink("reset");
	}

}
