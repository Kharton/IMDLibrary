package domain;

import java.util.Calendar;
import java.util.Date;

import exceptions.EmprestimoExpiradoException;

public class Emprestimo {
	
	private Publicacao publicacao;
	
	private Usuario usuario;
	
	private Date dataEmprestimo;
	
	private Date dataExpiracao;
	
	private Funcionario funcionarioResponsavel;

	private boolean finalizado;
	
	public Emprestimo() {
		
	}
	
	public Publicacao devolverPublicacao() throws EmprestimoExpiradoException {
		if((new Date()).after(dataExpiracao)){
			throw new EmprestimoExpiradoException("Regularize o emprestimo antes de realizar a devolucao");
		}
		finalizado = true;
		return publicacao;

	}
	
	public void renovarPublicacao() throws EmprestimoExpiradoException {
		Calendar c = Calendar.getInstance();
		c.setTime(dataExpiracao);
	    c.add(Calendar.DATE, 30);
	    dataExpiracao = c.getTime();
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publiacacao) {
		this.publicacao = publiacacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataExpiracao);
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		this.dataExpiracao = calendar.getTime();
	}
	
	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
}