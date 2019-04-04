package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.EadminApplication;
import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

import org.apache.log4j.*;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private final Logger logger = LogManager.getLogger(RepositorioDocumentoEnLista.class);

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento ya existe");
		}
		documentos.add(documento);
		try {
			String fichero = "trazas.txt";
			FileWriter writer = new FileWriter(fichero, true);
			PrintWriter imprimir = new PrintWriter(writer);

			// imprimir.println("Id: " + documento.getId());
			// imprimir.println("Nombre: " + documento.getNombre());
			// imprimir.println("Fecha: " + documento.getFechaCreacion());
			// imprimir.println("Tipo Documento: " + documento.getTipoDocumento());
			// imprimir.println("Usuario: " + documento.getUsuario().getNombre());

			logger.info("Documento tipo: " + documento.getTipoDocumento().name());

			if (documento.getTipoDocumento().name().equals("DOCUMENTO_CONTABLE")) {
				logger.trace("***********************************");
				imprimir.println("***********************************");
				logger.trace("DOCUMENTO CREADO CORRECTAMENTE");
				imprimir.println("DOCUMENTO CREADO CORRECTAMENTE");
				logger.trace(" ID: " + documento.getId());
				imprimir.println(" ID: " + documento.getId());
				logger.trace(" NOMBRE: " + documento.getNombre());
				imprimir.println(" NOMBRE: " + documento.getNombre());
				logger.trace(" USUARIO: " + documento.getUsuario().getNombre());
				imprimir.println(" USUARIO: " + documento.getUsuario().getNombre());
				logger.trace(" FECHA: " + documento.getFechaCreacion());
				imprimir.println(" FECHA: " + documento.getFechaCreacion());
				logger.trace(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				imprimir.println(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				logger.trace("***********************************");
				imprimir.println("***********************************");
				imprimir.close();
			} else if (documento.getTipoDocumento().name().equals("DOCUMENTO_NOMINA")) {
				logger.warn("***********************************");
				imprimir.println("***********************************");
				logger.warn("DOCUMENTO CREADO CORRECTAMENTE");
				imprimir.println("DOCUMENTO CREADO CORRECTAMENTE");
				logger.warn(" ID: " + documento.getId());
				imprimir.println(" ID: " + documento.getId());
				logger.warn(" NOMBRE: " + documento.getNombre());
				imprimir.println(" NOMBRE: " + documento.getNombre());
				logger.warn(" USUARIO: " + documento.getUsuario().getNombre());
				imprimir.println(" USUARIO: " + documento.getUsuario().getNombre());
				logger.warn(" FECHA: " + documento.getFechaCreacion());
				imprimir.println(" FECHA: " + documento.getFechaCreacion());
				logger.warn(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				imprimir.println(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				logger.warn("***********************************");
				imprimir.println("***********************************");
				imprimir.close();
			} else if (documento.getTipoDocumento().name().equals("DOCUMENTO_PADRON")) {
				logger.error("***********************************");
				imprimir.println("***********************************");
				logger.error("DOCUMENTO CREADO CORRECTAMENTE");
				imprimir.println("DOCUMENTO CREADO CORRECTAMENTE");
				logger.error(" ID: " + documento.getId());
				imprimir.println(" ID: " + documento.getId());
				logger.error(" NOMBRE: " + documento.getNombre());
				imprimir.println(" NOMBRE: " + documento.getNombre());
				logger.error(" USUARIO: " + documento.getUsuario().getNombre());
				imprimir.println(" USUARIO: " + documento.getUsuario().getNombre());
				logger.error(" FECHA: " + documento.getFechaCreacion());
				imprimir.println(" FECHA: " + documento.getFechaCreacion());
				logger.error(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				imprimir.println(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				logger.error("***********************************");
				imprimir.println("***********************************");
				imprimir.close();
			} else {
				// logger.trace("Documento "+ documento.getId() +" creado correctamente");
				logger.debug("***********************************");
				imprimir.println("***********************************");
				logger.debug("DOCUMENTO CREADO CORRECTAMENTE");
				imprimir.println("DOCUMENTO CREADO CORRECTAMENTE");
				logger.debug(" ID: " + documento.getId());
				imprimir.println(" ID: " + documento.getId());
				logger.debug(" NOMBRE: " + documento.getNombre());
				imprimir.println(" NOMBRE: " + documento.getNombre());
				logger.debug(" USUARIO: " + documento.getUsuario().getNombre());
				imprimir.println(" USUARIO: " + documento.getUsuario().getNombre());
				logger.debug(" FECHA: " + documento.getFechaCreacion());
				imprimir.println(" FECHA: " + documento.getFechaCreacion());
				logger.debug(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				imprimir.println(" TIPO DOCUMENTO: " + documento.getTipoDocumento());
				logger.debug("***********************************");
				imprimir.println("***********************************");
				imprimir.close();
			}
			// try {
			// String fichero = documento.getNombre()+".txt";
			// FileWriter writer = new FileWriter(fichero);
			// PrintWriter imprimir = new PrintWriter(writer);
			//
			// imprimir.println("Id: "+documento.getId());
			// imprimir.println("Nombre: "+documento.getNombre());
			// imprimir.println("Fecha: "+documento.getFechaCreacion());
			// imprimir.println("Tipo Documento: "+documento.getTipoDocumento());
			// imprimir.println("Usuario: "+documento.getUsuario().getNombre());
			// imprimir.close();
			//
			// } catch (IOException e) {
			// e.printStackTrace();
			// }

			// try {
			//
			// File esteFichero = new
			// File(documento.getNombre()+"-"+documento.getTipoDocumento()+".txt");
			//
			// if(esteFichero.exists()) {
			// logger.error("El fichero ya existe");
			// } else {
			// logger.error("El fichero no existe. Creando...");
			//
			// }
			// String fichero2 =
			// documento.getNombre()+"-"+documento.getTipoDocumento()+".txt";
			// FileWriter writer2 = new FileWriter(fichero2);
			// PrintWriter imprimir2 = new PrintWriter(writer2);
			//
			// imprimir2.println("Id: "+documento.getId());
			// imprimir2.println("Nombre: "+documento.getNombre());
			// imprimir2.println("Fecha: "+documento.getFechaCreacion());
			// imprimir2.println("Tipo Documento: "+documento.getTipoDocumento());
			// imprimir2.println("Usuario: "+documento.getUsuario().getNombre());
			// imprimir2.close();
			//
			//
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe, no se puede modificar");
		}
		documentos.set(documentos.indexOf(documento), documento);

	}

	@Override
	public void eliminarDocumento(int id) {
		// Solucion1
		Documento documentoAEliminar = new Documento(id, null, null, null, null);

		// Solucion2
		// documentoAEliminar = documentos.stream().filter(d->d.getId() ==
		// id).findAny().orElse(null);

		final int indice = documentos.indexOf(documentoAEliminar);
		if (indice >= 0) {
			documentos.remove(indice);
		}
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		

		try {
			String fichero = "listadoDocumentos.txt";
			FileWriter writer = new FileWriter(fichero);
			PrintWriter imprimir = new PrintWriter(writer);

			for (Documento documento : documentos) {
				
				imprimir.println("-----------------------------------------------");
				imprimir.println("Id: " + documento.getId());
				imprimir.println("Nombre: " + documento.getNombre());
				imprimir.println("Fecha: " + documento.getFechaCreacion());
				imprimir.println("Tipo Documento: " + documento.getTipoDocumento());
				imprimir.println("Usuario: " + documento.getUsuario().getNombre());
				imprimir.println("-----------------------------------------------");
				
			}
			imprimir.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.documentos.stream().collect(Collectors.toList());
		
	}
	


	@Override
	public int getSiguienteId() {
		if (documentos.isEmpty()) {
			return 1;
		}
		return documentos.get(documentos.size() - 1).getId() + 1;
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return documentos.stream().filter(d -> d.getId() == codigoDocumento).findFirst().orElse(null);
	}

}
