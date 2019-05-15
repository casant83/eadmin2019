package es.fpdual.primero.eadmin.servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.primero.eadmin.EadminApplication;
import es.fpdual.primero.eadmin.modelo.Documento;

import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.*;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	private final RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		final int siguienteId = repositorioDocumento.getSiguienteId();
		final LocalDate fechaActual = LocalDate.now();
		Documento documentoModificado = new Documento(siguienteId, documento.getNombre(), documento.getUsuario(),
				fechaActual, documento.getTipoDocumento());
		repositorioDocumento.altaDocumento(documentoModificado);
		Excel();
		return documentoModificado;

	}

	@Override
	public void modificarDocumento(Documento documento) {
		repositorioDocumento.modificarDocumento(documento);
	}

	@Override                                                                                                                                                                                                                                      
	public void eliminarDocumento(int codigoDocumento) {
		repositorioDocumento.eliminarDocumento(codigoDocumento);

	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {

		return repositorioDocumento.obtenerTodosDocumentos();
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return this.repositorioDocumento.obtenerDocumentoPorId(codigoDocumento);
	}

	public void Excel() {
	String nombreArchivo="Documentos.xlsx";
	String rutaArchivo= "C:\\Users\\formacion\\Documents\\DAW\\Java_AntonioCalle"+nombreArchivo;
	String hoja="Hoja1";
	
	XSSFWorkbook libro= new XSSFWorkbook(); 
	XSSFSheet hoja1 = libro.createSheet(hoja);
	//cabecera de la hoja de excel
	
	String [] header= new String[]{"Id", "Nombre","Usuario","Fecha", "Tipo Documento"};
	
	//contenido de la hoja de excel
	List<Documento> listaDocumentos = obtenerTodosDocumentos();
	
	//poner negrita a la cabecera

	
	CellStyle style = libro.createCellStyle();
    Font font = libro.createFont();
    font.setBold(true);
    style.setFont(font);

    XSSFRow row=hoja1.createRow(0);
    for (int j = 0; j <header.length; j++) {
		XSSFCell cell= row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
		cell.setCellStyle(style); // se añade el style crea anteriormente 
		cell.setCellValue(header[j]);//se añade el contenido	
    }
    row=hoja1.createRow(1);
   int j=2;
    for (Documento documento: listaDocumentos) {
    	XSSFCell cell= row.createCell(0);//se crea las celdas para la contenido, junto con la posición
		cell.setCellValue(documento.getId()); //se añade el contenido
		cell= row.createCell(1);
		cell.setCellValue(documento.getNombre());
		cell= row.createCell(2);
		cell.setCellValue(documento.getUsuario().getNombre());
		cell= row.createCell(3);
		cell.setCellValue(documento.getFechaCreacion().toString());
		cell= row.createCell(4);
		cell.setCellValue(documento.getTipoDocumento().name());
		row=hoja1.createRow(j);
		j++;
	}
    

	
	File file;
	file = new File(rutaArchivo);
	try (FileOutputStream fileOuS = new FileOutputStream(file)){						
		if (file.exists()) {// si el archivo existe se elimina
			file.delete();
			System.out.println("Archivo eliminado");
		}
		libro.write(fileOuS);
		fileOuS.flush();
		fileOuS.close();
		System.out.println("Archivo Creado");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
