package com.usthb.modeles;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.usthb.EUREKA;
import com.usthb.dessin.Bienvenu;
import com.usthb.dessin.PartieDeJeuInt;

public class PartieJeu implements Serializable {

	private static final long serialVersionUID = 1L;
	public static int cp = 1;
	private int numeroPartie;
	private ThemeType themeSelect;
	private String numQuestion;
	private StringBuffer reponseEnCours;
	private  int score;
	private Question question;
	private boolean partieTermine;

	public PartieJeu(LinkedList<Question> List, int niveau, ThemeType theme) {
		
		question = FindQuestion(QuestionNivaux(List,niveau));// Selection la Question
		themeSelect = theme;
		numeroPartie = cp;
		cp++;
		reponseEnCours = init();
		numQuestion = question.getNumero();
		partieTermine = false;
	}
	

	public PartieJeu(int cpp, int sc) {
		cp=cpp;
		score=sc;
	}


	public StringBuffer init() {

		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < question.getReponse().length(); i++) {
			// append le caractere
			if (question.getReponse().toCharArray()[i] == ' ')
				str.append(' ');
			else
				str.append('*');
		}
		return str;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {

		oos.defaultWriteObject(); // Calling the default serialization logic
	}

	// This will allow us to have additional deserialization logic on top of the
	// default one e.g. decrypting object after deserialization
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject(); // Calling the default deserialization logic

	}

	

	@Override
	public String toString() {
		return "PartieJeu [numeroPartie=" + numeroPartie + ", themeSelect=" + themeSelect + ", numQuestion="
				+ numQuestion + ", reponseEnCours=" + reponseEnCours + ", score=" + score + ", question=" + question
				+ ", partieTermine=" + partieTermine + "]";
	}


	public int indexCara(char c, int j) {
		return question.getReponse().indexOf(c, j);
	}
	
// le But de Cette Fonction est de Verifie c un Caracter appartient a la reponse ou non
	public void CheckCaractere(char c, Joueur joueur) {
		int i = 0;
		int ind = indexCara(c, i);
		if (ind == -1)
			PartieDeJeuInt.potence.repaint();
		while (ind != -1 && i < question.getReponse().length()) {
			i++;
			reponseEnCours.setCharAt(ind, c);// set le caractere a l'index concerne
			ind = indexCara(c, i);// un nouveau index depuis un nouveau i
		}
		// 
		if (PartieDeJeuInt.potence.isTrouve() == false && PartieDeJeuInt.potence.getEtat() == 8)
			LosePartie(joueur);// Le joueur est echou
	}
	
	private LinkedList<Question> QuestionNivaux(LinkedList<Question> l,int nivaux){
		LinkedList<Question> q=new LinkedList<Question>();
		Iterator<Question> itr=l.iterator();  
		Question qq;
		while(itr.hasNext()){
			qq=itr.next();
		if(qq.getNiveau()==nivaux) {
			q.add(qq);
		}
		}

		return q;}

	
