package es.upm.dit.isst.rgpd.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
@WebServlet("/CrearSolicitudServlet")
public class CrearSolicitudServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter( "titulo" );
		String departamento = req.getParameter( "departamento" );
		String escuela = req.getParameter( "escuela" );
		
		String emailInv = req.getParameter( "emailInv" );
		
		Part filePart = req.getPart("file");
		InputStream fileContent = (InputStream) filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for (int length = 0; (length = fileContent.read(buffer)) > 0;) output.write(buffer, 0, length);
		
		
		
		Solicitud solicitud = new Solicitud();
		solicitud.setTitulo( titulo );
		solicitud.setDepartamento (departamento);
		solicitud.setEscuela( escuela );
		solicitud.setEstado( 0 );
		solicitud.setMemoria(output.toByteArray());
		
		Investigador inv = new Investigador();
		InvestigadorDAO idao = InvestigadorDAOImplementation.getInstance();
		inv = idao.read(emailInv);
		solicitud.setInvestigador(inv);
		
		//Creamos lista con los expertos disponibles
		List<Experto> expertosDisp = new ArrayList<>();
		ExpertoDAO edao = ExpertoDAOImplementation.getInstance();
		expertosDisp = edao.readAll();
		for(int i=0; i<= ( expertosDisp.size() - 1 ); i++) {
			if (expertosDisp.get(i).isDisponible() != true) {
				expertosDisp.remove(i);
			}
		}
		
		//De los expertos disponibles seleccionamos los 3 con menos solicitudes
		List<Experto> expertos = new ArrayList<>();
		
			while(expertos.size() < 3) {
				if(expertosDisp.size()==0)
				{
					break;
				}
				Experto expMin = expertosDisp.get(0);
				for(int i=0; i<= ( expertosDisp.size() - 1 ); i++) {
					if(expertosDisp.get(i).getSolAsignadas().size() < expMin.getSolAsignadas().size()) {
						expMin = expertosDisp.get(i);
					}
				}
				expertos.add(expMin);
				expertosDisp.remove(expMin);
			
		}
		solicitud.setExpertos(expertos);
	
		
		SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
		sdao.create( solicitud );
		
		resp.sendRedirect( req.getContextPath() + "/InvestigadorServlet?email" + emailInv );
	}
}