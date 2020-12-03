package Test;



import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class MoteurRecherche extends JFrame implements ActionListener {
    private String currentSrc;
    private String strEnginez[] = {"Google Search", "Google Images", 
        "Yahoo Search", "Yahoo Images", "AltaVista Search",
        "AltaVista Images", "AltaVista MP3/Audio", "AltaVista Video" };
    private String urlEnginez[] = {
        "http://www.google.com/search?q=", // Google Search
        "http://www.google.com/images?q=", // Google Images
        "http://search.yahoo.com/search?p=", // Yahoo! Search
        "http://images.search.yahoo.com/search/images?p=", // Yahoo! Images
        "http://www.altavista.com/web/results?q=", // AltaVista Search
        "http://www.altavista.com/image/results?q=", // AltaVista Images
        "http://www.altavista.com/audio/results?q=", // AltaVista MP3/Audio
        "http://www.altavista.com/video/results?q=" }; // AltaVista Video
    private String strProg[] = { "Java FR", "Codes-Sources" };
    private String urlProg[] = {
        "http://www.javafr.com/gma/tout/", // Java FR
        "http://www.codes-sources.com/gma/tout/" }; // Codes-Sources
    private String strGamez[] = { "JeuxVideo.com", "Gamez.com" };
    private String urlGamez[] = {
        "http://www.jeuxvideo.com/schr.htm?textfield=", // JeuxVideo.com
        "http://filefan.com/sage/games.x?p=&ogs=&process=+Search+&k=" }; // Gamez.com
    private String strDlz[] = { "ZDNet", "FilePlanet" };
    private String urlDlz[] = {
        "http://downloads-zdnet.com.com/3120-20-0.html?qt=", // ZDNet
        "http://www.fileplanet.com/search.aspx?q=" }; // FilePlanet
    private JRadioButtonMenuItem[] MI_ENGINEZ, MI_PROG, MI_GAMEZ, MI_DLZ;
    private JTextField txKeywords;
    private JButton btnSearch;

    public MoteurRecherche() {
        super.setTitle(":: Moteur de recherche ::");
        JMenuBar barre = new JMenuBar();

        // Menu 1: [ À partir de... ]
        JMenu M_FROM = new JMenu("À partir de...");
        ButtonGroup group = new ButtonGroup();

        // Sous-menu 1: [ Moteurs ]
        JMenu SM_MTR = new JMenu("Moteurs");
        MI_ENGINEZ = new JRadioButtonMenuItem[strEnginez.length];
            // création des options du sous-menu «Moteurs»
        for (int i = 0; i < strEnginez.length; i++) {
            MI_ENGINEZ[i] = new JRadioButtonMenuItem(strEnginez[i]);
            MI_ENGINEZ[i].addActionListener(this);
            group.add(MI_ENGINEZ[i]);
            SM_MTR.add(MI_ENGINEZ[i]);
        }
        currentSrc = strEnginez[0]; // Assigne à "currentSrc" une valeur par défaut
        MI_ENGINEZ[0].setSelected(true); // Selectionne une option par défaut
        M_FROM.add(SM_MTR);

        // Sous-menu 2: [ Programmation ]
        JMenu SM_PRG = new JMenu("Programmation");
        MI_PROG = new JRadioButtonMenuItem[strProg.length];
            // Création des options du sous-menu «Programmation»
        for (int i = 0; i < strProg.length; i++) {
            MI_PROG[i] = new JRadioButtonMenuItem(strProg[i]);
            MI_PROG[i].addActionListener(this);
            group.add(MI_PROG[i]);
            SM_PRG.add(MI_PROG[i]);
        }
        M_FROM.add(SM_PRG);

        // Sous-menu 3: [ Jeux ]
        JMenu SM_GZ = new JMenu("Jeux");
        MI_GAMEZ = new JRadioButtonMenuItem[strGamez.length];
        for (int i = 0; i < strGamez.length; i++) {
            MI_GAMEZ[i] = new JRadioButtonMenuItem(strGamez[i]);
            MI_GAMEZ[i].addActionListener(this);
            group.add(MI_GAMEZ[i]);
            SM_GZ.add(MI_GAMEZ[i]);
        }
        M_FROM.add(SM_GZ);

        // Sous-menu 4: [ Téléchargements ]
        JMenu SM_DL = new JMenu("Téléchargements");
        MI_DLZ = new JRadioButtonMenuItem[strDlz.length];
        for (int i = 0; i < strDlz.length; i++) {
            MI_DLZ[i] = new JRadioButtonMenuItem(strDlz[i]);
            MI_DLZ[i].addActionListener(this);
            group.add(MI_DLZ[i]);
            SM_DL.add(MI_DLZ[i]);
        }
        M_FROM.add(SM_DL);
        barre.add(M_FROM);

        // Assigne "barre" comme barre de menus
        setJMenuBar(barre);

        Container c = getContentPane();

        // Panneau d'affichage (au centre)
      
        // Panneau de recherche (en bas)
        JPanel p = new JPanel();
        p.setLayout( new FlowLayout(FlowLayout.CENTER) );

        txKeywords = new JTextField(15);
        p.add(txKeywords);

        btnSearch = new JButton("Rechercher");
        btnSearch.addActionListener(this);
        p.add(btnSearch);
        c.add(p, BorderLayout.SOUTH);

        // Récupérer la résolution de l'écran (hauteur)
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = d.getSize().height;

        setSize(300, 125);
        setResizable(false);
        setLocation(0, screenHeight - 152);
        show();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}