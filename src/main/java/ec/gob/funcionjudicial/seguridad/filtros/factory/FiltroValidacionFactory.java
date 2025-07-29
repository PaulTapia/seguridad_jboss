/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.factory;

import javax.servlet.Filter;

import org.jasig.cas.client.validation.Saml11TicketValidationFilter;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroValidacionFactory {
	public static Filter getFiltroValidacion(MetodoAutenticacion metodo){
		switch (metodo) {
		case CAS:
			return new Saml11TicketValidationFilter();
		default:
			throw new IllegalArgumentException("No hay un filtro para el metodo de autenticacion " + metodo);
		}
	}
}
