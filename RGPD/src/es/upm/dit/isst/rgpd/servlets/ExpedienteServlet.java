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


@WebServlet("/ExpedienteServlet")
public class ExpedienteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ExpertoDAO edao = ExpertoDAOImplementation.getInstance();
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		String id = req.getParameter( "idSol" );
		int idInt = Integer.parseInt(id);
		String email = req.getParameter( "email" );
		Experto experto = edao.read(email); 
		Solicitud solicitud = sdao.read(idInt);
		req.getSession().setAttribute("experto", experto );
		req.getSession().setAttribute("solicitud", solicitud );
		getServletContext().getRequestDispatcher( "/ExpedienteView.jsp" ).forward( req, resp );
	}

}
