/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.resolver;

import javax.servlet.http.HttpServletRequest;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;

/**
 * @author Fausto De La Torre
 *
 */
interface UsuarioResolverStrategy {

	IUsuarioFuncionJudicial getUsuario(HttpServletRequest request);
}
