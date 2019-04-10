package es.upm.dit.isst.rgpd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.rgpd.dao.InvestigadorDAO;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.rgpd.model.Investigador;

/**
 * Servlet implementation class NuevaSolicitudServlet
 */
@WebServlet("/NuevaSolicitudServlet")
public class NuevaSolicitudServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InvestigadorDAO idao = InvestigadorDAOImplementation.getInstance();
		String email = req.getParameter( "emailInv" );
		Investigador investigador = idao.read(email); 
		req.getSession().setAttribute("investigador", investigador );
		getServletContext().getRequestDispatcher( "/SolicitudView.jsp" ).forward( req, resp );
	     
	}

}
