package es.upm.dit.isst.rgpd.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.rgpd.dao.ExpertoDAO;
import es.upm.dit.isst.rgpd.dao.ExpertoDAOImplementation;
import es.upm.dit.isst.rgpd.model.Experto;
import es.upm.dit.isst.rgpd.model.Solicitud;



@WebServlet("/ExpertoServlet")
public class ExpertoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ExpertoDAO edao = ExpertoDAOImplementation.getInstance();
		String email = req.getParameter( "email" );
		Experto experto = edao.read(email); 
		
		LocalDate fechaActual = LocalDate.now();
		
		List<Solicitud> solicitudes = new ArrayList<>();
		solicitudes = experto.getSolAsignadas();
		List<Solicitud> solicitudesAtrasadas = new ArrayList<>();
		
		
		for(int i=0; i<solicitudes.size(); i++) {
			long dias = ChronoUnit.DAYS.between(fechaActual , solicitudes.get(i).getFechaCreacion());
			if (dias>1) {
				
			}
			
		}
				
		
		req.getSession().setAttribute("experto", experto );
		getServletContext().getRequestDispatcher( "/SolicitudListaExpView.jsp" ).forward( req, resp );
	     
	}
}
