package es.upm.dit.isst.rgpd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.rgpd.dao.ExpertoDAO;
import es.upm.dit.isst.rgpd.dao.ExpertoDAOImplementation;
import es.upm.dit.isst.rgpd.dao.SolicitudDAO;
import es.upm.dit.isst.rgpd.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.rgpd.model.Experto;
import es.upm.dit.isst.rgpd.model.Solicitud;

/**
 * Servlet implementation class NuevaSolicitudServlet
 */
@WebServlet("/DenegarServlet")
public class DenegarServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		String id = req.getParameter( "idSol" );
		int idInt = Integer.parseInt(id);
		Solicitud solicitud = sdao.read(idInt);
		solicitud.setEstado(2);
		sdao.update(solicitud);
		sdao.readAll();

		ExpertoDAO edao = ExpertoDAOImplementation.getInstance();
		String email = req.getParameter( "email" );
		Experto experto = edao.read(email); 
		req.getSession().setAttribute("solicitud", solicitud );
		req.getSession().setAttribute("experto", experto );
		getServletContext().getRequestDispatcher( "/ExpedienteView.jsp" ).forward( req, resp );
	     
		
	}

}
