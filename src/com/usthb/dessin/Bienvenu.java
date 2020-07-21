package com.usthb.dessin;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.usthb.EUREKA;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Bienvenu {
	public static JFrame eureka_bienvenu;

	public Bienvenu() {
		eureka_bienvenu = new JFrame();
		eureka_bienvenu.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));
		eureka_bienvenu.setTitle("EUREKA | Bienvenu");
		eureka_bienvenu.getContentPane().setBackground(new Color(16, 22, 47));
		eureka_bienvenu.setResizable(false);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		eureka_bienvenu.setLocation((int) screenSize.getWidth() / 2 - eureka_bienvenu.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - eureka_bienvenu.getHeight() / 2); // mete la location
		eureka_bienvenu.setBounds(100, 100, 1000, 700);
		eureka_bienvenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eureka_bienvenu.getContentPane().setLayout(null);
		eureka_bienvenu.setLocation((int) screenSize.getWidth() / 2 - eureka_bienvenu.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - eureka_bienvenu.getHeight() / 2); // mete la location

		JButton btnseconnect = new JButton("Se Connect");
		btnseconnect.setBounds(376, 484, 231, 29);
		eureka_bienvenu.getContentPane().add(btnseconnect);
		btnseconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					EUREKA.SeConnecter();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(eureka_bienvenu,
							"la Connexion � le Jeu  pas disponible maintenant \\n essay apres quel que minutes ",
							"EURKA | ALTER", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnseconnect.setBorder(UIManager.getBorder("Button.border"));
		btnseconnect.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnseconnect.setBackground(Color.ORANGE);

		JButton btnsinscri_cn = new JButton("Inscription");
		btnsinscri_cn.setBounds(376, 529, 231, 29);
		eureka_bienvenu.getContentPane().add(btnsinscri_cn);
		btnsinscri_cn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EUREKA.Inscription();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(eureka_bienvenu,
							"la Inscription � le Jeu  pas disponible maintenant \\n essay apres quel que minutes ",
							"EURKA | ALTER", JOptionPane.WARNING_MESSAGE);

				}

			}
		});

		btnsinscri_cn.setBorder(UIManager.getBorder("Button.border"));
		btnsinscri_cn.setBackground(new Color(255, 215, 0));
		btnsinscri_cn.setFont(new Font("Tahoma", Font.BOLD, 16));
		// add image LOGO
		JLabel btnlogo = new JLabel(new ImageIcon("Resource/logo1.png"));
		btnlogo.setBounds(360, 66, 263, 371);
		eureka_bienvenu.getContentPane().add(btnlogo);

		JButton btnApropose = new JButton("A propos");
		btnApropose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Apropose window = new Apropose();
				Bienvenu.eureka_bienvenu.setVisible(false);
				window.wApropose.setVisible(true);

			}
		});
		btnApropose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnApropose.setBorder(new LineBorder(new Color(71, 71, 135), 2));
		btnApropose.setBackground(new Color(71, 71, 135));
		btnApropose.setForeground(new Color(164, 176, 190));
		btnApropose.setBounds(148, 621, 133, 29);
		eureka_bienvenu.getContentPane().add(btnApropose);

		JButton btnhelp = new JButton("Help ( ? )");
		btnhelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Instance la Fenetre Help
				Help window = new Help();
				Bienvenu.eureka_bienvenu.setVisible(false);
				window.wHelp.setVisible(true);

			}
		});
		btnhelp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnhelp.setBorder(new LineBorder(new Color(71, 71, 135), 2));
		btnhelp.setBackground(new Color(71, 71, 135));
		btnhelp.setForeground(new Color(164, 176, 190));

		btnhelp.setBounds(710, 621, 133, 29);
		eureka_bienvenu.getContentPane().add(btnhelp);

		JButton btnListJoueurs = new JButton("List Joueurs");
		btnListJoueurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LJoueursInscr window = new LJoueursInscr();
				Bienvenu.eureka_bienvenu.setVisible(false);
				window.WListJoueurs.setVisible(true);
			}
		});

		btnListJoueurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListJoueurs.setBorder(new LineBorder(new Color(71, 71, 135), 2));
		btnListJoueurs.setBackground(new Color(71, 71, 135));
		btnListJoueurs.setForeground(new Color(164, 176, 190));
		btnListJoueurs.setBounds(429, 621, 133, 29);
		eureka_bienvenu.getContentPane().add(btnListJoueurs);

	}
}
