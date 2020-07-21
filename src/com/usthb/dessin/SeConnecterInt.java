package com.usthb.dessin;

import com.usthb.EUREKA;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

import com.usthb.modeles.Adulte;
import com.usthb.modeles.Enfant;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;

public class SeConnecterInt {

	public JFrame wn_seconnect;

	public SeConnecterInt() {

		wn_seconnect = new JFrame();
		wn_seconnect.setTitle("EUREKA : Se Connect");
		wn_seconnect.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));
		wn_seconnect.getContentPane().setBackground(new Color(16, 22, 47)); // metre le bagrouand color
		wn_seconnect.setBounds(100, 100, 1000, 700);
		wn_seconnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wn_seconnect.getContentPane().setLayout(null);

		// set le window en millieu de screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		wn_seconnect.setLocation((int) screenSize.getWidth() / 2 - wn_seconnect.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - wn_seconnect.getHeight() / 2); // mete la location

		JPanel PanelComp_cn = new JPanel();
		PanelComp_cn.setBorder(
				(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption)));
		PanelComp_cn.setForeground(new Color(0, 0, 0));
		PanelComp_cn.setBackground(new Color(20, 30, 59));
		PanelComp_cn.setBounds(317, 199, 352, 405);
		wn_seconnect.getContentPane().add(PanelComp_cn);
		PanelComp_cn.setLayout(null);

		JLabel textConnexion = new JLabel("Connexion");
		textConnexion.setForeground(new Color(255, 255, 255));
		textConnexion.setFont(new Font("Times New Roman", Font.BOLD, 29));
		textConnexion.setBounds(107, 39, 153, 58);
		PanelComp_cn.add(textConnexion);

		JTextField textnomFcnx = new JTextField();
		textnomFcnx.setBorder(UIManager.getBorder("TextField.border"));
		textnomFcnx.setForeground(new Color(0, 0, 0));
		textnomFcnx.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textnomFcnx.setBackground(new Color(192, 192, 192));
		textnomFcnx.setBounds(62, 128, 231, 35);
		PanelComp_cn.add(textnomFcnx);
		textnomFcnx.setColumns(10);

		JPasswordField textpasswordFcn = new JPasswordField();
		textpasswordFcn.setBorder(UIManager.getBorder("PasswordField.border"));
		textpasswordFcn.setForeground(new Color(0, 0, 0));
		textpasswordFcn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textpasswordFcn.setBackground(new Color(192, 192, 192));
		textpasswordFcn.setBounds(62, 193, 231, 35);
		PanelComp_cn.add(textpasswordFcn);

		JLabel textnom = new JLabel("NOM");
		textnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textnom.setForeground(new Color(255, 255, 255));
		textnom.setBounds(62, 108, 46, 14);
		PanelComp_cn.add(textnom);

		JLabel textmotdepass = new JLabel("Mot de Passe");
		textmotdepass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textmotdepass.setForeground(Color.WHITE);
		textmotdepass.setBounds(62, 174, 84, 14);
		PanelComp_cn.add(textmotdepass);

		JButton btnsinscri_cn = new JButton("Inscription");
		btnsinscri_cn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				InscriptionInt window = new InscriptionInt();
				wn_seconnect.setVisible(false);
				window.wn_Inscription.setVisible(true);
			}
		});
		btnsinscri_cn.setBorder(UIManager.getBorder("Button.border"));
		btnsinscri_cn.setBackground(new Color(255, 215, 0));
		btnsinscri_cn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnsinscri_cn.setBounds(62, 354, 231, 29);
		PanelComp_cn.add(btnsinscri_cn);

		JLabel textjobliinfo = new JLabel("Informations de compte oubliees ?");
		textjobliinfo.setForeground(Color.WHITE);
		textjobliinfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textjobliinfo.setBounds(62, 231, 198, 14);
		PanelComp_cn.add(textjobliinfo);

		JSeparator br = new JSeparator();
		br.setBackground(new Color(255, 255, 0));
		br.setForeground(new Color(255, 255, 0));
		br.setBounds(62, 341, 231, 2);
		PanelComp_cn.add(br);

		JButton btnseconnect = new JButton("Se Connecter");
		btnseconnect.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent cnnx) {

				Boolean JoueurExiste = false;
				// le cas de un au plusieurs champ sont vide
				if (textnomFcnx.getText().equals("") && textpasswordFcn.getText().equals("")
						|| textnomFcnx.getText().equals("") || textpasswordFcn.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "S'il vous plait Donnez tous les information",
							"EUREKA Inscription", JOptionPane.WARNING_MESSAGE);

				} else { // le cas de validation des champ

					// Cherche le Jouer dans le Dictionaire Jouers
					Joueur joueur = null;
					for (Joueur j : EUREKA.DicJoueur.values()) {
						if (j.getNom().equals(textnomFcnx.getText())
								&& j.getMotDePasse().equals(textpasswordFcn.getText())) {
							// Jouer Existe
							JoueurExiste = true;
							joueur = j;
							break;
						}
					}
					// Trite le cas de Jouer existe
					if (JoueurExiste == true) {
						// Here we make setting of Scoore and the nivaux
						LinkedList<PartieJeu> L = new LinkedList<PartieJeu>();
						L.addAll(joueur.getListPartie());
						// LE Cas de Affiche un Fentre Pour CHoiser un Theme
						// Quand elle n'est Jouer pas ou que elle termine un Theme
						// un Theme Contier 25 Partie Jeu danc c un multiple de 25

						if (L.isEmpty() || L.getLast().isPartieTermine() == true
								&& L.getLast().NbParte(joueur.getListPartie()) % 25 == 0) {
							// Le Cas d'un Novelle Jouer ou Elle Termine Tous Les Partie d'un theme

							JOptionPane.showMessageDialog(null, "Bienvenu " + textnomFcnx.getText()
									+ " sur EUREKA \n\nOn vous souhaite une bonne partie");
							LocalDate l = LocalDate.now();
							int age = l.getYear() - (joueur.getDateDeNaissance().getYear() + 1900);

							if (age >= 18) {// Lancer la fentre des themes
								SelectThemeInt window = new SelectThemeInt(new Adulte(joueur.getNom(),
										joueur.getPrenom(), joueur.getDateDeNaissance(), joueur.getMotDePasse(),
										joueur.getNumerojouer(), joueur.getDernierNiveau(), joueur.getListPartie()));
								wn_seconnect.setVisible(false);
								window.wn_choisetheme.setVisible(true);
							} else {
								SelectThemeInt window = new SelectThemeInt(new Enfant(joueur.getNom(),
										joueur.getPrenom(), joueur.getDateDeNaissance(), joueur.getMotDePasse(),
										joueur.getNumerojouer(), joueur.getDernierNiveau(), joueur.getListPartie()));
								wn_seconnect.setVisible(false);
								window.wn_choisetheme.setVisible(true);

							}
						} else {

							if (!L.getLast().isPartieTermine()) {
								wn_seconnect.setVisible(false);
								try {
									// appel Pour Instance la Dernier Partie Qui Pas Complite
									joueur.Jouer(L.getLast().getThemeSelect());

								} catch (Exception prob) {

									JOptionPane.showMessageDialog(null, "Error Instance La Dernier Partie",
											"EURKA | ALTER", JOptionPane.ERROR_MESSAGE);
								}
							}
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Votre nom ou votre mot de passe n'est pas correct \nEssayez une autre fois \n Si vous n'avez pas d'un compte, vous pouvez  Inscri maintenant",
								"EURKA | ALTER", JOptionPane.WARNING_MESSAGE);
					}

				}
			}
		});

		btnseconnect.setBorder(UIManager.getBorder("Button.border"));
		btnseconnect.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnseconnect.setBackground(Color.ORANGE);
		btnseconnect.setBounds(62, 262, 231, 29);
		PanelComp_cn.add(btnseconnect);

		JButton btnCannel = new JButton("Cancel");
		btnCannel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Bienvenu window = new Bienvenu();
				wn_seconnect.setVisible(false);
				window.eureka_bienvenu.setVisible(true);
			}
		});

		btnCannel.setBorder(UIManager.getBorder("Button.border"));
		btnCannel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCannel.setBackground(Color.ORANGE);
		btnCannel.setBounds(62, 302, 231, 29);
		PanelComp_cn.add(btnCannel);
		wn_seconnect.setResizable(false);

		// add image
		JLabel imglogo = new JLabel(new ImageIcon("Resource/logo2.png"));
		imglogo.setBounds(252, 0, 466, 201);
		wn_seconnect.getContentPane().add(imglogo);
	}
}
