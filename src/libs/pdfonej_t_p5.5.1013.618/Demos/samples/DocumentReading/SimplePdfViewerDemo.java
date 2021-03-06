import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;

import com.gnostice.pdfone.PDFOne;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfPasswordHandler;
import com.gnostice.pdfone.PdfPrinter;
import com.gnostice.pdfone.PdfViewer;

public final class SimplePdfViewerDemo extends JFrame implements
    ActionListener, PdfPasswordHandler
{
    private static final long serialVersionUID = 1L;

    String docPath;

    PdfDocument d;

    PdfViewer viewer;
    
    PdfPrinter pdfPrinter;

    // Controls for toolbar
    JFileChooser fc;

    JButton btnLoad;

    JButton btnPrint;

    JButton btnClose;

    JButton btnFirstPage = null;

    JButton btnPreviousPage = null;

    JButton btnNextPage = null;

    JButton btnLastPage = null;

    JLabel lblCurrentPageNum = null;

    static
    {
        PDFOne.activate("T95VZE:W8HBPVA:74VQ8QV:LO4V8",
            "9B1HRZAP:X5853ERNE:5EREMEGRQ:TX1R10");
    }

    public static void main(String[] args)
    {
        SimplePdfViewerDemo vd = new SimplePdfViewerDemo();

        vd.setSize(1024, 740);
        vd.setTitle("Gnostice PDFOne Viewer");
        vd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vd.setVisible(true);
    }

    public SimplePdfViewerDemo()
    {
        // File open dialog
        fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System
            .getProperty("user.home")
            + File.separatorChar + "Desktop"));
        
        // Create a PdfDocument object
        d = new PdfDocument();
        d.setOnPasswordHandler(this);

        // Create a new viewer container
        viewer = new PdfViewer();
        
        // Set the document object to the viewer
        viewer.setDocument(d);
        
        // Create a new PdfPrinter object
        pdfPrinter = new PdfPrinter();
        
        // Set the document object to the viewer
        pdfPrinter.setDocument(d);

        // If the library could not retrieve the jar file location or
        // appropriate pdfonejfont library
        // then PdfViewer.isFontProcessorLibraryLoaded() method will
        // return false. In such cases you can manually load the dll
        // using PdfViewer.loadFontProcessorLibrary(String libDirPath)
        // method by providing the directory path of the pdfonejfont
        // library.
        if ( !PdfViewer.isFontProcessorLibraryLoaded())
        {
            // Provide the directory path where pdfonejfont librariers
            // are stored
            String libDirPath = System.getProperty("user.dir");

            try
            {
                // Pass the directory path where pdfonejfont
                // librariers
                // are stored. Library name will be mapped according
                // to the platform and loaded
                PdfViewer.loadFontProcessorLibrary(libDirPath);

                if ( !PdfViewer.isFontProcessorLibraryLoaded())
                {
                    JOptionPane.showMessageDialog(this,
                        "Could not load pdfonejfont library",
                        "Load Library Error",
                        JOptionPane.INFORMATION_MESSAGE);
                }

            }
            catch (PdfException pdfEx)
            {
                JOptionPane.showMessageDialog(this,
                    "Could not load pdfonejfont library",
                    "Load Library Error",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Prepare window
        getContentPane().setLayout(new BorderLayout());
        // Add viewer to Frame
        getContentPane().add(viewer, BorderLayout.CENTER);
        // Add toolbar at the top of the frame
        getContentPane().add(getTopToolBar(), BorderLayout.NORTH);
    }

    private JToolBar getTopToolBar()
    {
        // Create a toolbar
        JToolBar topToolbar = new JToolBar("Tools",
            JToolBar.HORIZONTAL);
        topToolbar.setFloatable(false);
        topToolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create a button on the toolbar
        btnLoad = new JButton("Open");
        btnLoad.setToolTipText("Open");
        // Ensure that actionPerformed method of this
        // class receives events from the button
        btnLoad.addActionListener(this);

        btnPrint = new JButton("Print");
        btnPrint.setToolTipText("Print");
        btnPrint.addActionListener(this);

        btnFirstPage = new JButton("<<");
        btnFirstPage.setToolTipText("First Page");
        btnFirstPage.addActionListener(this);

        btnPreviousPage = new JButton("<");
        btnPreviousPage.setToolTipText("Previous Page");
        btnPreviousPage.addActionListener(this);

        btnNextPage = new JButton(">");
        btnNextPage.setToolTipText("Next Page");
        btnNextPage.addActionListener(this);

        btnLastPage = new JButton(">>");
        btnLastPage.setToolTipText("Last Page");
        btnLastPage.addActionListener(this);

        btnClose = new JButton("Close");
        btnClose.setToolTipText("Close");
        btnClose.addActionListener(this);

        lblCurrentPageNum = new JLabel();

        // Add items to toolbar
        topToolbar.add(btnLoad);
        topToolbar.add(btnPrint);
        topToolbar.add(btnClose);
        topToolbar.add(btnFirstPage);
        topToolbar.add(btnPreviousPage);
        topToolbar.add(btnNextPage);
        topToolbar.add(btnLastPage);
        topToolbar.add(lblCurrentPageNum);

        return topToolbar;
    }

    // This method processes events sent by
    // buttons on the toolbar.
    // This method is from the ActionListener
    // interface implemented by this class
    public void actionPerformed(ActionEvent ae)
    {
        Object sourceButton = ae.getSource();

        try
        {
            if (ae.getSource() == btnLoad)
            {
                loadFile();
            }
            else if (ae.getSource() == btnPrint)
            {
                printFile();
            }
            else if (sourceButton == btnFirstPage)
            {
                viewFirstPage();
            }
            else if (sourceButton == btnPreviousPage)
            {
                viewPreviousPage();
            }
            else if (sourceButton == btnNextPage)
            {
                viewNextPage();
            }
            else if (sourceButton == btnLastPage)
            {
                viewLastPage();
            }
            else if (sourceButton == btnClose)
            {
                closeFile();
            }
        }
        catch (PdfException pdfEx)
        {
            JOptionPane.showMessageDialog(this.getParent(), pdfEx
                .getMessage(), "Gnostice PDF Viewer",
                JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ioEx)
        {
            JOptionPane.showMessageDialog(this.getParent(), ioEx
                .getMessage(), "Gnostice PDF Viewer",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Display the first page of the document
    private void viewFirstPage() throws IOException, PdfException
    {
        viewer.firstPage();
        updatePageNumberLabel(viewer.getCurrentPage());
    }

    // Display the previous page of the document
    private void viewPreviousPage() throws IOException, PdfException
    {
        viewer.previousPage();
        updatePageNumberLabel(viewer.getCurrentPage());
    }

    // Display the next page of the document
    private void viewNextPage() throws IOException, PdfException
    {
        viewer.nextPage();
        updatePageNumberLabel(viewer.getCurrentPage());
    }

    // Display the last page of the document
    private void viewLastPage() throws IOException, PdfException
    {
        viewer.lastPage();
        updatePageNumberLabel(viewer.getCurrentPage());
    }

    // Update label with number of current page
    private void updatePageNumberLabel(int pageNum)
    {
        if (pageNum == 0)
        {
            lblCurrentPageNum.setText("");
        }
        else
        {
            lblCurrentPageNum.setText("Showing Page "
                + String.valueOf(pageNum) + " of "
                + String.valueOf(viewer.getPageCount()));
        }
    }

    // Use a prompt to obtain document password from the user
    public String onPassword(PdfDocument d, boolean[] flags)
    {
        JPanel panel = new JPanel(new FlowLayout());

        JPasswordField field = new JPasswordField(10);
        panel.add(new JLabel("Password: "));
        panel.add(field);

        field.requestFocus();

        JOptionPane.showMessageDialog(this, panel,
            "Gnostice PDF Viewer", JOptionPane.OK_OPTION
                | JOptionPane.QUESTION_MESSAGE);

        String pwd = "";

        char[] pin = field.getPassword();
        try
        {
            pwd = new String(pin);
        }
        finally
        {
            Arrays.fill(pin, ' ');
            field.setText("");
        }

        return pwd;
    }

    // Display a PDF document in the viewer
    protected void loadFile()
    {
        int fcState = fc.showOpenDialog(this);

        // Exit if a file has not been selected succesfully
        if (fcState != JFileChooser.APPROVE_OPTION)
        {
            return;
        }

        File selectedFile = fc.getSelectedFile();

        // Exit if it is not a valid file
        if ( !(selectedFile.exists() && selectedFile.isFile()))
        {
            JOptionPane.showMessageDialog(this, "The File \""
                + selectedFile.getAbsoluteFile()
                + "\" does not exist", "Gnostice PDF Viewer",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove the display of any other document
        closeFile();

        docPath = selectedFile.getAbsolutePath();
        setTitle(selectedFile.getName() + " - Gnostice PDF Viewer");

        try
        {
            // Load the PDF in the document object 
            d.load(docPath);
            
            // calling refresh() method on the viewer is optionally as
            // it will be refreshed automatically the document is
            // associated with the viewer using setDocument() method
//            viewer.refresh();
            
            // Update label with number of current page
            updatePageNumberLabel(viewer.getCurrentPage());
        }
        catch (PdfException pdfEx)
        {
            JOptionPane.showMessageDialog(this, pdfEx.getMessage(),
                "Gnostice PDF Viewer", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ioEx)
        {
            JOptionPane.showMessageDialog(this, ioEx.getMessage(),
                "Gnostice PDF Viewer", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Print the displayed document
    protected void printFile() throws IOException, PdfException
    {
        if (d != null && d.isLoaded())
        {
            if (pdfPrinter != null)
            {
                // Obtain print preference from user and
                // print document accordingly
                pdfPrinter.showPrintDialog(this, true);
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                    "Could not create PdfPrinter object",
                    "PdfPrinter object creation failed",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,
                "Document not loaded, Load a PDF Document to Print",
                "Gnostice PDF Viewer", JOptionPane.ERROR_MESSAGE);
            loadFile();
        }
    }

    // Remove the display of any document in viewer and
    // dispose close any I/O streams associated with
    // the document reader
    protected void closeFile()
    {
        lblCurrentPageNum.setText("");
        setTitle("Gnostice PDF Viewer");

        if (d != null && d.isLoaded())
        {
            try
            {
                // this will automatically dispose the objects
                // associated with the viewer and printer object
                d.close();
            }
            catch (Exception ioEx)
            {
                JOptionPane.showMessageDialog(this,
                    ioEx.getMessage(), "Gnostice PDF Viewer",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}