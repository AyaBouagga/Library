package Inscription;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Inscription.DescripBookforsearch;
import Inscription.SearchPage;

public class Test {

    public static void main(String[]args) {
        JFrame frame = new JFrame();
        SearchPage panel = new SearchPage();
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));
        panel.panel_2.add(new DescripBookforsearch(1,"", "jj", "","", 10, 2));

        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
}}
