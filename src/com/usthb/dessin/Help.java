package com.usthb.dessin;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JTextPane;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help {
	static JFrame wHelp;

	public Help() {

		wHelp = new JFrame();
		wHelp.setTitle("EUREKA | Help");
		wHelp.setBounds(100, 100, 627, 698);
		wHelp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wHelp.getContentPane().setBackground(new Color(20, 30, 59));
		wHelp.getContentPane().setLayout(null);
		wHelp.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));

		JLabel logo = new JLabel(new ImageIcon("Resource/logo2.png"));
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		logo.setBounds(0, 0, 606, 123);
		wHelp.getContentPane().add(logo);

		JTextPane txtpnBienvenuSurEureka = new JTextPane();
		txtpnBienvenuSurEureka.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnBienvenuSurEureka.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 193, 7),
				new Color(255, 193, 7), new Color(255, 193, 7), new Color(255, 193, 7)));
		txtpnBienvenuSurEureka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtpnBienvenuSurEureka.setEditable(false);
		txtpnBienvenuSurEureka.setText(
				"  Bienvenu sur eureka \r\n     [1] Apre l'inscription et le choix de le theme qui vous prefaire vous pass a jeu\r\n\t\t\r\n     [2] le jeu a ete compose en 5 nivaux :\r\n    \t    (1) nivaux sur 5 point  \r\n    \t    (2) nivaux sur 10 point \r\n    \t    (3) nivaux sur 18 point\r\n   \t    (4) nivaux sur 28 point\r\n    \t    (5) nivaux sur  40 point \r\n            \r\n       [+] Chaque Nivaux compose d'un ensemble des question avec image ou sans image \r\n\t[+]  Le but de jeu est de trouve la  réponse de la question en tapant des caractères\r\n         \tdans le champ saisie charachter\" et click sur les botton valide la  réponse \r\n\t[+] SI votre caracter  saisie est dans la  réponse alors sera dichiffre le character en zone chiffrement \r\n       \tsinon  echec , une partie d’un dessin de pendu \r\n\t[+] SI dans un questtion vous a vis 8 échecs dessin du pendu est complété .\r\n\t[+] SI vous troue la reponse vous pass a la question suivant .\r\n\t[+] SI vous trouve tous les question d'un partie vous pass a la nivaux suivant.\r\n\t[+] SI vous ressui dans tous les nivaux d'un theme vous pass a un autre theme .\r\n\t\r\n[+] Merci et Bon Courage ");
		txtpnBienvenuSurEureka.setForeground(new Color(235, 223, 252));
		txtpnBienvenuSurEureka.setBackground(new Color(35, 52, 102));
		txtpnBienvenuSurEureka.setBounds(0, 134, 611, 410);
		wHelp.getContentPane().add(txtpnBienvenuSurEureka);

		JButton btnGoHome = new JButton("Revenir");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Bienvenu win = new Bienvenu();
				Bienvenu.eureka_bienvenu.setVisible(true);
				Help.wHelp.setVisible(false);

			}
		});
		btnGoHome.setBackground(new Color(255, 193, 7));
		btnGoHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoHome.setBounds(192, 580, 229, 43);
		btnGoHome.setBackground(new Color(255, 193, 7));
		// Frame Size
		wHelp.setSize(620, 700);
		wHelp.setResizable(false);
		wHelp.getContentPane().add(btnGoHome);
		// set le window en millieu de screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		wHelp.setLocation((int) screenSize.getWidth() / 2 - wHelp.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - wHelp.getHeight() / 2); // mete la location
	}
}
