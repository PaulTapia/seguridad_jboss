/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.resolver;

import javax.servlet.http.HttpServletRequest;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;
import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.exception.UsuarioNoResueltoException;

/**
 * Resuelve el Usuario Funcion Judicial de acuerdo a una estrategia definida mediante un metodo de autenticacion
 * 
 * @author Fausto De La Torre
 *
 */
public class RealUsuarioResolver implements UsuarioResolver {
	public IUsuarioFuncionJudicial obtenerUsuarioLogeado(HttpServletRequest request, MetodoAutenticacion metodoAutenticacion) {
		return getStrategy(metodoAutenticacion).getUsuario(request);
	}

	private UsuarioResolverStrategy getStrategy(MetodoAutenticacion metodoAutenticacion){
		switch (metodoAutenticacion) {
		case CAS:
			return new UsuarioResolverStrategyPrincipalCAS();
		}
		throw new IllegalArgumentException("No existe una estrategia para resolver el usuario logeado con el metodo de autenticacion" + metodoAutenticacion);
	}
	
	public IUsuarioFuncionJudicial obtenerUsuarioLogeado(HttpServletRequest request)
			throws UsuarioNoResueltoException {
		throw new UsuarioNoResueltoException("Imposible obtener usuario sin metodo de autenticacion desde RealUsuarioResolver");
	}

}
