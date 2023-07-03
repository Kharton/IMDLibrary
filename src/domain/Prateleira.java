package domain;

import java.util.List;

public class Prateleira<T> implements GrupoPublicacao<T> {
		
	private List<T> arquivos;
	
	private String localizacao;

	public Prateleira(List<T> arquivos, String localizacao) {
		this.arquivos = arquivos;
		this.localizacao = localizacao;
	}

	public List<T> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<T> arquivos) {
		this.arquivos = arquivos;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}