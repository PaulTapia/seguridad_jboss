/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.resolver;

import ec.gob.funcionjudicial.identidad.enumeracion.NivelAcceso;
import ec.gob.funcionjudicial.identidad.model.Opcion;
import ec.gob.funcionjudicial.identidad.model.Permiso;
import ec.gob.funcionjudicial.identidad.model.Rol;
import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;
import ec.gob.funcionjudicial.identidad.util.IdentidadUtils;

/**
 * @author Fausto De La Torre
 *
 */
class UsuarioResolverStrategyPrincipalCAS implements UsuarioResolverStrategy {

	public IUsuarioFuncionJudicial getUsuario(HttpServletRequest request) {
		AttributePrincipal casPrincipal = (AttributePrincipal) request.getUserPrincipal();
		IUsuarioFuncionJudicial usuarioFuncionJudicial = null;
		if(casPrincipal != null){
			String usuarioFuncionJudicialString = (String) casPrincipal.getAttributes().get("usuarioFuncionJudicial");
      		System.out.println("--->>> usuarioFuncionJudicialString: " + usuarioFuncionJudicialString);
			usuarioFuncionJudicial = IdentidadUtils.getInstance().decodificarObjeto(usuarioFuncionJudicialString);
      		System.out.println("--->>> usuarioFuncionJudicial: " + usuarioFuncionJudicial);

					System.out.println("--------------- PRINCIPAL ---------------");
					System.out.println("nombres: " + usuarioFuncionJudicial.getNombres());
					System.out.println("usuarioPrincipal: " + usuarioFuncionJudicial.getUsuarioPrincipal());
					System.out.println("usuarioAdicional: " + usuarioFuncionJudicial.getUsuarioAdicional());
					System.out.println("tipoUsuario: " + usuarioFuncionJudicial.getTipoUsuario());

					System.out.println("--------------- LISTAS ---------------");
					System.out.println("============>>>>> roles: ");

					for (Rol rol : usuarioFuncionJudicial.getRoles()) {
						System.out.println("codigo: " + rol.getCodigo());
						System.out.println("nombre: " + rol.getNombre());
						System.out.println("aplicacion: " + rol.getAplicacion());
					}

					System.out.println("============>>>>> permisos: ");
					for (Permiso permiso : usuarioFuncionJudicial.getPermisos()) {
						System.out.println("url: " + permiso.getUrl());
						System.out.println("nombre: " + permiso.getNombre());
						System.out.println("nivelesAcceso: ");
						if(permiso.getNivelesAcceso() != null){
							for (NivelAcceso nivelAcceso : permiso.getNivelesAcceso()) {
								System.out.println("nivelAcceso: " + nivelAcceso);
							}
						}
					}

					System.out.println("============>>>>> opciones: ");
					for (Opcion opcion : usuarioFuncionJudicial.getOpciones()) {
						System.out.println("opcion: " + opcion.getCodigo());
						System.out.println("nombre: " + opcion.getNombre());
						System.out.println("opcion: " + opcion.getPadre());
						System.out.println("url: " + opcion.getUrl());
						System.out.println("============>>>>> subOpciones: ");
						for (Opcion subOpcion : opcion.getSubOpciones()) {
							System.out.println("subOpcion: " + subOpcion.getCodigo());
							System.out.println("nombre: " + subOpcion.getNombre());
							System.out.println("opcion: " + subOpcion.getPadre());
							System.out.println("url: " + subOpcion.getUrl());
						}

					}
					System.out.println("--------------- FIN LISTAS ---------------");

		}
		return usuarioFuncionJudicial;
	}

}
