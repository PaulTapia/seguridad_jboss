/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.factory;

import javax.servlet.Filter;

import org.jasig.cas.client.session.SingleSignOutFilter;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroSignOutFactory {
	public static Filter getFiltroSignOut(MetodoAutenticacion metodo){
		switch (metodo) {
		case CAS:
			return new SingleSignOutFilter();
		default:
			throw new IllegalArgumentException("No hay un filtro para el metodo de autenticacion " + metodo);
		}
	}
}
