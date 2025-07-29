/**
 * 
 */
package ec.gob.funcionjudicial.seguridad;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.filtros.factory.FiltroSignOutFactory;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltro;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltroSignOut;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroSignOut extends FiltroFuncionJudicial {

	@Override
	protected Filter getFiltro(MetodoAutenticacion metodoAutenticacion) {
		return FiltroSignOutFactory.getFiltroSignOut(metodoAutenticacion);
	}

	@Override
	protected InicializadorFiltro getInitFiltroParametros(FilterConfig filterConfig) {
		return new InicializadorFiltroSignOut(filterConfig);
	}
}
