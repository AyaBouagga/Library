package Inscription;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
public class testpdfreader {
	
	 
	/**
	 * This class is used to modify an existing pdf file using iText jar.
	 * @author MohanRathour
	 */
	
		public static void main(String args[]){
			try {
			    //Create PdfReader instance.
			    PdfReader pdfReader = 
					new PdfReader("C:\\Users\\eya\\Desktop\\1.pdf");	
			    if (Desktop.isDesktopSupported()) {
			        try {
			            File myFile = new File("C:\\\\Users\\\\eya\\\\Desktop\\\\1.pdf");
			            Desktop.getDesktop().open(myFile);
			        } catch (IOException ex) {
			            // no application registered for PDFs
			        }
			    }
	             /*
			    //Create PdfStamper instance.
			    PdfStamper pdfStamper = new PdfStamper(pdfReader,
				new FileOutputStream("D:\\ModifiedTestFile.pdf"));
	             
			    //Create BaseFont instance.
			    BaseFont baseFont = BaseFont.createFont(
		                BaseFont.TIMES_ROMAN, 
		                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	 
			    //Get the number of pages in pdf.
			    int pages = pdfReader.getNumberOfPages(); 
	 
			    //Iterate the pdf through pages.
			    for(int i=1; i<=pages; i++) { 
				//Contain the pdf data.
				PdfContentByte pageContentByte = 
						pdfStamper.getOverContent(i);
	 
				pageContentByte.beginText();
				//Set text font and size.
				pageContentByte.setFontAndSize(baseFont, 14);
	 
				pageContentByte.setTextMatrix(50, 740);
	 
				//Write text
				pageContentByte.showText("javawithease.com");
				pageContentByte.endText();
			    }
	 
			    //Close the pdfStamper.
			    pdfStamper.close();	
	 
			    System.out.println("PDF modified successfully.");*/
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}

