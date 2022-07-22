package br.mg.karlorms.pages;

import org.openqa.selenium.By;

import br.mg.karlorms.core.BasePage;

public class MenuPage extends BasePage{
	
	public void acessarTelaAdicionarConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaAdicionarMovimentacao() {
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo() {
		clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaHome() {
		clicarLink("Home");
	}
	
	public String obterMensagemAlert() {
		return obterTexto(By.xpath("//*[@id='tabelaSaldo']/thead/tr/th[1]"));
	}


}
