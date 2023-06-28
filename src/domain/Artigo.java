package domain;

import java.util.List;

public class Artigo extends Publicacao{
	public String resumo;
	
	public String conclusao;

	public Artigo(String nome, int edicao, int ano, List<Pessoa> autores, String texto, int paginas, 
			String resumo, String conclusao) {
		super(nome, edicao, ano, autores, texto, paginas);
		this.resumo = resumo;
		this.conclusao = conclusao;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
}