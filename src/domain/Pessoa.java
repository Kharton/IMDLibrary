package domain;

public class Pessoa {
	
	private String nome;
	
	private String RG;
	
	private String CPF;
	
	private int idade;
	
	public Pessoa(String nome, String RG, String CPF, int idade) {
		this.nome = nome;
		this.RG = RG;
		this.CPF = CPF;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return nome + "(" + CPF + ")";
	}
}