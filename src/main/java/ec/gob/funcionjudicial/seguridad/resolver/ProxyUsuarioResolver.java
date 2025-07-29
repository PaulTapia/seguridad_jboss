/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;
import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;

/**
 * Proxy que resuelve el userPrincipal, si no lo tiene en el mapa de sesion lo obtiene
 * mediante una implementeacion real y lo coloca en el mapa de sesion
 * 
 * @author Fausto De La Torre
 *
 */
public class ProxyUsuarioResolver implements UsuarioResolver {
	
	private RealUsuarioResolver realUsuarioResolver = new RealUsuarioResolver();
	
	private static final String USUARIO_SESION_KEY = "_usuario_sesion_";

	public IUsuarioFuncionJudicial obtenerUsuarioLogeado(HttpServletRequest request, MetodoAutenticacion metodoAutenticacion) {
		IUsuarioFuncionJudicial usuario = null;
		HttpSession session = request.getSession(false);
		if(session != null){
			usuario = (IUsuarioFuncionJudicial) session.getAttribute(USUARIO_SESION_KEY);
			if(usuario == null){
				usuario = realUsuarioResolver.obtenerUsuarioLogeado(request, metodoAutenticacion);
				session.setAttribute(USUARIO_SESION_KEY, usuario);
			}
		}
		
		
		return usuario;
	}

	public IUsuarioFuncionJudicial obtenerUsuarioLogeado(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		IUsuarioFuncionJudicial usuario = null;
		if(session != null){
			usuario = (IUsuarioFuncionJudicial) session.getAttribute(USUARIO_SESION_KEY);
		}
		return usuario;
	}

}
