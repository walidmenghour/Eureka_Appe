package com.usthb.dessin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import com.usthb.EUREKA;
import com.usthb.modeles.Adulte;
import com.usthb.modeles.Enfant;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;

public class InscriptionInt {
	public JFrame wn_Inscription;

	public InscriptionInt() {

		wn_Inscription = new JFrame(); // Declaration
		wn_Inscription.setTitle("EUREKA | Inscription"); // mete le titre
		wn_Inscription.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png")); // le logo image
		wn_Inscription.getContentPane().setBackground(new Color(16, 22, 47)); // metre la color de window
		wn_Inscription.setResizable(false);
		// le size de la window
		wn_Inscription.setBounds(100, 100, 1000, 700);
		wn_Inscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wn_Inscription.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		wn_Inscription.setLocation((int) screenSize.getWidth() / 2 - wn_Inscription.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - wn_Inscription.getHeight() / 2); // mete la location

		// le Logo
		JLabel imgLabel = new JLabel(new ImageIcon("Resource/logo2.png"));
		imgLabel.setBounds(254, 0, 466, 201);
		wn_Inscription.getContentPane().add(imgLabel);

		JPanel PanelCom_In = new JPanel();
		PanelCom_In
				.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption));
		PanelCom_In.setForeground(new Color(0, 0, 0));
		PanelCom_In.setBackground(new Color(20, 30, 59));
		PanelCom_In.setBounds(316, 202, 352, 431);
		wn_Inscription.getContentPane().add(PanelCom_In);
		PanelCom_In.setLayout(null);

		// le Text Inscription come titre de la panel
		JLabel lbInscription = new JLabel("Inscription"); // Declaration
		lbInscription.setForeground(new Color(255, 255, 255)); // color
		lbInscription.setFont(new Font("Times New Roman", Font.BOLD, 29)); // font
		lbInscription.setBounds(107, 26, 153, 58); // bordre
		PanelCom_In.add(lbInscription); // ajoute a panel

		// lable de text Nom
		JLabel lbtextnom = new JLabel("NOM");
		lbtextnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtextnom.setForeground(new Color(255, 255, 255));
		lbtextnom.setBounds(62, 84, 46, 14);
		PanelCom_In.add(lbtextnom);

		// le filed ou l utilisateur entre le nom
		JTextField textnomFIn = new JTextField();
		textnomFIn.setBorder(UIManager.getBorder("TextField.border"));
		textnomFIn.setForeground(new Color(0, 0, 0));
		textnomFIn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textnomFIn.setBackground(UIManager.getColor("Button.background"));
		textnomFIn.setBounds(62, 104, 231, 35);
		PanelCom_In.add(textnomFIn);
		textnomFIn.setColumns(10);

		// le text prenom ou elle saize le prenom
		JTextField textFiprenom = new JTextField();
		textFiprenom.setForeground(Color.BLACK);
		textFiprenom.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textFiprenom.setColumns(10);
		textFiprenom.setBorder(UIManager.getBorder("TextField.border"));
		textFiprenom.setBackground(SystemColor.menu);
		textFiprenom.setBounds(62, 170, 231, 35);
		PanelCom_In.add(textFiprenom);

		JLabel lbtextprenom = new JLabel("Prenom");
		lbtextprenom.setForeground(Color.WHITE);
		lbtextprenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtextprenom.setBounds(62, 150, 46, 14);
		PanelCom_In.add(lbtextprenom);

		// labale de texte mot de passe
		JLabel lbtextmotdepass = new JLabel("Mot de Passe");
		lbtextmotdepass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtextmotdepass.setForeground(Color.WHITE);
		lbtextmotdepass.setBounds(62, 214, 84, 14);
		PanelCom_In.add(lbtextmotdepass);

		// field ou l utilisateur a entre le mot de passe
		JPasswordField textpasswordFIn = new JPasswordField();
		textpasswordFIn.setBorder(UIManager.getBorder("TextField.border"));
		textpasswordFIn.setForeground(new Color(0, 0, 0));
		textpasswordFIn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textpasswordFIn.setBackground(UIManager.getColor("Button.background"));
		textpasswordFIn.setBounds(62, 233, 231, 35);
		PanelCom_In.add(textpasswordFIn);

		// lable de text date de naissance
		JLabel lbdatene = new JLabel("Date de Naissance");
		lbdatene.setForeground(Color.WHITE);
		lbdatene.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbdatene.setBounds(62, 279, 138, 14);
		PanelCom_In.add(lbdatene);

		// le champ de choisire la date de nissance
		JDateChooser DatedeneIn = new JDateChooser();
		DatedeneIn.setBackground(SystemColor.inactiveCaption);
		DatedeneIn.setBounds(62, 296, 231, 29);
		PanelCom_In.add(DatedeneIn);

		JButton btnsinscri_ = new JButton("Inscription");
		btnsinscri_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Joueur joueur;
				// pour get courrant annes
				LocalDate l = LocalDate.now();

				
				if (textnomFIn.getText().equals("") || textpasswordFIn.getText().equals("")
						|| textFiprenom.getText().equals("") || DatedeneIn.getDate().toLocaleString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "S'il vous plait Donnez tous les information",
							"EUREKA Inscription", JOptionPane.WARNING_MESSAGE);

					// ici on traite le cas de date superieur ou eqala la data courant
				} else {
					// elle est pas existe en vas ajoute a la liste des jouers
					// Calule l'age de le Joueur Inscri
					boolean JoueurExiste = false;
					
					for (Joueur j : EUREKA.DicJoueur.values()) {
						if (j.getNom().equals(textnomFIn.getText()) && j.getPrenom().equals(textFiprenom.getText())
								&& j.getDateDeNaissance().equals(DatedeneIn.getDate())) {
						

							JoueurExiste = true;
							joueur = j;
							break;
						}
					}
					if (JoueurExiste) {
						JOptionPane.showMessageDialog(null,
								"Vous avez un compte deja !!\n Essyez de Connecter directement");

					} else {
						int age = l.getYear() - (DatedeneIn.getDate().getYear() + 1900);
						try {
							// ici en inisialise le numero sequential de Joueur(le dernier)
						      //
							Joueur.numSeq = EUREKA.DicJoueur.size();
							
							LinkedList<PartieJeu> List = new LinkedList<PartieJeu>();
							if (age >= 18) {
								joueur = new Adulte(textnomFIn.getText(), textFiprenom.getText(), DatedeneIn.getDate(),
										textpasswordFIn.getText(), 1, List);

							} else {
								if (age > 0) {
									joueur = new Enfant(textnomFIn.getText(), textFiprenom.getText(),
											DatedeneIn.getDate(), textpasswordFIn.getText(), 1, List);
								} else {
									JOptionPane.showMessageDialog(null, "Oops !\n Votre date de naissance"
											+ " n'est pas correct ! Essyez d'inscrire une autre fois!");
									joueur = null;
								}
							}

							if (joueur != null) {

								EUREKA.DicJoueur.put(joueur.getNumerojouer(), joueur);

								FileOutputStream f = new FileOutputStream(new File("Resource/Joueurs.txt"));
								ObjectOutputStream o = new ObjectOutputStream(f);
								// ici elle ecrasi le fichier par un nouvaux info
								o.writeObject(EUREKA.DicJoueur);

								f.close();
								o.close();

								// AFFICHE LES INFORMTION :
								JOptionPane.showMessageDialog(null,
										"Bon " + textnomFIn.getText().toUpperCase()
												+ " +\nvotre compte dans Eureka a ete cree ",
										"EUREKA | Inscription", JOptionPane.PLAIN_MESSAGE);

								// Afficher la Fenetre de Connextion
								SeConnecterInt window = new SeConnecterInt();
								wn_Inscription.setVisible(false);
								window.wn_seconnect.setVisible(true);
							}
						} catch (FileNotFoundException fnf) {
							fnf.getMessage();
						} catch (IOException ioe) {
							JOptionPane.showMessageDialog(null, "Opss !\n SVp essay enrigistre autre fois ",
									"EURKA | ALTER", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		btnsinscri_.setBorder(UIManager.getBorder("Button.border"));
		btnsinscri_.setBackground(new Color(255, 215, 0));
		btnsinscri_.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsinscri_.setBounds(62, 336, 231, 29);
		PanelCom_In.add(btnsinscri_);

		// button cannel l inscription
		JButton btncannein_ = new JButton("Cancel");
		btncannein_.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btncannein_.setBorder(UIManager.getBorder("Button.border"));
		btncannein_.setBackground(new Color(255, 215, 0));
		btncannein_.setBounds(62, 376, 231, 29);
		PanelCom_In.add(btncannein_);
		btncannein_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wn_Inscription.setVisible(false);
				Bienvenu.eureka_bienvenu.setVisible(true);
			}
		});
	}
}
