/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.resolver;

import javax.servlet.http.HttpServletRequest;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;
import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.exception.UsuarioNoResueltoException;

/**
 * Interfaz que expone los metodos necesarios para resolver un usuario a partir de un request
 * 
 * @author Fausto De La Torre
 *
 */
public interface UsuarioResolver {

	/**
	 * Obtiene el userPrincipal 
	 * 
	 * @param request
	 * @param metodoAutenticacion
	 * @return Usuario Funcion Judicial
	 * @throws UsuarioNoResueltoException
	 */
	IUsuarioFuncionJudicial obtenerUsuarioLogeado(HttpServletRequest request, MetodoAutenticacion metodoAutenticacion) throws UsuarioNoResueltoException;
	
	/**
	 * Obtiene el usuario que esta en sesion
	 * 
	 * @param request
	 * @return Usuario Funcion Judicial
	 * @throws UsuarioNoResueltoException si no se ha registrado previamente el usuario en la sesion
	 */
	IUsuarioFuncionJudicial obtenerUsuarioLogeado(HttpServletRequest request) throws UsuarioNoResueltoException;
}
