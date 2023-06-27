package exceptions;

public class LimiteAlugueisException extends Exception {

	private static final long serialVersionUID = 1L;

	public LimiteAlugueisException(String mensagem) {
		super(mensagem);
	}
}
