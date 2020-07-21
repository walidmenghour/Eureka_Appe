package com.usthb.dessin;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import com.usthb.modeles.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectThemeInt {

	public JFrame wn_choisetheme;

	public SelectThemeInt(Joueur joueur) {

		wn_choisetheme = new JFrame();
		wn_choisetheme.setResizable(false);
		wn_choisetheme.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource/logo1.png"));
		wn_choisetheme.setFont(new Font("Consolas", Font.BOLD, 18));
		wn_choisetheme.setTitle("EUREKA | Choise Theme");
		wn_choisetheme.getContentPane().setBackground(new Color(20, 30, 59));
		wn_choisetheme.setBounds(100, 100, 1000, 700);

		wn_choisetheme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wn_choisetheme.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		wn_choisetheme.setLocation((int) screenSize.getWidth() / 2 - wn_choisetheme.getWidth() / 2,
				(int) screenSize.getHeight() / 2 - wn_choisetheme.getHeight() / 2); // mete la location
		wn_choisetheme.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				JOptionPane.showMessageDialog(null, "Nous esp�rons que vous aimez l'un de nos Themes", "EURKA | EXIT",
						JOptionPane.QUESTION_MESSAGE);
				wn_choisetheme.dispose();
				// en peut utilise system.exit(0) pour exite la application directement
				// System.exit(0);

			}
		});

		JPanel Panelgauch = new JPanel();
		Panelgauch.setMinimumSize(new Dimension(100, 100));
		Panelgauch.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(169, 169, 169)));
		Panelgauch.setForeground(new Color(0, 0, 0));
		Panelgauch.setBackground(new Color(16, 22, 47));
		Panelgauch.setBounds(0, 0, 192, 881);
		wn_choisetheme.getContentPane().add(Panelgauch);
		Panelgauch.setLayout(null);

		JButton btndisconnect = new JButton("Disconnect");
		btndisconnect.setBackground(Color.LIGHT_GRAY);
		btndisconnect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndisconnect.setBounds(33, 789, 131, 40);
		Panelgauch.add(btndisconnect);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/logop1.png"));
		lblNewLabel.setBounds(10, 11, 179, 253);
		Panelgauch.add(lblNewLabel);

		JLabel lbtextjOURE = new JLabel("Joueur : ");
		lbtextjOURE.setHorizontalAlignment(SwingConstants.CENTER);
		lbtextjOURE.setForeground(Color.WHITE);
		lbtextjOURE.setFont(new Font("Roboto", Font.BOLD, 15));
		lbtextjOURE.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.GRAY));
		lbtextjOURE.setBounds(0, 258, 189, 40);
		Panelgauch.add(lbtextjOURE);

		JLabel lbnomjouer = new JLabel(joueur.getPrenom().toUpperCase() + " " + joueur.getNom().toUpperCase());
		lbnomjouer.setHorizontalAlignment(SwingConstants.CENTER);
		lbnomjouer.setForeground(Color.GREEN);
		lbnomjouer.setFont(new Font("Roboto", Font.PLAIN, 14));
		lbnomjouer.setBounds(0, 309, 179, 40);
		Panelgauch.add(lbnomjouer);

		JButton btndisconnect1 = new JButton("Disconnect");
		btndisconnect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btndisconnect1.setForeground(new Color(164, 176, 190));
		btndisconnect1.setFont(new Font("Roboto", Font.BOLD, 15));
		btndisconnect1.setBackground(new Color(71, 71, 135));
		btndisconnect1.setBounds(33, 598, 131, 40);
		Panelgauch.add(btndisconnect1);
		btndisconnect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Bienvenu window = new Bienvenu();
				wn_choisetheme.setVisible(false);
				window.eureka_bienvenu.setVisible(true);
			}
		});

		JLabel textChoisetheme = new JLabel("Choisissez un Theme ");
		textChoisetheme.setBorder(new MatteBorder(1, 2, 8, 2, (Color) Color.DARK_GRAY));
		textChoisetheme.setAlignmentX(Component.CENTER_ALIGNMENT);
		textChoisetheme.setHorizontalAlignment(SwingConstants.CENTER);
		textChoisetheme.setFont(new Font("Roboto", Font.BOLD, 21));
		textChoisetheme.setForeground(new Color(255, 255, 255));
		textChoisetheme.setBounds(478, 12, 236, 59);
		wn_choisetheme.getContentPane().add(textChoisetheme);

		// THEME ISLAM

		// add image to islam
		JLabel lbislam = new JLabel(new ImageIcon("Resource/Img/N/isllogo.png"));
		lbislam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					wn_choisetheme.setVisible(false);
					joueur.Jouer(ThemeType.ISLAM);
				} catch (Exception eapelle) {

					eapelle.printStackTrace();
					eapelle.getCause();
				}
			}
		});
		lbislam.setBounds(259, 82, 212, 212);
		wn_choisetheme.getContentPane().add(lbislam);

		// add image to history
		JLabel lbhisto = new JLabel(new ImageIcon("Resource/Img/N/hislogo.jpg"));
		lbhisto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					wn_choisetheme.setVisible(false);
					joueur.Jouer(ThemeType.HISTOIRE);
				} catch (Exception eapelle) {

					eapelle.printStackTrace();
					eapelle.getCause();
				}
			}
		});
		lbhisto.setBounds(495, 82, 212, 301);
		wn_choisetheme.getContentPane().add(lbhisto);

		// add image to panale gerographie
		JLabel lbgeo = new JLabel(new ImageIcon("Resource/Img/N/geologo.png"));
		lbgeo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					wn_choisetheme.setVisible(false);
					joueur.Jouer(ThemeType.GEOGRAPHIE);
				} catch (Exception eapelle) {

					eapelle.printStackTrace();
					eapelle.getCause();
				}
			}
		});
		lbgeo.setBounds(726, 82, 212, 212);
		wn_choisetheme.getContentPane().add(lbgeo);

		// add image to panale sante
		JLabel lbsant = new JLabel(new ImageIcon("Resource/Img/N/sanlogo.png"));
		lbsant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					wn_choisetheme.setVisible(false);
					joueur.Jouer(ThemeType.SANTE);
				} catch (Exception eapelle) {

					eapelle.printStackTrace();
					eapelle.getCause();
				}
			}
		});
		lbsant.setBounds(261, 322, 212, 212);
		wn_choisetheme.getContentPane().add(lbsant);

		// add image to panale CULTUREGENERALE
		JLabel lbcul = new JLabel(new ImageIcon("Resource/Img/N/cullogo.png"));
		lbcul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					wn_choisetheme.setVisible(false);
					joueur.Jouer(ThemeType.CULTUREGENERALE);
				} catch (Exception eapelle) {

					eapelle.printStackTrace();
					eapelle.getCause();
				}
			}
		});
		lbcul.setBounds(726, 322, 212, 212);
		wn_choisetheme.getContentPane().add(lbcul);

		JComboBox<String> comboBoxsujet = new JComboBox<String>();
		comboBoxsujet.setBackground(Color.WHITE);
		comboBoxsujet.setFont(new Font("Roboto", Font.PLAIN, 14));
		// ThemeJeu them = new ThemJeu(ISLAM,2);
		comboBoxsujet.setModel(new DefaultComboBoxModel(ThemeType.values()));
		comboBoxsujet.setSelectedIndex(0);
		comboBoxsujet.setBounds(492, 474, 222, 40);
		wn_choisetheme.getContentPane().add(comboBoxsujet);

		JButton btnChoise = new JButton("Okay");
		btnChoise.setBackground(new Color(255, 165, 0));
		btnChoise.setFont(new Font("Roboto", Font.BOLD, 14));
		btnChoise.setBounds(545, 609, 131, 40);
		wn_choisetheme.getContentPane().add(btnChoise);

		btnChoise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent selectTheme) {

				try {
					wn_choisetheme.setVisible(false);
					joueur.Jouer(ThemeType.valueOf(comboBoxsujet.getSelectedItem().toString()));
				} catch (Exception eapelle) {

					eapelle.printStackTrace();
					eapelle.getCause();
				}

			}

		});

	}
}
