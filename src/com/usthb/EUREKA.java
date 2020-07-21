package com.usthb;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.usthb.dessin.*;
import com.usthb.modeles.*;

public class EUREKA {

	// Eensemble des attribut
	public static HashMap<Integer, Joueur> DicJoueur = new HashMap<Integer, Joueur>();
	public static HashSet<ThemeJeu> ThemeDef = new HashSet<ThemeJeu>();
	public static HashMap<String, LinkedList<Question>> listeQuestion = new HashMap<String, LinkedList<Question>>();

	/****************************
	 * DEBUT methode ChargerThemeDef
	 ****************************/

// Methode Inisialisation de HashSet des Themedefine 
	public static void ChargerThemeDef() {

		// Table contient les coeffition

		int[] coeff = new int[] { 4, 3, 3, 5, 3 };

		for (int i = 0; i < ThemeType.values().length; i++) {
			// contient tout les question d'un theme specifique
			LinkedList<Question> ques = new LinkedList<Question>();

			// QuestionAdulte pour un Theme
			LinkedList<Question> quesA = new LinkedList<Question>();
			// QuestionEnfant pour un Theme
			LinkedList<Question> quesE = new LinkedList<Question>();

			Question questionAdulte;
			Question questionEnfant;
			// Ajoute un Liste des Question de un Theme
			// ques.addAll(listeQuestion.get(Theme.values()[i].toString()));
			ques.addAll(listeQuestion.get(ThemeType.values()[i].toString().substring(0, 3)));
			for (Question q : ques) {

				if (q instanceof QuestionEnfant) {

					quesE.add(q);
				} else {
					quesA.add(q);
				}
			}

			// Theme define pour Enfant
			ThemeJeu TE = new ThemeJeu(ThemeType.values()[i].toString(),
					(ThemeType.values()[i].toString()).substring(0, 3), coeff[i], quesE);
			// Theme define pour Adulte
			ThemeJeu TA = new ThemeJeu(ThemeType.values()[i].toString(),
					(ThemeType.values()[i].toString()).substring(0, 3), coeff[i], quesA);

			// Ajoute les theme a Hashset Themedef
			ThemeDef.add(TA);
			ThemeDef.add(TE);
		}
	}

	/****************************
	 * fin methode ChargerThemeDef
	 ****************************/

	/****************************
	 * Fin methode listeQuestionffile
	 ****************************/
	public static void listeQuestionffile() {
		// pourchaquetheme un liste des Question specifiq

		LinkedList<Question> HIS = new LinkedList<Question>();
		LinkedList<Question> GEO = new LinkedList<Question>();
		LinkedList<Question> SAN = new LinkedList<Question>();
		LinkedList<Question> CUL = new LinkedList<Question>();
		LinkedList<Question> ISL = new LinkedList<Question>();

		// numero pour verifie le numbre des quest a ajoute a chaque liste
		int dn = 1;

		try {
			File f = new File("Resource/Question.txt");
			FileReader fr = new FileReader(f);
			// Flot de communication pour les caract�res ,
			// qui se connecte � un fichier
			BufferedReader br = new BufferedReader(fr);
			// Flot de traitement pour les caract�res ( buffer ).
			// Ce flot est cha�n� au FileReader
			String ligne; // contiendra chaque ligne

			while ((ligne = br.readLine()) != null) {
				// numQuestion = (HIS|ISL|GEO|CUL|SAN)+num
				String numQuestion = "", LibelleQuestion = "", reponse = "", image = "";
				numQuestion = new String(ligne);
				if ((ligne = br.readLine()) != null)
					LibelleQuestion = new String(ligne);

				if ((ligne = br.readLine()) != null)
					reponse = new String(ligne);

				if ((ligne = br.readLine()) != null)
					image = new String(ligne);

				// Condion pour les intervals des nivaux
				int nivaux = 0;

				boolean cn1 = dn <= 10 || dn <= 60 && dn >= 50 || dn <= 110 && dn >= 100 || dn <= 160 && dn >= 150
						|| dn <= 210 && dn >= 200;
				boolean cn2 = dn <= 20 && dn >= 10 || dn <= 70 && dn >= 60 || dn <= 120 && dn >= 110
						|| dn <= 170 && dn >= 160 || dn <= 220 && dn >= 210;
				boolean cn3 = dn <= 30 && dn >= 20 || dn <= 80 && dn >= 70 || dn <= 130 && dn >= 110
						|| dn <= 180 && dn >= 170 || dn <= 230 && dn >= 220;
				boolean cn4 = dn <= 40 && dn >= 30 || dn <= 90 && dn >= 80 || dn <= 140 && dn >= 130
						|| dn <= 190 && dn >= 180 || dn <= 240 && dn >= 230;
				boolean cn5 = dn <= 50 && dn >= 40 || dn <= 100 && dn >= 90 || dn <= 150 && dn >= 140
						|| dn <= 200 && dn >= 190 || dn <= 250 && dn >= 240;

				// determiner le niveaux des qst
				if (cn1)
					nivaux = 1;
				else if (cn2)
					nivaux = 2;
				else if (cn3)
					nivaux = 3;
				else if (cn4)
					nivaux = 4;
				else if (cn5)
					nivaux = 5;

				// Remplir les linkedlist par les qst
				String themeq = numQuestion.substring(0, 3);
				switch (themeq) {
				case "HIS":
					if (dn % 2 == 0)
						HIS.add(new QuestionEnfant(themeq, LibelleQuestion, reponse, image, nivaux));
					else
						HIS.add(new QuestionAdulte(themeq, LibelleQuestion, reponse, image, nivaux));

					break;
				case "GEO":
					if (dn % 2 == 0)
						GEO.add(new QuestionEnfant(themeq, LibelleQuestion, reponse, image, nivaux));
					else
						GEO.add(new QuestionAdulte(themeq, LibelleQuestion, reponse, image, nivaux));

					break;
				case "CUL":
					if (dn % 2 == 0)
						CUL.add(new QuestionEnfant(themeq, LibelleQuestion, reponse, image, nivaux));
					else
						CUL.add(new QuestionAdulte(themeq, LibelleQuestion, reponse, image, nivaux));

					break;
				case "SAN":

					if (dn % 2 == 0)
						SAN.add(new QuestionEnfant(themeq, LibelleQuestion, reponse, image, nivaux));
					else
						SAN.add(new QuestionAdulte(themeq, LibelleQuestion, reponse, image, nivaux));

					break;
				case "ISL":
					if (dn % 2 == 0)
						ISL.add(new QuestionEnfant(themeq, LibelleQuestion, reponse, image, nivaux));
					else
						ISL.add(new QuestionAdulte(themeq, LibelleQuestion, reponse, image, nivaux));

					break;
				// j'ai pas utilise default car elle genre un problem a la fine
				// le dernier line parceque elle pas avoir un numeroQuestion
				}

				dn += 1;
			}
			br.close();
		} catch (IOException ex) {

		}
		// Remplir le hashMap par les linkedlist des qst
		listeQuestion.put("HIS", HIS);
		listeQuestion.put("GEO", GEO);
		listeQuestion.put("SAN", SAN);
		listeQuestion.put("CUL", CUL);
		listeQuestion.put("ISL", ISL);

	}

