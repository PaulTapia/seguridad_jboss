/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.init;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.FilterConfig;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;

/**
 * @author fausto
 *
 */
public abstract class InicializadorFiltro {

	private FilterConfig filterConfig;

	public InicializadorFiltro(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}
	
	private void setInitParametro(String nombre, String valor){
		filterConfig.getServletContext().setInitParameter(nombre, valor);
	}
	
	
	public void inicializar(MetodoAutenticacion metodoAutenticacion){
		Map<String, String> parametrosIniciales = getParametrosIniciales(metodoAutenticacion);
		for (Entry<String, String> p : parametrosIniciales.entrySet()) {
			setInitParametro(p.getKey(), p.getValue());
		}
	}
	
	protected abstract Map<String, String> getParametrosIniciales(MetodoAutenticacion metodoAutenticacion);
}
