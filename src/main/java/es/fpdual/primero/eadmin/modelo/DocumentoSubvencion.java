package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

public class DocumentoSubvencion  extends Documento{

	private final double importeSubvencion;
	
	public DocumentoSubvencion(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, double importeSubvencion){
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_SUBVENCION);
		this.importeSubvencion = importeSubvencion;
	}

	public double getImporteSubvencion() {
		return importeSubvencion;
	}
}
