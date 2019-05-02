package es.upm.dit.isst.rgpd.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.rgpd.dao.ExpertoDAO;
import es.upm.dit.isst.rgpd.dao.ExpertoDAOImplementation;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAO;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.rgpd.dao.SolicitudDAO;
import es.upm.dit.isst.rgpd.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.rgpd.model.Experto;
import es.upm.dit.isst.rgpd.model.Investigador;
import es.upm.dit.isst.rgpd.model.Solicitud;


@MultipartConfig
@WebServlet("/ActualizarMemoriaServlet")
public class ActualizarMemoriaServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		Part filePart = req.getPart("file");
		InputStream fileContent = (InputStream) filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for (int length = 0; (length = fileContent.read(buffer)) > 0;) output.write(buffer, 0, length);
		
		
		
		
		
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		
		
		String id = req.getParameter( "id" );
		int idInt = Integer.parseInt(id);
		Solicitud solicitud = sdao.read(idInt);
		solicitud.setMemoria(output.toByteArray());
		sdao.update(solicitud);
		sdao.readAll();

		
		String email = req.getParameter( "email" );
		InvestigadorDAO idao = InvestigadorDAOImplementation.getInstance();
		Investigador inv = idao.read(email);
		
		
		req.getSession().setAttribute("investigador", inv);
		getServletContext().getRequestDispatcher( "/SolicitudListaInvView.jsp" ).forward( req, resp );
		
	}
}