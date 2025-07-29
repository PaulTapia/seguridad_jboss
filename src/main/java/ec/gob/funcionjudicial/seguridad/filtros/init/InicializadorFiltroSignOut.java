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
public class InicializadorFiltroSignOut extends InicializadorFiltro {

	public InicializadorFiltroSignOut(FilterConfig filterConfig) {
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
		parametros.put("artifactParameterName", Utils.getInstance().getPropiedad("cas.signout.artifactParameterName"));
	}

}
