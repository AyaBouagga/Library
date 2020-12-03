import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.gnostice.pdfone.PDFOne;
import com.gnostice.pdfone.PdfAnnot;
import com.gnostice.pdfone.PdfCaretAnnot;
import com.gnostice.pdfone.PdfCircleAnnot;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfLineAnnot;
import com.gnostice.pdfone.PdfLinkAnnot;
import com.gnostice.pdfone.PdfPolygonAnnot;
import com.gnostice.pdfone.PdfSquareAnnot;
import com.gnostice.pdfone.PdfTextAnnot;

public class ManageAnnotation
{
    static
    {
        PDFOne.activate("T95VZE:W8HBPVA:74VQ8QV:LO4V8",
            "9B1HRZAP:X5853ERNE:5EREMEGRQ:TX1R10");
    }

    /* Usage : java ManageAnnotation <input file path> <output file path> */
    /* Supply PDF file with Annotation as "input file path"*/
    public static void main(String[] args) throws IOException,
        PdfException
    {
        ///////////////////////////////////////////
        // Open a doc and modify its annotations //
        ///////////////////////////////////////////
        
        try
        {
            /* Create a new PdfDocument instance */
            PdfDocument d = new PdfDocument();

            /* Load the PDF document into the document object */
            d.load(args[0]);

            /* Retrieve all annotations from page 1 of the document */
            List lis = d.getAllAnnotationsOnPage(1);

            for (int i = 0; i < lis.size(); i++)
            {
                /*
                 * Cast the retrieved annotation object to its super
                 * class PdfAnnot.
                 */
                PdfAnnot annot = (PdfAnnot) lis.get(i);

                switch (annot.getType())
                {
                    case PdfAnnot.ANNOT_TYPE_CIRCLE:
                        /* Change properties of the PdfCircleAnnot */
                        PdfCircleAnnot circleAnnot = (PdfCircleAnnot) annot;
                        circleAnnot.setCloudy(true);
                        circleAnnot.setCloudIntensity(2);
                        circleAnnot.setTitle("Title Changed");
                        circleAnnot.setContents("Content Changed");
                        circleAnnot.setSubject("Subject Changed");
                        circleAnnot.setBorderWidth(4);
                        break;

                    case PdfAnnot.ANNOT_TYPE_LINE:
                        /* Change properties of the PdfLineAnnot */
                        PdfLineAnnot lineAnnot = (PdfLineAnnot) annot;
                        ((PdfLineAnnot) lis.get(i))
                            .setLineStartStyle(3);
                        lineAnnot.setTitle("Title Changed");
                        lineAnnot.setContents("Content Changed");
                        lineAnnot.setSubject("Subject Changed");
                        lineAnnot.setInteriorColor(Color.darkGray);
                        lineAnnot
                            .setLineStartStyle(PdfLineAnnot.LINEENDSTYLE_OPEN_ARROW);
                        lineAnnot
                            .setLineEndStyle(PdfLineAnnot.LINEENDSTYLE_CIRCLE);
                        lineAnnot
                            .setBorderStyle(PdfLineAnnot.BORDERSTYLE_SOLID);
                        lineAnnot.setBorderWidth(3);
                        break;

                    case PdfAnnot.ANNOT_TYPE_SQUARE:
                        /* Change properties of the PdfSquareAnnot */
                        PdfSquareAnnot squareAnnot = (PdfSquareAnnot) annot;
                        squareAnnot.setTitle("Title Changed");
                        squareAnnot.setContents("Content Changed");
                        squareAnnot.setBorderWidth(3);
                        squareAnnot.setColor(Color.BLUE);
                        squareAnnot.setCloudy(true);
                        squareAnnot.setCloudIntensity(2);
                        break;

                    case PdfAnnot.ANNOT_TYPE_POLYGON:
                        /* Change properties of the PdfPolygonAnnot */
                        PdfPolygonAnnot polygonAnnot = (PdfPolygonAnnot) annot;
                        polygonAnnot.setTitle("Title Changed");
                        polygonAnnot.setContents("Content Changed");
                        polygonAnnot.setBorderWidth(3);
                        polygonAnnot.setColor(Color.BLUE);
                        polygonAnnot.setCloudy(true);
                        polygonAnnot.setCloudIntensity(2);
                        polygonAnnot
                            .setBorderStyle(PdfPolygonAnnot.BORDERSTYLE_DASHED);
                        break;

                    case PdfAnnot.ANNOT_TYPE_CARET:
                        /* Change properties of the PdfCaretAnnot */
                        PdfCaretAnnot caretAnnot = (PdfCaretAnnot) annot;
                        caretAnnot.setTitle("Title Changed");
                        caretAnnot.setContents("like this text here");
                        caretAnnot
                            .setSymbol(PdfCaretAnnot.SYMBOL_PARAGRAPH);
                        caretAnnot
                            .setSubject("Annotation Subject Changed");
                        break;

                    case PdfAnnot.ANNOT_TYPE_LINK:
                        /* Change properties of the PdfLinkAnnot */
                        PdfLinkAnnot linkAnnot = (PdfLinkAnnot) annot;
                        linkAnnot.setTitle("Title Changed");
                        linkAnnot
                            .setHighlightMode(PdfLinkAnnot.HIGHLIGHT_MODE_INVERT);
                        linkAnnot
                            .addActionJavaScript("app.alert('Gnostice Information"
                                + " Technologies')");
                        break;

                    case PdfAnnot.ANNOT_TYPE_TEXT:
                        /* Change properties of the PdfTextAnnot */
                        PdfTextAnnot textAnnot = (PdfTextAnnot) annot;
                        textAnnot.setColor(Color.RED);
                        textAnnot
                            .setContents("This Demo shows how to edit a "
                                + "Text Annotation");
                        textAnnot
                            .setTitle("Annotation Title Changed");
                        textAnnot
                            .setSubject("Annotation Subject Changed");
                        textAnnot.setOpen(false);
                        break;

                    default:
                        break;
                }
            }

            d.setOpenAfterSave(true);
            
            /* Save the document object */ 
            d.save(args[1]);

            /* Dispose the I/O files associated with this document object */
            d.close();
        }
        catch (ArrayIndexOutOfBoundsException n)
        {
            System.out.println("Usage : java ManageAnnotation"
                + " <input file path> <output file path>");
        }
    }
}
