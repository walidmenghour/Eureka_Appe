package com.usthb.modeles;

import java.io.Serializable;

public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int numeroSeq;
	private String theme;
	private String libelle;
	private final String numero;
	private String image;
	private String reponse;
	private int niveau;

	public Question(String theme, String libelle, String reponse, String image, int niveau) {
		this.theme = theme;
		this.libelle = libelle;
		this.numero = theme + numeroSeq;
		numeroSeq++;
		this.image = image;
		this.reponse = reponse;
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Question [theme=" + theme + ", libelle=" + libelle + ", numero=" + numero + ", image=" + image
				+ ", reponse=" + reponse + ", niveau=" + niveau + "]";
	}

	public Question(String numero) {
		this.numero = numero;
	}

	public static int getNumeroSeq() {
		return numeroSeq;
	}

	public static void setNumeroSeq(int numeroSeq) {
		Question.numeroSeq = numeroSeq;
	}

	public int getNBPoints() {
		switch (niveau) {
		case 1:
			return 5;
		case 2:
			return 10;
		case 3:
			return 18;
		case 4:
			return 28;
		case 5:
			return 40;
		default:
			return 0;
		}
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String lb) {
		libelle = lb;
	}

	public String getNumero() {
		return numero;
	}

	// public void setNumero(String numero) {this.numero = numero;}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

}
