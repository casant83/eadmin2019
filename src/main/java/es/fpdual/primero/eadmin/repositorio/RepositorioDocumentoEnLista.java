package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.EadminApplication;
import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

import org.apache.log4j.*;

import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;

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

		//writePDF(documento);

		
		
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
			
			// Image properties
			final int qr_image_width = 400;
			final int qr_image_height = 400;
			final String IMAGE_FORMAT = "png";
			final String IMG_PATH = "C:\\Users\\formacion\\Documents\\DAW\\Java_AntonioCalle\\CodigoQR.png";

			// URL to be encoded
			String data = documento.getNombre();

			// Encode URL in QR format
			BitMatrix matrix;
			Writer writer2 = new QRCodeWriter();
			try {

				matrix = writer2.encode(data, BarcodeFormat.QR_CODE, qr_image_width, qr_image_height);

			} catch (WriterException e) {
				e.printStackTrace(System.err);
				return;
			}

			// Create buffered image to draw to
			BufferedImage image = new BufferedImage(qr_image_width, qr_image_height, BufferedImage.TYPE_INT_RGB);

			// Iterate through the matrix and draw the pixels to the image
			for (int y = 0; y < qr_image_height; y++) {
				for (int x = 0; x < qr_image_width; x++) {
					int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
					image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
				}
			}

			// Write the image to a file
			FileOutputStream qrCode = new FileOutputStream(IMG_PATH);
			ImageIO.write(image, IMAGE_FORMAT, qrCode);

			qrCode.close();
			try {
				//crearPDFLog("C:\\Users\\formacion\\Documents\\DAW\\Java_AntonioCalle\\CodigoQR.png");
				QrToPDF(IMG_PATH);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

	private static void writePDF(Documento documento) {

		Document document = new Document();

		try {
			// String path = new File(".").getCanonicalPath();
			String FILE_NAME = "C:\\Users\\formacion\\Documents\\DAW\\Java_AntonioCalle\\DocumentoPDF.pdf";

			PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

			document.open();

			Paragraph paragraphHello = new Paragraph();
			paragraphHello.add("Exporta documentos creados:");
			paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

			document.add(paragraphHello);

			Paragraph paragraphLorem = new Paragraph();
			paragraphLorem.add("Id: " + documento.getId() + " Nombre: " + documento.getNombre() + " Fecha: "
					+ documento.getFechaCreacion() + " Tipo Documento: " + documento.getTipoDocumento() + " Usuario: "
					+ documento.getUsuario().getNombre());

			java.util.List<Element> paragraphList = new ArrayList<>();

			paragraphList = paragraphLorem.breakUp();

			Font f = new Font();
			f.setFamily(FontFamily.COURIER.name());
			f.setStyle(Font.BOLDITALIC);
			f.setSize(8);

			Paragraph p3 = new Paragraph();
			p3.setFont(f);
			p3.addAll(paragraphList);
			// p3.add("TEST LOREM IPSUM DOLOR SIT AMET CONSECTETUR ADIPISCING ELIT!");

			// document.add(paragraphLorem);
			document.add(p3);
			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void crearPDFLog(String file) throws FileNotFoundException, DocumentException {
		String linea, FileName;
		File InFile = null;
		FileReader fr = null;
		BufferedReader br = null;

		// Selecciona el archivo a convertir.
		FileName = SelectTxtFile(file);

		// Abre el archivo y crea el reader.
		InFile = new File(FileName);
		fr = new FileReader(InFile);
		br = new BufferedReader(fr);

		// Crea el documento de salida.
		FileOutputStream archivo = new FileOutputStream(
				"C:\\Users\\formacion\\Documents\\DAW\\Java_AntonioCalle\\DocumentoPDFLog.pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();

		try {
			while ((linea = br.readLine()) != null) {
				documento = AddNewLine(documento, linea);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// En el finally cerramos el fichero, para asegurarnos en cualquier
			// circunstancia.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// Cerramos el documento PDF.
		documento.close();

	}

	static public Document AddNewLine(Document doc, String linea) {
		try {
			doc.add(new Paragraph(linea));
		} catch (DocumentException de) {
			de.printStackTrace();
		}

		return doc;
	}

	static public String SelectTxtFile(String file) {

		/*int returnValue;
		File selectedFile = null;
		String FileName = "";

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			FileName = selectedFile.getPath();
		}
*/
		return file;
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

	
	public void QrToPDF(String rutaImagen) throws DocumentException, MalformedURLException, IOException {
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\formacion\\Documents\\DAW\\Java_AntonioCalle\\QrToPdf.pdf"));
		document.open();
		Image image = Image.getInstance(rutaImagen);
		document.add(image);
		document.close();
	}
}
