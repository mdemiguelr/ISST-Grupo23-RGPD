package es.upm.dit.isst.rgpd.util.jobs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.upm.dit.isst.rgpd.dao.ExpertoDAO;
import es.upm.dit.isst.rgpd.dao.ExpertoDAOImplementation;
import es.upm.dit.isst.rgpd.dao.SolicitudDAO;
import es.upm.dit.isst.rgpd.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.rgpd.model.Experto;
import es.upm.dit.isst.rgpd.model.Solicitud;

import es.upm.dit.isst.rgpd.util.EmailHandler;

public class TimeoutJob  implements Job {
    public void execute(JobExecutionContext context)
            throws JobExecutionException {

    	EmailHandler correo = EmailHandler.getInstance();
    	
    	SolicitudDAO sdao = SolicitudDAOImplementation.getInstance();
    	List<Solicitud> solicitudes = new ArrayList<>();
		solicitudes = (List<Solicitud>) sdao.readAll();
		
    	LocalDate fechaActual = LocalDate.now();
    	List<Experto> expertos = new ArrayList<>();
		
		
		
		for(int i=0; i<solicitudes.size(); i++) {
			long dias = ChronoUnit.DAYS.between(fechaActual , solicitudes.get(i).getFechaCreacion());
			if (dias>5) {
				expertos = (List<Experto>) solicitudes.get(i).getExpertos();
				for(int j=0; j<expertos.size(); j++) {
					
					correo.sendEmail(expertos.get(j).getEmail(), "Aviso de revisión de expediente", "Tiene un expediente para revisar");
				}
			}	
			
		}
}

}
