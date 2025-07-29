/**
 * 
 */
package ec.gob.funcionjudicial.seguridad;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.filtros.factory.FiltroValidacionFactory;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltro;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltroValidacion;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroValidacion extends FiltroFuncionJudicial {

	@Override
	protected Filter getFiltro(MetodoAutenticacion metodoAutenticacion) {
		return FiltroValidacionFactory.getFiltroValidacion(metodoAutenticacion);
	}

	@Override
	protected InicializadorFiltro getInitFiltroParametros(FilterConfig filterConfig) {
		return new InicializadorFiltroValidacion(filterConfig);
	}
}
