package es.fpdual.primero.eadmin;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;
import es.fpdual.primero.eadmin.modelo.DocumentoSubvencion;
import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.modelo.Usuario;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.TipoExpediente;
import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaBase;

import org.apache.log4j.*;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LogManager.getLogger(EadminApplication.class);
	
	public static void main(String[] args) {
		try {
			String fichero = "trazas.txt";
			FileWriter writer = new FileWriter(fichero,true);
			PrintWriter imprimir = new PrintWriter(writer);
			
			logger.info("inicio");
			imprimir.println("inicio");
			SpringApplication.run(EadminApplication.class, args);
			logger.info("fin");
			imprimir.println("fin");
			
			imprimir.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	
	
	}

}
