package run;

import java.util.ArrayList;
import java.util.List;

import domain.Funcionario;
import domain.Library;
import domain.Usuario;

public class IMDLibrary {
	public static void main(String[] arg) {
		System.out.println("Livraria IMD.");
		var biblioteca = new Library();
		var funcionarioMestre = new Funcionario("mestre", "123", "123", 21, "Gerente", "0001");
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(funcionarioMestre);
		biblioteca.setFuncionarios(funcionarios);
		
		var usuario = new Usuario("aluno", "001", "001", 18, "aluno", new ArrayList<>());
		funcionarioMestre.cadastrarUsuario(usuario, biblioteca.getUsuarios());
		
		funcionarioMestre.cadastrarPublicacao(null, biblioteca.getPublicacoes());
	}
}
