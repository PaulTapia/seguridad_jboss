/**
 * 
 */
package ec.gob.funcionjudicial.seguridad;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.filtros.factory.FiltroAutenticacionFactory;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltro;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltroAutenticacion;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroAutenticacion extends FiltroFuncionJudicial {

	@Override
	protected Filter getFiltro(MetodoAutenticacion metodoAutenticacion) {
		return FiltroAutenticacionFactory.getFiltroAutenticacion(metodoAutenticacion);
	}

	@Override
	protected InicializadorFiltro getInitFiltroParametros(FilterConfig filterConfig) {
		return new InicializadorFiltroAutenticacion(filterConfig);
	}
}
