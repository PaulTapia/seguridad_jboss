/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.exception;

/**
 * @author Fausto De La Torre
 *
 */
public class UsuarioNoResueltoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNoResueltoException() {
		super();
	}

	public UsuarioNoResueltoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioNoResueltoException(String message) {
		super(message);
	}

	public UsuarioNoResueltoException(Throwable cause) {
		super(cause);
	}

}
