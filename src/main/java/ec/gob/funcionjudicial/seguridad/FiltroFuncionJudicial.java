/**
 * 
 */
package ec.gob.funcionjudicial.seguridad;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ec.gob.funcionjudicial.seguridad.enumeracion.MetodoAutenticacion;
import ec.gob.funcionjudicial.seguridad.filtros.init.InicializadorFiltro;
import ec.gob.funcionjudicial.seguridad.util.Constantes;

/**
 * @author fausto
 *
 */
public abstract class FiltroFuncionJudicial implements Filter {
	
	private Filter filtro;

	public void init(FilterConfig filterConfig) throws ServletException {
		MetodoAutenticacion metodoAutenticacion = MetodoAutenticacion.valueOf(filterConfig.getInitParameter(Constantes.METODO_AUTENTICACION_KEY));
		
		InicializadorFiltro inicializadorFiltro = getInitFiltroParametros(filterConfig);
		if(inicializadorFiltro != null){
			inicializadorFiltro.inicializar(metodoAutenticacion);
		}
		
		filtro = getFiltro(metodoAutenticacion);
		filtro.init(filterConfig);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		filtro.doFilter(request, response, chain);
	}

	public void destroy() {
		filtro.destroy();
	}
	
	protected abstract Filter getFiltro(MetodoAutenticacion metodoAutenticacion);
	
	protected abstract InicializadorFiltro getInitFiltroParametros(FilterConfig filterConfig);

}
