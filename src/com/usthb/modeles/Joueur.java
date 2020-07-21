package com.usthb.modeles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

// iMPORT pacakge 
import com.usthb.EUREKA;
import com.usthb.dessin.PartieDeJeuInt;

public abstract class Joueur implements Serializable {

	private static final long serialVersionUID = 1L;
	public static int numSeq;
	private int numerojouer;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String motDePasse;
	private int dernierNiveau;
	private LinkedList<PartieJeu> ListPartie;

	// Constructure 1 : Utilise Dans La Creation de Joueur
	public Joueur(String nomm, String prenomm, Date dateDenaissance, String motdePasse, int dernierniveau,
			LinkedList<PartieJeu> list) {
		nom = nomm;
		prenom = prenomm;
		dateDeNaissance = dateDenaissance;
		motDePasse = motdePasse;
		dernierNiveau = dernierniveau;
		numerojouer = numSeq;
		numSeq++;
		ListPartie = list;
	}

	// Constructure 1 : Utilise Dans La Connextion de Joueur
	public Joueur(String nom2, String prenom2, Date dateDeNaissance2, String motDePasse2, int numbreJ,
			int dernierNiveau2, LinkedList<PartieJeu> list) {
		nom = nom2;
		prenom = prenom2;
		dateDeNaissance = dateDeNaissance2;
		motDePasse = motDePasse2;
		dernierNiveau = dernierNiveau2;
		numerojouer = numbreJ;
		ListPartie = list;
	}

	@Override
	public String toString() {
		return "Joueur [numerojouer=" + numerojouer + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance="
				+ dateDeNaissance + ", motDePasse=" + motDePasse + ", dernierNiveau=" + dernierNiveau + ", ListPartie="
				+ ListPartie + "]";
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {

		oos.defaultWriteObject(); // Calling the default serialization logic
	}

	// This will allow us to have additional deserialization logic on top of the
	// default one e.g. decrypting object after deserialization
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject(); // Calling the default deserialization logic

	}

	public void Jouer(ThemeType themeDeJeu) throws Exception {
		// On prepare tout d'abord la liste des questions et le hashset de theme
		EUREKA.listeQuestionffile();
		EUREKA.ChargerThemeDef();
		// On affiche la fenetre de partie Jeu apres ca on lance la partie

		if (!this.getListPartie().isEmpty()) {

			PartieJeu part = getListPartie().getLast();

			if (part != null && part.isPartieTermine() == false) {
				// Mettre les dernier Score et Cp de la dernier partie

				new PartieJeu(part.getCp(), part.getScore());
				// Supprime la dernier partie qui pars complite
				this.getListPartie().removeLast();
			}
		}
		// Instance la Partie Jeu par Interface
		new PartieDeJeuInt(this, getQuestions(themeDeJeu), themeDeJeu);
	}

	public LinkedList<PartieJeu> getListPartie() {
		return ListPartie;
	}

	public void setListPartie(LinkedList<PartieJeu> listPartie) {
		ListPartie = listPartie;
	}

	public int getTotalScore() {

		int total = 0;
		// tantque p est un elt de liste des partie incremanter total avec lui
		for (PartieJeu p : getListPartie())
			if (p != null && p.isPartieTermine() == true)
				total += p.givemetheScore();

		return total;
	}

	public int getNumSeq() {
		return numSeq;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public int getDernierNiveau() {
		return dernierNiveau;
	}

	public void setDernierNiveau(int dernierNiveau1) {
		dernierNiveau = dernierNiveau1;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public LinkedList<Question> getQuestions(ThemeType theme) {
		return null;
	}

	public int getNumerojouer() {
		return numerojouer;
	}

}
