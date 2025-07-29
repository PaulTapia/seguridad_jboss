/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.factory;

import javax.servlet.Filter;

import org.jasig.cas.client.authentication.Saml11AuthenticationFilter;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroAutenticacionFactory {

	public static Filter getFiltroAutenticacion(MetodoAutenticacion metodo){
		switch (metodo) {
		case CAS:
			return new Saml11AuthenticationFilter();
		default:
			throw new IllegalArgumentException("No hay un filtro para el metodo de autenticacion " + metodo);
		}
	}
}
