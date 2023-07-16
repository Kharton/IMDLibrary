package domain;

import java.util.List;

public class Livro extends Publicacao{
	private String editora;
	
	private String isbn;
	
	private String sinopse;

	public Livro(String nome, int edicao, int ano, List<Pessoa> autores, String texto, int paginas, String editora,
			String isbn, String sinopse) {
		super(nome, edicao, ano, autores, texto, paginas);
		this.editora = editora;
		this.isbn = isbn;
		this.sinopse = sinopse;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void clone(Livro obj) {
            super.clone(obj);
            this.editora = obj.getEditora();
            this.isbn = obj.getISBN();
            this.sinopse = obj.getSinopse();
	}
	
	@Override
	public String toString() {
            return getNome() +", "+ getEdicao()+"ª ed ("+getEditora()+"-" + getAno()
                            + ")" + (isAlugada()?"✕":"✓") ;
	}
}