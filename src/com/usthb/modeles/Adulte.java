package com.usthb.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.usthb.EUREKA;

public class Adulte extends Joueur implements Serializable {

	private static final long serialVersionUID = 1L;

	public Adulte(String nom, String prenom, Date dateDeNaissance, String motDePasse, int dernierNiveau,
			LinkedList<PartieJeu> list) {
		super(nom, prenom, dateDeNaissance, motDePasse, dernierNiveau, list);

	}
	public Adulte(String nom, String prenom, Date dateDeNaissance, String motDePasse,int numbreJ, int dernierNiveau,
			LinkedList<PartieJeu> list) {
		super(nom, prenom, dateDeNaissance, motDePasse,numbreJ, dernierNiveau, list);

	}
	@Override
	public LinkedList<Question> getQuestions(ThemeType theme) {

		Iterator<ThemeJeu> th = EUREKA.ThemeDef.iterator();
		while (th.hasNext()) {
			ThemeJeu themeJeu = (ThemeJeu) th.next();
			if (themeJeu.getTypeDeTheme().equals(theme)) {
				if (themeJeu.getListe().get(0) instanceof QuestionAdulte) {
					return (LinkedList<Question>) themeJeu.getListe();
				}
			}

		}
		return null;
	}
	
}
