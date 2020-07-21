package com.usthb.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.usthb.EUREKA;

public class Enfant extends Joueur implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Enfant(String nom, String prenom, Date dateDeNaissance, String motDePasse, int dernierNiveau,
			LinkedList<PartieJeu> list) {
		super(nom, prenom, dateDeNaissance, motDePasse, dernierNiveau,list);

	}
	public Enfant(String nom, String prenom, Date dateDeNaissance, String motDePasse,int numbreJ, int dernierNiveau,
			LinkedList<PartieJeu> list) {
		super(nom, prenom, dateDeNaissance, motDePasse,numbreJ, dernierNiveau, list);

	}
	@Override
	public LinkedList<Question> getQuestions(ThemeType theme) {

		Iterator<ThemeJeu> th = EUREKA.ThemeDef.iterator();
		while (th.hasNext()) {
			ThemeJeu themeJeu = (ThemeJeu) th.next();
			if (themeJeu.getTypeDeTheme().equals(theme)) {
				if (themeJeu.getListe().get(0) instanceof QuestionEnfant) {
					return (LinkedList<Question>) themeJeu.getListe();
				}
			}

		}
		return null;
	}

}

