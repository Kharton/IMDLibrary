package exceptions;

public class EmprestimoExpiradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmprestimoExpiradoException(String mensagem) {
		super(mensagem);
	}
}
