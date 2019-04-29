package es.upm.dit.isst.rgpd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.rgpd.dao.InvestigadorDAO;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.rgpd.dao.SolicitudDAO;
import es.upm.dit.isst.rgpd.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.rgpd.model.Investigador;
import es.upm.dit.isst.rgpd.model.Solicitud;


@WebServlet("/SolicitudServlet")
public class SolicitudServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InvestigadorDAO idao = InvestigadorDAOImplementation.getInstance();
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		String id = req.getParameter( "idSol" );
		int idInt = Integer.parseInt(id);
		String email = req.getParameter( "email" );
		Investigador investigador = idao.read(email); 
		Solicitud solicitud = sdao.read(idInt);
		req.getSession().setAttribute("investigador", investigador );
		req.getSession().setAttribute("solicitud", solicitud );
		getServletContext().getRequestDispatcher( "/SolicitudInvView.jsp" ).forward( req, resp );
	}

}
