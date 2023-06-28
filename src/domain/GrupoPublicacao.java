package domain;

import java.util.List;

public interface GrupoPublicacao<T> {

	String getLocalizacao();
	
	void setLocalizacao(String localizacao);

	List<T> getArquivos();

	void setArquivos(List<T> arquivos);
}