	/****************************
	 * debut methode chargeDicJoueurs
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 ****************************/


	public static void chargeDicJoueurs() {

		try {
			FileInputStream fi = new FileInputStream(new File("Resource/Joueurs.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			// Lecture des objet

			HashMap<Integer, Joueur> jo = new HashMap<Integer, Joueur>();
			try {
				//jo = (HashMap<Integer, Joueur>) oi.readObject();
				DicJoueur= (HashMap<Integer, Joueur>) oi.readObject();
			} catch (Exception e) {
				System.out.println("Error in UPLOAD PLAYER");
				System.exit(0);
			}
			

		} catch (FileNotFoundException fnfe) {
			System.out.println("File Not Found");
		} catch (IOException ioe) {
			ioe.getMessage();
		}

	}

	/****************************
	 * Fin methode chargeDicJoueurs
	 ****************************/

	/****************************
	 * debut methode Inscription
	 ****************************/

	public static void Inscription() {

		// Afficher la fentre d'inscription
		InscriptionInt window = new InscriptionInt();
		Bienvenu.eureka_bienvenu.setVisible(false);
		window.wn_Inscription.setVisible(true);
	}

	/****************************
	 * Fin methode Inscription
	 ****************************/

	/****************************
	 * Debut methode SeConnecter
	 ****************************/

	public static void SeConnecter() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Afficher la fentre de connection
					SeConnecterInt window = new SeConnecterInt();
					Bienvenu.eureka_bienvenu.setVisible(false);
					window.wn_seconnect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/****************************
	 * fin methode SeConnecter
	 ****************************/

	/****************************
	 * DEBUT methode getScoreCourant
	 ****************************/
	public static int getScoreCourant() {

		int score = 0;
		try {
			score = PartieDeJeuInt.joueur.getTotalScore();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return score;
	}

	/****************************
	 * FIN methode getScoreCourant
	 ****************************/

	/****************************
	 * Debut Methode Initialisation
	 ****************************/

	// Function Inisialisation Chargement de l'ensemble des question et Themedefine
	// et Jouers
	public static void Initialisation() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					// Afficher la fentre principale de Jeu
					Bienvenu win = new Bienvenu();
					Bienvenu.eureka_bienvenu.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**************************** Fin Initialisation ****************************/

	/****************************
	 * Fin AfficherInfosJoueursInscrits
	 ****************************/

	public static void AfficherInfosJoueursInscrits() {
		String[][] joueurs = new String[100][5];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int i = 0;
		for (Joueur j : DicJoueur.values()) {
			joueurs[i][0] = new String(j.getNom());
			joueurs[i][1] = new String(j.getPrenom());
			joueurs[i][2] = new String(sdf.format(j.getDateDeNaissance()));
			joueurs[i][4] = new String(String.valueOf(j.getTotalScore()));
			if (j instanceof Enfant) {
				joueurs[i][3] = new String("Enfant");

			} else {
				joueurs[i][3] = new String("Adult");
			}
			i++;
		}
		LJoueursInscr.setJoueurs(joueurs);
	}

	/****************************
	 * FIN AfficherInfosJoueursInscrits
	 ****************************/

	/****************************
	 * Fin Tous les methode de EUREKA
	 ****************************/

	/******************************
	 * Function Main
	 * 
	 * @throws Exception
	 * @throws ClassNotFoundException
	 ******************************/

	public static void main(String[] args) {
		// Lancement de Jeu
		EUREKA.chargeDicJoueurs();
		EUREKA.Initialisation();

		new EUREKA();
	}
}
