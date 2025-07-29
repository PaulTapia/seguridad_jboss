/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Singleton de utilitarios
 * 
 * @author Fausto De La Torre
 *
 */
public class Utils {

	private static final String URL_SEGURIDAD_PROPIEDADES = "/seguridad.properties";
	private static final Logger log = Logger.getLogger(Utils.class);
	private static Utils instance;
	private Properties seguridadPropiedades;

	static {
		instance = new Utils();
	}

	private Utils(){
		seguridadPropiedades = new Properties();
		try {
			seguridadPropiedades.load(Utils.class.getResourceAsStream(URL_SEGURIDAD_PROPIEDADES));
		} catch (IOException e) {
			log.error("Imposible leer el archivo " + URL_SEGURIDAD_PROPIEDADES, e);
			throw new RuntimeException("Imposible leer el archivo " + URL_SEGURIDAD_PROPIEDADES);
		}
	}

	public static Utils getInstance(){
		return instance;
	}

	/**
	 * Obtiene el valor de la propiedad
	 * 
	 * @param clave
	 * @return
	 */
	public String getPropiedad(String clave){
		return seguridadPropiedades.getProperty(clave);
	}
}
