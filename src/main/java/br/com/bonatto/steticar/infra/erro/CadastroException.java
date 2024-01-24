package br.com.bonatto.steticar.infra.erro;

public class CadastroException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

	public CadastroException(String message)
	{
		super(message);
	}

}
