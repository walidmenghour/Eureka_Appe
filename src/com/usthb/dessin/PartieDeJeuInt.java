
package com.usthb.dessin;

import java.util.LinkedList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;

import com.usthb.EUREKA;
import com.usthb.modeles.*;

public class PartieDeJeuInt {

	public static JFrame wn_partjeu;
	private JTextField textFieldcharsize;
	private JTextField textFchiffrment;
	public JTextField textField;
	public static Joueur joueur;
	public static Potence potence;

	// Le constracteur
	public PartieDeJeuInt(Joueur j, LinkedList<Question> List, ThemeType theme) {
		joueur = j;

		// On instancie une partieJeu
		PartieJeu prt = new PartieJeu(List, joueur.getDernierNiveau(), theme);

		// Les composant de la fenetre
		wn_partjeu = new JFrame();
		wn_partjeu.setResizable(false);
		wn_partjeu.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));
		wn_partjeu.setFont(new Font("Consolas", Font.BOLD, 18));
		wn_partjeu.setTitle("EUREKA | Jeu");
		wn_partjeu.getContentPane().setBackground(new Color(20, 30, 59));
		wn_partjeu.setBounds(100, 100, 1430, 700);
		// set le window en millieu de screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		wn_partjeu.setLocation((int) screenSize.getWidth() / 2 - wn_partjeu.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - wn_partjeu.getHeight() / 2); // mete la location
		// Make it Absoulute Positon
		wn_partjeu.getContentPane().setLayout(null);
		// get screen size
		wn_partjeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wn_partjeu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				JOptionPane.showMessageDialog(null, "Nous esp�rons que vous avez appr�ci� le jeu", "EURKA | EXIT",
						JOptionPane.QUESTION_MESSAGE);

				prt.setPartieTermine(false);
				prt.updatePlayer(joueur);
				wn_partjeu.dispose();

				// en peut utilise system.exit(0) pour exite la application directement
				// System.exit(0);

			}
		});

		// Cree nouvau panal pour metre le logo le nom et scoore de joure
		JPanel lbniveaunb = new JPanel();
		lbniveaunb.setBounds(0, 0, 192, 881);
		lbniveaunb.setMinimumSize(new Dimension(100, 100));
		lbniveaunb.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.GRAY, null)); // Metre le Bordre
		lbniveaunb.setBackground(new Color(20, 30, 40));
		wn_partjeu.getContentPane().add(lbniveaunb); // ajout a la window
		lbniveaunb.setLayout(null);

		// Logo
		JLabel lblNewLabel = new JLabel(new ImageIcon("Resource/logop1.png"));// ajout iciResource/logop1.png
		lblNewLabel.setIcon(new ImageIcon("Resource/logop1.png")); // ajout aussi le logo pour le foucse
		lblNewLabel.setBounds(16, 11, 171, 248);
		lbniveaunb.add(lblNewLabel);
		// separateur
		JSeparator separatorlogo_info = new JSeparator();
		separatorlogo_info.setBackground(Color.WHITE);
		separatorlogo_info.setBounds(0, 262, 204, 2);
		lbniveaunb.add(separatorlogo_info);
		// Le lible de joueur
		JLabel lbtextjOURE = new JLabel("Joueur : ");
		lbtextjOURE.setHorizontalAlignment(SwingConstants.CENTER);
		lbtextjOURE.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.GRAY));
		lbtextjOURE.setForeground(Color.WHITE);
		lbtextjOURE.setFont(new Font("Roboto", Font.BOLD, 15));
		lbtextjOURE.setBounds(0, 268, 204, 40);
		lbniveaunb.add(lbtextjOURE);

		// Nom de Joure
		JLabel lbnomjouer = new JLabel(joueur.getPrenom().toUpperCase() + " " + joueur.getNom().toUpperCase());
		lbnomjouer.setHorizontalAlignment(SwingConstants.CENTER);
		lbnomjouer.setForeground(Color.GREEN);
		lbnomjouer.setFont(new Font("Roboto", Font.PLAIN, 14));
		lbnomjouer.setBounds(0, 308, 187, 40);
		lbniveaunb.add(lbnomjouer);

		// Button Disconnect
		JButton btndisconnect = new JButton("Disconnect");
		btndisconnect.setBackground(new Color(71, 71, 135));
		btndisconnect.setForeground(new Color(164, 176, 190));
		btndisconnect.setFont(new Font("Roboto", Font.BOLD, 15));
		btndisconnect.setBounds(29, 608, 131, 40);
		lbniveaunb.add(btndisconnect);

		JLabel lblafniveau = new JLabel(String.valueOf(joueur.getDernierNiveau()));
		lblafniveau.setHorizontalAlignment(SwingConstants.CENTER);
		lblafniveau.setBounds(0, 402, 187, 25);
		lbniveaunb.add(lblafniveau);
		lblafniveau.setForeground(Color.ORANGE);
		lblafniveau.setFont(new Font("Roboto", Font.BOLD, 14));

		JLabel label = new JLabel("Niveau :");
		label.setBounds(0, 359, 192, 40);
		lbniveaunb.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.BOLD, 15));
		label.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.GRAY));

		JLabel label_1 = new JLabel("Score :");
		label_1.setBounds(0, 438, 192, 40);
		lbniveaunb.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Roboto", Font.BOLD, 15));
		label_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.GRAY));

		JLabel lblafscore = new JLabel(String.valueOf(EUREKA.getScoreCourant()));
		lblafscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblafscore.setBounds(0, 486, 187, 25);
		lbniveaunb.add(lblafscore);
		lblafscore.setForeground(Color.ORANGE);
		lblafscore.setFont(new Font("Roboto", Font.BOLD, 14));

		JButton btnChangeTheme = new JButton("ChangeTheme");
		btnChangeTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent chtheme) {
				prt.setPartieTermine(false);
				prt.updatePlayer(joueur);

				SelectThemeInt window = new SelectThemeInt(joueur);
				wn_partjeu.dispose();
				window.wn_choisetheme.setVisible(true);
			}
		});

		btnChangeTheme.setFont(new Font("Roboto", Font.BOLD, 15));
		btnChangeTheme.setBackground(new Color(71, 71, 135));
		btnChangeTheme.setForeground(new Color(164, 176, 190));
		btnChangeTheme.setBounds(29, 552, 131, 40);
		lbniveaunb.add(btnChangeTheme);

		btndisconnect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// arrite la partie
				prt.setPartieTermine(false);
				prt.updatePlayer(joueur);

				wn_partjeu.dispose();
				Bienvenu.eureka_bienvenu.setVisible(true);

			}
		});

		// Le titre Trouve la Reponce
		JLabel lbtexttrouvelareponce = new JLabel("TROUVER LA REPONSE");
		lbtexttrouvelareponce.setBounds(573, 11, 265, 72);
		lbtexttrouvelareponce.setHorizontalAlignment(SwingConstants.CENTER);
		lbtexttrouvelareponce.setBorder(new MatteBorder(1, 2, 8, 2, (Color) new Color(128, 128, 128)));
		lbtexttrouvelareponce.setForeground(Color.WHITE);
		lbtexttrouvelareponce.setFont(new Font("Roboto", Font.BOLD, 21));
		wn_partjeu.getContentPane().add(lbtexttrouvelareponce);

		// le liblle qst
		JLabel textQuestion = new JLabel("La QUESTION : ");
		textQuestion.setBounds(202, 94, 175, 40);
		textQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		textQuestion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), null,
				new Color(128, 128, 128), null));
		textQuestion.setFont(new Font("Roboto", Font.BOLD, 15));
		textQuestion.setForeground(Color.WHITE);

		wn_partjeu.getContentPane().add(textQuestion);
		try {// afficher la qst
			JLabel lblaquestion = new JLabel(prt.getQuestion().getLibelle());
			lblaquestion.setBounds(387, 68, 1027, 114);
			lblaquestion.setForeground(Color.YELLOW);
			lblaquestion.setFont(new Font("Roboto", Font.PLAIN, 14));
			wn_partjeu.getContentPane().add(lblaquestion);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Il n'existe pas des question ");
		}
		// Image de la question

		try {
			JLabel lbImageQues = new JLabel(new ImageIcon("Resource/Img/" + prt.getQuestion().getImage()));
			lbImageQues.setBounds(193, 178, 857, 371);
			wn_partjeu.getContentPane().add(lbImageQues); // ajout a window
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Il n'existe pas des images ");

		}

		JTextField textFieldcharsize = new JTextField();
		textFieldcharsize.setBounds(602, 576, 151, 38);
		textFieldcharsize.setBorder(null);
		textFieldcharsize.setText("");
		textFieldcharsize.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldcharsize.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldcharsize.setBackground(new Color(169, 169, 169));
		wn_partjeu.getContentPane().add(textFieldcharsize);
		textFieldcharsize.setColumns(10);
		textFieldcharsize.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldcharsize.getText().length() >= 1) // limit textfield to 1 characters
					e.consume();
			}
		});

		try {
			// afficher la reponse enCours
			textFchiffrment = new JTextField();
			textFchiffrment.setBounds(601, 622, 341, 38);
			textFchiffrment.setSelectionColor(Color.CYAN);
			textFchiffrment.setForeground(Color.BLUE);
			textFchiffrment.setText(prt.getReponseEnCours().toString());// Quel founction tu fait here
			textFchiffrment.setBorder(null);
			textFchiffrment.setHorizontalAlignment(SwingConstants.CENTER);
			textFchiffrment.setFont(new Font("Roboto", Font.PLAIN, 14));
			textFchiffrment.setBackground(new Color(169, 169, 169));
			textFchiffrment.setColumns(10);
			wn_partjeu.getContentPane().add(textFchiffrment);
			textFchiffrment.setVisible(true);
		} catch (Exception e) {
			e.getStackTrace();
		}
		// La button Valider qui permet de verfier si un cara appartient au reponse
		// Encours
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(767, 573, 175, 42);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// verifier si le caractere correspond a un lettre de la reponse encours
					prt.CheckCaractere((char) textFieldcharsize.getText().charAt(0), joueur);
				} catch (Exception givechar) {
					givechar.printStackTrace();
				}
				textFchiffrment.setText(prt.getReponseEnCours().toString());
				textFieldcharsize.setText("");
				if (prt.getReponseEnCours().toString().equals(prt.getQuestion().getReponse())) {
					PartieDeJeuInt.potence.setTrouve(true);
					prt.PasserNiveau(List, theme);
				}
			}
		});

		btnNewButton.setBackground(Color.ORANGE);
		wn_partjeu.getContentPane().add(btnNewButton);

		// AJOUT LE DESING
		potence = new Potence();
		potence.setBounds(1056, 178, 358, 371);
		wn_partjeu.getContentPane().add(potence);
		potence.setFont(new Font("Roboto", Font.PLAIN, 18));
		potence.setBackground(new Color(0, 153, 102));

		wn_partjeu.setVisible(true);

	}
}
