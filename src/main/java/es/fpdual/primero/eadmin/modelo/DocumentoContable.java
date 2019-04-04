package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

import org.apache.log4j.*;

import es.fpdual.primero.eadmin.repositorio.RepositorioDocumentoEnLista;

public class DocumentoContable extends Documento{
	
	private final String numeroOperacionContable;
	private final Logger logger = LogManager.getLogger(DocumentoContable.class);
	
	public DocumentoContable(int id, String nombre, Usuario usuario, Date fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
		logger.warn("Creado documento contable");
		System.out.println("hola!!");
	}
	
	public String getNumeroOperacionContable() {
		return numeroOperacionContable;
	}

	

}
