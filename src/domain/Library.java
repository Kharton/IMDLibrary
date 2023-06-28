package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import exceptions.EmprestimoExpiradoException;

public class Library{

	private List<Usuario> usuarios;
	
	private List<Publicacao> publicacoes;
	
	private List<Funcionario> funcionarios;
	
	private List<Sessao<Livro>> sessoesLivros;
	
	private List<Sessao<Artigo>> sessoesAtigos;
	
	private Map<Usuario, List<Emprestimo>> mapEmprestimosUsuario;
	
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

	public List<Sessao<Artigo>> getSessoesAtigos() {
		return sessoesAtigos;
	}

	public void setSessoesAtigos(List<Sessao<Artigo>> sessoesAtigos) {
		this.sessoesAtigos = sessoesAtigos;
	}

	public Map<Usuario, List<Emprestimo>> getMapEmprestimosUsuario() {
		return mapEmprestimosUsuario;
	}

	public void setMapEmprestimosUsuario(Map<Usuario, List<Emprestimo>> mapEmprestimosUsuario) {
		this.mapEmprestimosUsuario = mapEmprestimosUsuario;
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
	
	public void emprestarPublicacao(Funcionario funcionario, Usuario usuario, Publicacao publicacao) {
		if(publicacoes.contains(publicacao)) {
			var emprestimo = new Emprestimo();
			emprestimo.setDataEmprestimo(new Date());
			emprestimo.setFuncionarioResponsavel(funcionario);
			emprestimo.setPublicacao(publicacao);
			emprestimo.setUsuario(usuario);
			if(mapEmprestimosUsuario.get(usuario) == null) {
				mapEmprestimosUsuario.put(usuario, new ArrayList<>());
			}
			mapEmprestimosUsuario.get(usuario).add(emprestimo);
			publicacao.setAlugada(true);
		}else {
			System.out.println("Esta publicação não esta no acervo da biblioteca.");
		}
	}
	
	public void devolverPublicacao(Usuario usuario, Publicacao publicacao) {
		var emprestimos = mapEmprestimosUsuario.get(usuario);
		if(emprestimos == null || emprestimos.isEmpty()) {
			return;
		}
		for(var emprestimo : emprestimos) {
			if(emprestimo.getPublicacao().equals(publicacao)) {
				try {
					publicacoes.add(emprestimo.devolverPublicacao());
					publicacao.setAlugada(false);
				}catch(EmprestimoExpiradoException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		
	}
	
	public void renovarPublicacao(Funcionario funcionario, Usuario usuario, Publicacao publicacao) {
		var emprestimos = mapEmprestimosUsuario.get(usuario);
		if(emprestimos == null || emprestimos.isEmpty()) {
			return;
		}
		
		for(var emprestimo : emprestimos) {
			if(emprestimo.getPublicacao().equals(publicacao)) {
				try {
					emprestimo.renovarPublicacao();
				}catch(EmprestimoExpiradoException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}
}