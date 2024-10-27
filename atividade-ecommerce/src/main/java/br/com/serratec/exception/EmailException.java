package br.com.serratec.exception;

//o extends RuntimeException, diferente do extends Exception
//não precisa tratar o exception em tempo de projeto
public class EmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//source>generateconstructobysuperclass:
	public EmailException(String message) {
		super(message);
	}
	
}
