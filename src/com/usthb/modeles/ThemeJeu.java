package com.usthb.modeles;

import java.util.LinkedList;

public class ThemeJeu {
	
	private ThemeType typeDeTheme;
	private String libelle;
	private int coefficient;
	private LinkedList<Question> Liste;

	
	// Constructure
	public ThemeJeu(String typeDeTheme, String libelle, int coefficient, LinkedList<Question> liste) {

		this.typeDeTheme = ThemeType.valueOf(typeDeTheme);
		this.libelle = libelle;
		this.coefficient = coefficient;
		Liste = liste;
	}
	
	
	
	// Getters et Setters 
	public ThemeType getTypeDeTheme() {return typeDeTheme;}
	public String getLibelle() {return libelle;}
	public int getCoefficient() {return coefficient;}
	public LinkedList<Question> getListe() {return Liste;}


}

