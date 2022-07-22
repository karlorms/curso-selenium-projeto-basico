package br.mg.karlorms.pages;

import static br.mg.karlorms.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.mg.karlorms.core.BasePage;

public class MovimentacaoPage extends BasePage{
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setSituacao() {
		clicarRadio("status_pago");
	}
	
	public void salvar() {
		ClicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemAlert() {
		return obterTexto(By.xpath("/html/body/div[@role='alert']"));
	}
	
	public String obterMensagemDataMovimentacao() {
		return obterTexto(By.xpath("/html/body/div[1]/ul/li[1]"));
	}
	
	public String obterMensagemDataPagamento() {
		return obterTexto(By.xpath("/html/body/div[1]/ul/li[2]"));
	}
	
	public String obterMensagemDescricao() {
		return obterTexto(By.xpath("/html/body/div[1]/ul/li[3]"));
	}
	
	public String obterMensagemInteressado() {
		return obterTexto(By.xpath("/html/body/div[1]/ul/li[4]"));
	}
	
	public String obterMensagemValor() {
		return obterTexto(By.xpath("/html/body/div[1]/ul/li[5]"));
	}
	
	public String obterMensagemValorNumerico() {
		return obterTexto(By.xpath("/html/body/div[1]/ul/li[6]"));
	}
	
	public List<String> obterMensagensDeErros() {
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}

}
