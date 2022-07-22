package br.mg.karlorms.pages;

import org.openqa.selenium.By;

import br.mg.karlorms.core.BasePage;

public class ResumoPage extends BasePage {
	
	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}

}
