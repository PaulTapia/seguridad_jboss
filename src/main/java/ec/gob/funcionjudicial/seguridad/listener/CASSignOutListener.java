/**
 * 
 */
package ec.gob.funcionjudicial.seguridad.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;

/**
 * @author fausto
 *
 */
public class CASSignOutListener implements HttpSessionListener {

	private SingleSignOutHttpSessionListener listener = new SingleSignOutHttpSessionListener();

	public void sessionCreated(HttpSessionEvent se) {
		listener.sessionCreated(se);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		listener.sessionDestroyed(se);
	}

}
