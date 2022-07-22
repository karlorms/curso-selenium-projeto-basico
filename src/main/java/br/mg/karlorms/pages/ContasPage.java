package br.mg.karlorms.pages;

import org.openqa.selenium.By;

import br.mg.karlorms.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar() {
		ClicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemAlert() {
		return obterTexto(By.xpath("/html/body/div[@role='alert']"));
	}
	
	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clicarRemoverConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}

}
