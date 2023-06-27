package domain;

import java.util.List;

public class Publicacao{
	
	private String nome;
	
	private int edicao;
	
	private int ano;

	private List<Pessoa> autores;
	
	private String texto;
	
	private int paginas;
	
	private boolean alugada;
	
	public Publicacao(String nome, int edicao, int ano, List<Pessoa> autores, String texto, int paginas) {
		super();
		this.nome = nome;
		this.edicao = edicao;
		this.ano = ano;
		this.autores = autores;
		this.texto = texto;
		this.paginas = paginas;
		this.alugada = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Pessoa> getAutores() {
		return autores;
	}

	public void setAutores(List<Pessoa> autores) {
		this.autores = autores;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isAlugada() {
		return alugada;
	}

	public void setAlugada(boolean alugada) {
		this.alugada = alugada;
	}	
}