/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.factory;

import javax.servlet.Filter;

import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroEnvolturaFactory {
	public static Filter getFiltroEnvoltura(MetodoAutenticacion metodo){
		switch (metodo) {
		case CAS:
			return new HttpServletRequestWrapperFilter();
		default:
			throw new IllegalArgumentException("No hay un filtro para el metodo de autenticacion " + metodo);
		}
	}
}
