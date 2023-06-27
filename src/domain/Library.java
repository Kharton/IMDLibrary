package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library{

	private List<Usuario> usuarios;
	
	private List<Publicacao> publicacoes;
	
	private List<Funcionario> funcionarios;
	
	private List<Sessao<Livro>> sessoesLivros;
	
	public Library() {
		usuarios = new ArrayList<>();
		publicacoes = new ArrayList<>();
		funcionarios = new ArrayList<>();
		sessoesLivros = new ArrayList<>();
	}

	public Library(List<Funcionario> funcionarios, List<Usuario> usuario, List<Publicacao> publicacoes) {
		this.funcionarios = funcionarios;
		this.usuarios = usuario;
		this.publicacoes = publicacoes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
	public List<Sessao<Livro>> getSessoesLivros() {
		return sessoesLivros;
	}

	public void setSessoesLivros(List<Sessao<Livro>> sessoesLivros) {
		this.sessoesLivros = sessoesLivros;
	}

	public Funcionario logAs(String matricula) {
		return buscaFuncionario(matricula);
	}
	
	private Funcionario buscaFuncionario(String matricula) {
		if(getFuncionarios() != null) {
			for(var func : getFuncionarios()) {
				if(Objects.equals(matricula,func.getMatricula())){
					return func;
				}
			}
		}
		return null;
	}
	
	public List<Publicacao> listaPublicacoesLivres() {
		var livres = new ArrayList<Publicacao>();
		//getPublicacoes().stream().filter(publi -> !publi.isAlugada()).toList();
		for(var publi : getPublicacoes()) {
			if(!publi.isAlugada()) {
				livres.add(publi);
			}
		}
		return livres;
	}
	
	public void imprimeListaPublicacoes() {
		for(var publi : listaPublicacoesLivres()) {
			System.out.printf("%s - %sª edição (%d) \n", publi.getNome(),publi.getEdicao(),publi.getAno());
		}
	}
}