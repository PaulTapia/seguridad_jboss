/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ec.gob.funcionjudicial.identidad.model.IUsuarioFuncionJudicial;
import ec.gob.funcionjudicial.identidad.model.Permiso;
import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.exception.UsuarioNoResueltoException;
import ec.gob.funcionjudicial.seguridad.resolver.UsuarioResolverFactory;
import ec.gob.funcionjudicial.seguridad.util.Constantes;

/**
 * Filtro que permite realizar la autorizacion de un usuario logeado en las diferentes urls
 * 
 * @author Fausto De La Torre
 * 
 */
public class FiltroAutorizacionFuncionJudicial implements Filter {

	private static final Logger log = Logger.getLogger(FiltroAutorizacionFuncionJudicial.class);
	private MetodoAutenticacion metodoAutenticacion;
	private String urlSinAutorizacion;
	private String urlError;

	public void destroy() {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		boolean tienePermiso;
		String urlRedireccionar = urlSinAutorizacion;
		
		try {
			IUsuarioFuncionJudicial usuarioFuncionJudicial = UsuarioResolverFactory.getResolver().obtenerUsuarioLogeado(req, metodoAutenticacion);
			String url = req.getServletContext().getContextPath() + req.getServletPath();
			tienePermiso = verificarPermiso(usuarioFuncionJudicial, url);
		} catch (UsuarioNoResueltoException e) {
			log.error("UsuarioConverterException " + e.getMessage(), e);
			tienePermiso = false;
			urlRedireccionar = urlError;
		}

		if(tienePermiso){
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("/" + urlRedireccionar);
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		metodoAutenticacion = MetodoAutenticacion.valueOf(filterConfig.getInitParameter(Constantes.METODO_AUTENTICACION_KEY));
    	System.out.println("--->>> metodoAutenticacion: " + metodoAutenticacion);
		urlSinAutorizacion = filterConfig.getInitParameter(Constantes.URL_SIN_AUTORIZACION_KEY);
    	System.out.println("--->>> urlSinAutorizacion: " + urlSinAutorizacion);
		urlError = filterConfig.getInitParameter(Constantes.URL_ERROR_KEY);
    	System.out.println("--->>> 1 urlError: " + urlError);

		urlSinAutorizacion = urlSinAutorizacion==null?Constantes.URL_SIN_AUTORIZACION_DEFAULT:urlSinAutorizacion;
    	System.out.println("--->>> urlSinAutorizacion: " + urlSinAutorizacion);
		urlError = urlError==null?Constantes.URL_ERROR_DEFAULT:urlError;
    	System.out.println("--->>> 2 urlError: " + urlError);
	}

	/**
	 * Verifica si el usuario logeado tiene permisos de acceder a la url
	 * 
	 * @param usuarioFuncionJudicial
	 * @param url
	 * @return true si tiene permiso, false si no 
	 */
	private boolean verificarPermiso(IUsuarioFuncionJudicial usuarioFuncionJudicial, String url){
		boolean tienePermiso = false;
		if(usuarioFuncionJudicial != null) {
			if(usuarioFuncionJudicial.getPermisos() != null){
				for (Permiso permiso : usuarioFuncionJudicial.getPermisos()) {
					if(url.startsWith(permiso.getUrl())){
						tienePermiso = true;
						break;
					}
				}
			}
		}

		return tienePermiso;
	}

}
