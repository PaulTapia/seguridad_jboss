/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros.factory;

import javax.servlet.Filter;

import ec.gob.funcionjudicial.seguridad.filtros.FiltroAutorizacionFuncionJudicial;

/**
 * @author Fausto De La Torre
 *
 */
public class FiltroAutorizacionFactory {
	public static Filter getFiltroAutorizacion(){
		return new FiltroAutorizacionFuncionJudicial();
	}
}
