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



@WebServlet("/InvestigadorServlet")
public class InvestigadorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InvestigadorDAO idao = InvestigadorDAOImplementation.getInstance();
		String email = req.getParameter( "email" );
		Investigador investigador = idao.read(email); 
		req.getSession().setAttribute("investigador", investigador );
		getServletContext().getRequestDispatcher( "/SolicitudListaInvView.jsp" ).forward( req, resp );
	     
	}
}
