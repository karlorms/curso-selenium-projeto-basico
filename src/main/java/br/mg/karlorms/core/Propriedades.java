package br.mg.karlorms.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
	public enum Browsers {
		CHROME,
		FIREFOX,
		EDGE
	}
	
	public enum TipoExecucao {
		LOCAL,
		GRID,
		NUVEN
	}

}
