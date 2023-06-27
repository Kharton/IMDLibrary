package domain;

import java.util.List;

public class Sessao<T> {
		
	private List<T> arquivos;
	
	private String localizacao;

	public Sessao(List<T> arquivos, String localizacao) {
		super();
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