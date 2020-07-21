package com.usthb.dessin;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;

public class Apropose {

	static JFrame wApropose;

	public Apropose() {

		// Instancie la fenetre
		wApropose = new JFrame();
		wApropose.setTitle("EUREKA | A propose"); // le titr de la fentre
		wApropose.setBounds(100, 100, 605, 526); // size de fentre et location
		wApropose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pour le sortie
		wApropose.getContentPane().setBackground(new Color(16, 22, 47)); // changae la color de la fentre
		wApropose.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));

		wApropose.getContentPane().setLayout(null);

		// Instance les composant
		JLabel logo = new JLabel(new ImageIcon("Resource/logo2.png")); // instancie le logo de la Fentre
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // change le coursor de mouse
		logo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // metre le changment de oriantation

		JLabel lbtextappropose = new JLabel("# A Propos de l'Application"); // text
		JLabel lbdatecree = new JLabel("L'application Eureka a ete cree en avril 2020\r\n"); // text
		JLabel lbtxtdeuxdev = new JLabel("Les deux devlopers : \r\n");// text
		JLabel lbtxtwalid = new JLabel(
				"[+] Walid Menghour :  Je Suis Un Etudiant , Web Devaloper et Graphique Desinger \r\n");
		// text
		JLabel lbtxtwalidin = new JLabel("Interesse dans les Deux Domaine Data science et Cybersecurity\r\n"); // paramettre
																												// Font
		JLabel lbtxtnoory = new JLabel("[+] Noureddine ABB HAMOU :  Je Suis Un Etudiant , Font-End Web Developer \r\n");
		// text
		JLabel lbtxtnooryin = new JLabel("Interesse a AI "); // text
		JLabel lbversion = new JLabel("# Version 1.3");

		JButton btnGoHome = new JButton("Revenir");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Bienvenu win = new Bienvenu();
				Bienvenu.eureka_bienvenu.setVisible(true);
				Apropose.wApropose.setVisible(false);

			}
		});
		// instancie un var font
		Font fnormal = new Font("Tahoma", Font.PLAIN, 14);// // paramettre Font
		// parametre des font
		lbtextappropose.setFont(new Font("Tahoma", Font.BOLD, 17)); // paramettre Font
		lbdatecree.setFont(fnormal);
		lbtxtdeuxdev.setFont(fnormal);
		lbtxtwalid.setFont(fnormal);
		lbtxtwalidin.setFont(fnormal);
		lbtxtnoory.setFont(fnormal);
		lbtxtnooryin.setFont(fnormal);
		lbversion.setFont(new Font("Tahoma", Font.BOLD, 14));// // paramettre Font
		btnGoHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		Color cnorml = new Color(0, 204, 151);
		Color cspic = new Color(252, 104, 16);

		// Color des Text (J'ai utilise le code RGB, et les colors predefine dans swing)
		lbtextappropose.setForeground(cspic);
		lbdatecree.setForeground(cnorml);
		lbtxtdeuxdev.setForeground(cnorml);
		lbtxtwalid.setForeground(cnorml);
		lbtxtwalidin.setForeground(cnorml);
		lbtxtnoory.setForeground(cnorml);
		lbtxtnooryin.setForeground(cnorml);
		lbversion.setForeground(cspic);

		btnGoHome.setBackground(new Color(255, 193, 7));

		// paramatre des location et size
		logo.setBounds(0, 0, 606, 134);
		lbtextappropose.setBounds(10, 157, 269, 43);
		lbdatecree.setBounds(20, 189, 650, 55);
		lbtxtdeuxdev.setBounds(30, 223, 629, 43);
		lbtxtwalid.setBounds(66, 249, 604, 43);
		lbtxtwalidin.setBounds(183, 266, 486, 55);
		lbtxtnoory.setBounds(66, 298, 594, 43);
		lbtxtnooryin.setBounds(225, 321, 445, 36);
		lbversion.setBounds(20, 369, 650, 28);

		btnGoHome.setBounds(172, 413, 229, 43);

		// Ajoute les composant Graphique a la fentre
		wApropose.getContentPane().add(logo); // logo
		wApropose.getContentPane().add(lbtextappropose);
		wApropose.getContentPane().add(lbdatecree);
		wApropose.getContentPane().add(lbtxtdeuxdev);
		wApropose.getContentPane().add(lbtxtwalid);
		wApropose.getContentPane().add(lbtxtwalidin);
		wApropose.getContentPane().add(lbtxtnoory);
		wApropose.getContentPane().add(lbtxtnooryin);
		wApropose.getContentPane().add(lbversion);
		// set le window en millieu de screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		wApropose.setLocation((int) screenSize.getWidth() / 2 - wApropose.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - wApropose.getHeight() / 2); // mete la location

		wApropose.setSize(600, 500);
		wApropose.setResizable(false);
		wApropose.getContentPane().add(btnGoHome);

	}

}