// le But de cette Fonction et de Returne un nouvelle Question de la list
	public Question FindQuestion(LinkedList<Question> ListeQ) {

		Random r=new Random(); 
		Question q=null;
		try {
			 q=ListeQ.get(r.nextInt(ListeQ.size()-1));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Error de Trouve un Question \n Svp Deconnectie apres Lance la application ");
		}
		return q;
	}
	public int NbParte(LinkedList<PartieJeu> l) {
		int nbrpart=0;
		for(PartieJeu p:l) {
			if(p!=null && p.getThemeSelect().equals(this.themeSelect)) {
				nbrpart++;
			}
		}
		return nbrpart;
	}
	// le But de cette Methode et de pass d'un Question (nivaux) a un autre 
	public void PasserNiveau(LinkedList<Question> List, ThemeType theme) {
		/*
		Dans cette Methode en Fait :
		1+>> le Mis a Jour de score de Jouer
		2+>> Mis a Jour des Liste de Partie Termine de Joueur 
		3+>> la verification des Range des Question et nivaux 
			 est pass a un autre 
		4+>> Instance la Nouvelle Partie de Jeu(Affichra la Fentre apres dans lE
		Constractur de la Fentre en Instance la Nouvelle Partie)
		
		*/
		Joueur joueur = PartieDeJeuInt.joueur;
		
		
		// Calcule le Score 
		setScore(getQuestion().getNBPoints() - PartieDeJeuInt.potence.getEtat() + 8 + score);
		// Confirme Que la Partie de Jeu est Termine
		setPartieTermine(true);
		// Cree un Nouvelle Liste
		LinkedList<PartieJeu> l = new LinkedList<PartieJeu>();
		l.addAll(joueur.getListPartie());
		l.addLast(this);
		joueur.setListPartie(l);
		
		// Recipire le nombre de partiepasse
		int n=NbParte(joueur.getListPartie());
		boolean cond = n == 5 || n == 10 || n == 15 || n == 20 || n == 25;
		if (!cond) {
			PartieDeJeuInt.joueur.setDernierNiveau(PartieDeJeuInt.joueur.getDernierNiveau());
			JOptionPane.showMessageDialog(null, "Bravo ! \n Vous avez passe a la prochaine Question",
					"Question Correct", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Resource/Img/correct.png"));
		} else {
			if (PartieDeJeuInt.joueur.getDernierNiveau() < 5) {

				JOptionPane.showMessageDialog(null, "Bravo ! \n Vous avez passe a la prochaine niveau",
						"Complet Nivaux", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("Resource/Img/passnivaux.png"));
				updatePlayer(joueur);
				PartieDeJeuInt.joueur.setDernierNiveau(PartieDeJeuInt.joueur.getDernierNiveau() + 1);

			} else {
				JOptionPane.showMessageDialog(null, "Bravo ! \n Vous avez Ganee tous les  niveau", "Ganee Theme",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Resource/Img/passnivaux.png"));
				// Mis a Jour de Jouer
				updatePlayer(joueur);
				JOptionPane.showMessageDialog(null, "Felecitation !\n\nVous avez passez tous les "
						+ joueur.getTotalScore() + "niveaux avec succes !\nBravo !!");
				PartieDeJeuInt.wn_partjeu.setVisible(false);
				Bienvenu.eureka_bienvenu.setVisible(true);
			}
		}

		PartieDeJeuInt.wn_partjeu.dispose();
		new PartieDeJeuInt(joueur, List, theme);
	}

	public void LosePartie(Joueur joueur) {
		/*
		 Cette Methode en Fait la Mis a jour de Jouers 
		 en arrite la Fentre PartieDeJeuInt et en Affiche la Fentre Bienvenau
		 */
		
		// mis a jour l'etat de joueur
		updatePlayer(joueur);
		JOptionPane.showMessageDialog(null, "Vous avez echou !\n Essyez une autre fois!", "EURKA | JEU ALTER",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Resource/Img/false.png"));

		// Sauvegarder le score et le dernier niveau
		PartieDeJeuInt.wn_partjeu.dispose();
		Bienvenu.eureka_bienvenu.setVisible(true);// afficher la fentre principale
	}

	public void updatePlayer(Joueur joueur) {
		/*
		 Cette Methode elle compose de trois etap 
		 1 => Recipire la liste de partie de Joueur Courant et ajoute la cette Partie
		 2 => Mis A jour de HashMap Seul le Joueur Courant en utilisant comme cle le numero Seq de Jouer
		 3 => Mis A jour de Fichier (2 etaps):
		 							3-1:Supprime le Fichie des Jouers 
		 							3-1:Cree le Nouvelle Fichier de Jouers
		 */
		
		try {
			LinkedList<PartieJeu> list = new LinkedList<PartieJeu>();
			
			list.addAll(joueur.getListPartie());
			list.addLast(this);
			joueur.setListPartie(list);
	
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Error Mis a Jour des Partie Jeu \n Svp Deconnectie apres Lance la application ");
		}
		
		// Mis A jour de HashMap (le joueur en cour)
		
		EUREKA.DicJoueur.replace(joueur.getNumerojouer(), joueur);
		/*
		=> L'idea ici de supprime le fichier et apres cree le nouvelle fichier 
		Par le meme nom et la nouvelle Mis a Jour des Jouers dans HashMap DicJouers
		
		=> En Peut Directemet fair l'ecrasment de fichier par la nouvelle fichier 
		mais dans la Bon Pratique nous utilise cette Methode 
		 
		  */
		
		File ff = new File("Resource/Joueurs.txt");
		if (!ff.delete())
			JOptionPane.showMessageDialog(null, "Error en Mis a Jour !!\n Deconnectie apres Lance la application","EURKA | ALTER MIS A JOUR",JOptionPane.WARNING_MESSAGE);

		try {
			FileOutputStream fos = new FileOutputStream(new File("Resource/Joueurs.txt"));
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			
			// Misa Jour de Conetenu de Fichier
			ois.writeObject(EUREKA.DicJoueur);
			

			fos.close();
			ois.close();
		} catch (FileNotFoundException fnf) {
			JOptionPane.showMessageDialog(null, "Problem de Serialisation 1", "EURKA | ALTER",JOptionPane.WARNING_MESSAGE);
			fnf.printStackTrace();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "failed or interrupted I/O operation Problem de Serialisation 2",
					"EURKA | ALTER", JOptionPane.WARNING_MESSAGE);
			

		}
	}
	
	// Getters et Setters 
	public int getCp() {return cp;}
	public static void setCp(int cp) {PartieJeu.cp = cp;}
	public Question getQuestion() {return question;}
	public int getNumeroPartie() {return numeroPartie;}
	public ThemeType getThemeSelect() {return themeSelect;}
	public String getNumQuestion() {return numQuestion;}
	public StringBuffer getReponseEnCours() {return reponseEnCours;}
	public int getScore() {return score;}
	public  void setScore(int scoree) {score = scoree;}
	public int givemetheScore() {return getScore();}
	public boolean isPartieTermine() {return partieTermine;}
	public void setPartieTermine(boolean partieTermine) {this.partieTermine = partieTermine;}

}

