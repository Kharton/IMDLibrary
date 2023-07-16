package domain;

import java.util.ArrayList;
import java.util.List;

import exceptions.LimiteAlugueisException;
import exceptions.MenorIdadeException;

public class Usuario extends Pessoa{
	
	private String login;
	
	private List<Publicacao> alugueis;
	
	private int limiteAlugueis;

	public Usuario(Pessoa pessoa, String login, List<Publicacao> alugueis) {
		super(null,null,null,0);
		if(pessoa != null) {
			setNome(pessoa.getNome());
			setRG(pessoa.getRG());
			setCPF(pessoa.getCPF());
			setIdade(pessoa.getIdade());
		}
		this.login = login;
		this.alugueis = alugueis;
		this.limiteAlugueis = 0;
	}

	public Usuario(String nome, String RG, String CPF, int idade, String login, List<Publicacao> alugueis) {
		super(nome, RG, CPF, idade);
		this.login = login;
		this.alugueis = alugueis;
		this.limiteAlugueis = 0;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Publicacao> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Publicacao> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void alugarPublicacao(Publicacao publicacao) throws LimiteAlugueisException, MenorIdadeException {
		if(this.alugueis == null)
			this.alugueis = new ArrayList<>();
		verificaCondicoesAluguel();
		alugueis.add(publicacao);
	}

	private void verificaCondicoesAluguel() throws LimiteAlugueisException, MenorIdadeException {
		if(alugueis != null && limiteAlugueis < alugueis.size()) {
			throw new LimiteAlugueisException("O usuario ja alugou o numero máximo de publicacoes.");
		}
		if(getIdade() < 18) {
			throw new MenorIdadeException("Apenas maiores de idade podem alugar publicacoes.");
		}
	}
        
        
        public void clone(Usuario user){
            this.alugueis = user.getAlugueis();
            this.login = user.getLogin();
            setNome(user.getNome());
            setRG(user.getRG());
            setCPF(user.getCPF());
            setIdade(user.getIdade());
        }

	@Override
	public String toString() {
		return getNome() + " (" + getCPF() + ")";
	}
}