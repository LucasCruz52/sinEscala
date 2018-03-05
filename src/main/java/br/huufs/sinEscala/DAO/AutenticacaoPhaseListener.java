package br.huufs.sinEscala.DAO;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import org.primefaces.ultima.domain.Usuario;

public class AutenticacaoPhaseListener implements PhaseListener {
	   
		@Override
		public void afterPhase(PhaseEvent event) {
			  FacesContext fc = event.getFacesContext();
		      ExternalContext ec = fc.getExternalContext();
		     /*
		        if (!fc.getViewRoot().getViewId().contains("loginUsuario.xhtml")) {
		            HttpSession session = (HttpSession) ec.getSession(true);
		            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

		            if (usuario == null) {
		                try {
		                    ec.redirect(ec.getRequestContextPath() + "/loginUsuario.xhtml");
		                } catch (IOException ex) {
		                    Logger.getLogger(AutenticacaoPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
		                }
		            }
		        }
			*/
		}

		@Override
		public void beforePhase(PhaseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public PhaseId getPhaseId() {
			return PhaseId.RESTORE_VIEW;
		}
	
}
