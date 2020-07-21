package com.usthb.dessin;

// Packages to import 
import java.awt.Color;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import com.usthb.EUREKA;

public class LJoueursInscr {
	// frame
	static JFrame WListJoueurs;
	private JLabel logo;
	private JLabel lbtext;
	private JScrollPane sp;
	private static String[][] Joueurs = new String[100][5];

	private JTable TabJoueurs;

	// Constructor
	LJoueursInscr() {
		// Preparie la liste des Jouers
		EUREKA.AfficherInfosJoueursInscrits();
		// Frame initiallization
		WListJoueurs = new JFrame();
		WListJoueurs.setTitle("EUREKA | LISTE JOUEURS"); // metre de titre
		WListJoueurs.getContentPane().setBackground(new Color(16, 22, 47)); // changae la color de la fentre
		WListJoueurs.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));

		logo = new JLabel(new ImageIcon("Resource/logo2.png")); // instancie le logo de la Fentre
		logo.setBounds(0, 189, 665, -189);

		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // change le coursor de mouse
		logo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // metre le changment de oriantation
		WListJoueurs.getContentPane().setLayout(null);

		lbtext = new JLabel("List des Joueurs Inscrits"); // text
		lbtext.setBounds(0, 0, 0, 0);
		lbtext.setFont(new Font("Tahoma", Font.BOLD, 17)); // paramettre Font
		lbtext.setForeground(new Color(252, 104, 16));
		WListJoueurs.getContentPane().add(lbtext); // ajoutele text a panael
		WListJoueurs.getContentPane().add(logo); // ajoute le panel a panael
		// Data to be displayed in the JTable

		// Column Names
		String[] columnNames = { "NOM", "PRENOM", "DateNe", "TYPE", "SCORE" };

		// Initializing the JTable
		TabJoueurs = new JTable(Joueurs, columnNames); // cree un tableau avec des coloumn
		TabJoueurs.setEnabled(false); // desaible editing valeurs column
		TabJoueurs.setBackground(new Color(135, 206, 250));
		TabJoueurs.setCellSelectionEnabled(true);
		TabJoueurs.setColumnSelectionAllowed(true);
		TabJoueurs.setFillsViewportHeight(true);
		TabJoueurs.setBounds(30, 40, 900, 300);

		// adding it to JScrollPane
		sp = new JScrollPane(TabJoueurs);
		sp.setBounds(28, 193, 606, 215);
		WListJoueurs.getContentPane().add(sp);
		JButton btnGoHome = new JButton("Revenir");
		btnGoHome.setBounds(220, 448, 229, 43);
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Bienvenu win = new Bienvenu();
				Bienvenu.eureka_bienvenu.setVisible(true);
				LJoueursInscr.WListJoueurs.setVisible(false);

			}
		});
		btnGoHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoHome.setBackground(new Color(255, 193, 7));
		WListJoueurs.getContentPane().add(btnGoHome);

		logo.setBounds(14, 11, 606, 134);
		lbtext.setBounds(211, 150, 227, 43);
		// Frame Size
		WListJoueurs.setSize(673, 553);
		WListJoueurs.setResizable(false);
		// set le window en millieu de screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WListJoueurs.setLocation((int) screenSize.getWidth() / 2 - WListJoueurs.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - WListJoueurs.getHeight() / 2); // mete la location

		WListJoueurs.setVisible(true);

	}

	public static void setJoueurs(String[][] joueurs) {
		Joueurs = joueurs;
	}

}
