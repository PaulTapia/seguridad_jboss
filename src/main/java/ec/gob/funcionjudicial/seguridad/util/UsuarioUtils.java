/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.util;

import javax.servlet.http.HttpServletRequest;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;
import ec.gob.funcionjudicial.seguridad.exception.UsuarioNoResueltoException;
import ec.gob.funcionjudicial.seguridad.resolver.UsuarioResolverFactory;


/**
 * @author Fausto De La Torre
 *
 */
public class UsuarioUtils {

	private static UsuarioUtils instance;
	
	private UsuarioUtils(){
		
	}
	
	public static UsuarioUtils getInstance(){
		if(instance == null){
			instance = new UsuarioUtils();
		}
		return instance;
	}
	
	/**
	 * Obtiene el usuario logeado mediante el request
	 * 
	 * @param request
	 * @return Usuario Logeado
	 * @throws UsuarioNoResueltoException si no se puede resolver el usuario mediante el request
	 */
	public IUsuarioFuncionJudicial getUsuarioFuncionJudicial(HttpServletRequest request) throws UsuarioNoResueltoException{
		return UsuarioResolverFactory.getResolver().obtenerUsuarioLogeado(request);
	}
}
