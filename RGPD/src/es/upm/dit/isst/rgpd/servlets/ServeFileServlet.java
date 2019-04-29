package es.upm.dit.isst.rgpd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.rgpd.dao.SolicitudDAO;
import es.upm.dit.isst.rgpd.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.rgpd.model.Solicitud;



/**
 * Servlet implementation class ServeFileServlet
 */
@WebServlet("/ServeFileServlet")
public class ServeFileServlet extends HttpServlet {
	
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
    	String id = req.getParameter( "id" );
		int idInt = Integer.parseInt(id);
		Solicitud solicitud = sdao.read(idInt);
		resp.setContentLength(solicitud.getMemoria().length);
		resp.getOutputStream().write(solicitud.getMemoria());
		
	}

}
