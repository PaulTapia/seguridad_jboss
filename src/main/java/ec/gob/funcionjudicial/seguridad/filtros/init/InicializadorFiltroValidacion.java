/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.init;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterConfig;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.util.Utils;

/**
 * @author fausto
 *
 */
public class InicializadorFiltroValidacion extends InicializadorFiltro {

	public InicializadorFiltroValidacion(FilterConfig filterConfig) {
		super(filterConfig);
	}


	@Override
	protected Map<String, String> getParametrosIniciales(MetodoAutenticacion metodoAutenticacion) {
		Map<String, String> parametros = new HashMap<String, String>();
		switch (metodoAutenticacion) {
		case CAS:
			setParametrosCAS(parametros);
			break;
		}
		return parametros;
	}
	
	private void setParametrosCAS(Map<String, String> parametros){
		parametros.put("serverName", Utils.getInstance().getPropiedad("host"));
		parametros.put("casServerUrlPrefix", Utils.getInstance().getPropiedad("cas.validacion.casServerUrlPrefix"));
		parametros.put("redirectAfterValidation", Utils.getInstance().getPropiedad("cas.validacion.redirectAfterValidation"));
		parametros.put("tolerance", Utils.getInstance().getPropiedad("cas.validacion.tolerance"));
	}

}
