package domain;

import java.util.ArrayList;
import java.util.List;

import exceptions.LimiteAlugueisException;
import exceptions.MenorIdadeException;

public class Funcionario extends Pessoa{
	
	private String funcao;
	
	private String matricula;
	
	public Funcionario(String nome, String RG, String CPF, int idade, String funcao, String matricula) {
		super(nome, RG, CPF, idade);
		this.funcao = funcao;
		this.matricula = matricula;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void cadastrarPublicacao(Publicacao publi, List<Publicacao> lista) {
		if(publi != null) {
			if(lista == null)
				lista = new ArrayList<>();
			lista.add(publi);
		}
	}
	
	public void registrarUsuario(Usuario usuario, List<Usuario> lista) {
		if(usuario != null) {
			if(lista == null)
				lista = new ArrayList<>();
			lista.add(usuario);
		}
	}
	
	public void alugarPublicacaoUsuario(Publicacao publicacao, Usuario usuario) throws LimiteAlugueisException, MenorIdadeException {
		if(usuario != null && publicacao != null) {
			usuario.alugarPublicacao(publicacao);
		}
	}
}