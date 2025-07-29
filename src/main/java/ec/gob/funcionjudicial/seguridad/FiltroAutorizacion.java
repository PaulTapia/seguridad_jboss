/**
 * 
 */
package ec.gob.funcionjudicial.seguridad;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.filtros.factory.FiltroAutorizacionFactory;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltro;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroAutorizacion extends FiltroFuncionJudicial {
	@Override
	protected Filter getFiltro(MetodoAutenticacion metodoAutenticacion) {
		return FiltroAutorizacionFactory.getFiltroAutorizacion();
	}

	@Override
	protected InicializadorFiltro getInitFiltroParametros(FilterConfig filterConfig) {
		return null;
	}
}
