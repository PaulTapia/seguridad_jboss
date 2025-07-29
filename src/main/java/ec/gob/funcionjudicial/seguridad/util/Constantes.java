/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.util;


/**
 * @author Fausto De La Torre
 *
 */
public class Constantes {
	public static final String CONTEXTO_PORTAL = "portalApp";
	public static final String NOMBRE_APLICACION_KEY="nombreApp";
	public static final String METODO_AUTENTICACION_KEY="metodoAut";
	public static final String URL_SIN_AUTORIZACION_KEY="urlSinAutorizacion";
	public static final String URL_ERROR_KEY="urlError";
	public static final String URL_SIN_AUTORIZACION_DEFAULT = CONTEXTO_PORTAL + "/error/noAutorizado.jsf";
	public static final String URL_ERROR_DEFAULT = CONTEXTO_PORTAL + "/error/error.jsf";

}
