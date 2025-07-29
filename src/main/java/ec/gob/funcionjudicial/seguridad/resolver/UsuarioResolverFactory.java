/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.resolver;

/**
 * @author Fausto De La Torre
 *
 */
public class UsuarioResolverFactory {
	private static UsuarioResolver usuarioResolver;
	
	public static UsuarioResolver getResolver(){
		if(usuarioResolver == null){
			usuarioResolver = new ProxyUsuarioResolver();
		}
		return usuarioResolver;
	}
}
