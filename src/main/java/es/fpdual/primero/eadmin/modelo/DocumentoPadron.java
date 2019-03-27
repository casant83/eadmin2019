package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoPadron  extends Documento{

	private final String direccion;
	
	public DocumentoPadron(int id, String nombre, Usuario usuario, Date fechaCreacion, String direccion){
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_PADRON);
		this.direccion = direccion;
	}

	public String getDireccion() {
		return direccion;
	}	
	
}
