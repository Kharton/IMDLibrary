package run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Funcionario;
import domain.Usuario;
import domain.Library;
import domain.Livro;
import domain.Emprestimo;


public class IMDLibrary {
	public static void main(String[] arg) {
		System.out.println("Livraria IMD.");

		var biblioteca = new Library();
		
		var funcionarioMestre = new Funcionario("mestre", "123", "123", 21, "Gerente", "0001");
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(funcionarioMestre);
		biblioteca.setFuncionarios(funcionarios);
		
		var usuario = new Usuario("professor", "001", "001", 25, "professor", new ArrayList<>());
		var usuario2 = new Usuario("aluno", "001", "001", 18, "aluno", new ArrayList<>());
		funcionarioMestre.cadastrarUsuario(usuario, biblioteca.getUsuarios());

		Livro livro1 = new Livro("Livro 1", 1, 2023, new ArrayList<>(), "Texto", 220, "Editora", "123", "Sinopse");
		funcionarioMestre.cadastrarPublicacao(livro1, biblioteca.getPublicacoes());

		// Exemplo de empréstimos e devolução de livro
		biblioteca.imprimeListaPublicacoes();
		biblioteca.emprestarPublicacao(funcionarioMestre, usuario, livro1);
		biblioteca.emprestarPublicacao(funcionarioMestre, usuario2, livro1);
		biblioteca.devolverPublicacao(usuario, livro1);
		biblioteca.emprestarPublicacao(funcionarioMestre, usuario2, livro1);
	}
}
