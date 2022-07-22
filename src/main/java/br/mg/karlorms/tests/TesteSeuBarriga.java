package br.mg.karlorms.tests;

import static br.mg.karlorms.core.DriverFactory.getDriver;
import static utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.mg.karlorms.core.BasePage;
import br.mg.karlorms.core.BaseTest;
import br.mg.karlorms.core.DriverFactory;
import br.mg.karlorms.pages.ContasPage;
import br.mg.karlorms.pages.HomePage;
import br.mg.karlorms.pages.MenuPage;
import br.mg.karlorms.pages.MovimentacaoPage;
import br.mg.karlorms.pages.ResumoPage;
import utils.DataUtils;

public class TesteSeuBarriga extends BaseTest {

	BasePage page;

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	MovimentacaoPage mp = new MovimentacaoPage();
	ResumoPage rp = new ResumoPage();
	HomePage hp = new HomePage();

	@Test
	public void adicionarConta() {
		menuPage.acessarTelaAdicionarConta();

		contasPage.setNome("Conta Teste");
		contasPage.salvar();

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemAlert());
	}

	@Test
	public void alterarConta() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarAlterarConta("Conta para alterar");

		contasPage.setNome("Conta alterada");
		contasPage.salvar();

		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemAlert());

	}

	@Test
	public void adiconarContaComMesmoNome() {
		menuPage.acessarTelaAdicionarConta();

		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();

		Assert.assertEquals("J� existe uma conta com esse nome!", contasPage.obterMensagemAlert());
	}

	@Test
	public void criarMovimentacao() {
		menuPage.acessarTelaAdicionarMovimentacao();

		mp.setDataMovimentacao(obterDataFormatada(new Date()));
		mp.setDataPagamento(obterDataFormatada(new Date()));
		mp.setDescricao("Pagamento teste");
		mp.setInteressado("Interessado teste");
		mp.setValor("300.00");
		mp.setConta("Conta para movimentacoes");
		mp.setSituacao();
		mp.salvar();

		Assert.assertEquals("Movimenta��o adicionada com sucesso!", mp.obterMensagemAlert());
	}

	@Test
	public void camposObrigatoriosDaMovimentacao() {
		menuPage.acessarTelaAdicionarMovimentacao();

		mp.salvar();

		List<String> erros = mp.obterMensagensDeErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio", "Descri��o � obrigat�rio", "Interessado � obrigat�rio",
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());

		/*
		 * Assert.assertEquals("Data da Movimenta��o � obrigat�rio",
		 * mp.obterMensagemDataMovimentacao());
		 * Assert.assertEquals("Data do pagamento � obrigat�rio",
		 * mp.obterMensagemDataPagamento());
		 * Assert.assertEquals("Descri��o � obrigat�rio", mp.obterMensagemDescricao());
		 * Assert.assertEquals("Interessado � obrigat�rio",
		 * mp.obterMensagemInteressado()); Assert.assertEquals("Valor � obrigat�rio",
		 * mp.obterMensagemValor()); Assert.assertEquals("Valor deve ser um n�mero",
		 * mp.obterMensagemValorNumerico());
		 */

	}

	@Test
	public void movimentacaoFutura() {
		menuPage.acessarTelaAdicionarMovimentacao();

		Date dataFutura = DataUtils.obterDataFutura(5);

		mp.setDataMovimentacao(obterDataFormatada(dataFutura));
		mp.setDataPagamento(obterDataFormatada(dataFutura));
		mp.setDescricao("Pagamento teste");
		mp.setInteressado("Interessado teste");
		mp.setValor("300.00");
		mp.setConta("Conta para movimentacoes");
		mp.setSituacao();
		mp.salvar();

		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", mp.obterMensagemAlert());
	}

	@Test
	public void removerMovimentacao() {
		menuPage.acessarTelaResumo();

		rp.excluirMovimentacao();

		Assert.assertEquals("Movimenta��o removida com sucesso!", mp.obterMensagemAlert());

		/*
		 * testeLogin(); page.clicarBotao(By.xpath("//*[@id='navbar']/ul/li[4]/a"));
		 * page.selecionarCombo("mes", "Janeiro");
		 * page.clicarBotao(By.xpath("//input[@value='Buscar']"));
		 * page.clicarBotao(By.xpath("//*[@id='tabelaExtrato']/tbody/tr/td[6]/a/span"));
		 * Assert.assertEquals("Movimenta��o removida com sucesso!",
		 * page.obterTexto(By.xpath("/html/body/div[@role='alert']")));
		 */
	}

	@Test
	public void removerContaComMovimentacao() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarRemoverConta("Conta com movimentacao");

		Assert.assertEquals("Conta em uso na movimenta��es", contasPage.obterMensagemAlert());

		/*
		 * testeLogin(); page.clicarBotao(By.xpath("//*[@id='navbar']/ul/li[2]/a"));
		 * page.clicarBotao(By.xpath("//*[@id='navbar']/ul/li[2]/ul/li[2]/a"));
		 * page.clicarBotao(By.xpath("//*[@id='tabelaContas']/tbody/tr/td[2]/a[2]/span")
		 * ); Assert.assertEquals("Conta em uso na movimenta��es",
		 * page.obterTexto(By.xpath("/html/body/div[@role='alert']")));
		 */
	}

	@Test
	public void testeSaldoContas() {
		menuPage.acessarTelaHome();

		Assert.assertEquals("534.00", hp.obterSaldoConta("Conta para saldo"));

		/*
		 * testeLogin(); page.clicarBotao(By.xpath("//*[@id='navbar']/ul/li[1]/a"));
		 * Assert.assertEquals("Conta",
		 * page.obterTexto(By.xpath("//*[@id='tabelaSaldo']/thead/tr/th[1]")));
		 */
	}

	@Test
	public void resumoMensal() {
		menuPage.acessarTelaResumo();

		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		rp.selecionarAno("2016");
		rp.buscar();

		List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());

		
	}

}
