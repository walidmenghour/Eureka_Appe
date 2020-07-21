package com.usthb.dessin;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class Potence extends Component {

	private static final long serialVersionUID = 1L;
	public int etat;
	private boolean trouve;
	private Dimension dimension = new Dimension();

	public Potence() {
		etat = 0;
		trouve = false;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public boolean isTrouve() {
		return trouve;
	}

	public void setTrouve(boolean trouv) {
		this.trouve = trouv;
	}

	public void paint(Graphics g) {
		// Le dessin s'adapte � l'espace attribu�

		dimension = getSize();// de Component
		g.clearRect(0, 0, dimension.width - 1, dimension.height - 1); // effacer

		g.drawRect(0, 0, dimension.width - 1, dimension.height - 1); // tracer le cadre

		g.setColor(new Color(20, 30, 59)); // change la colore

		// s'adapter � l'espace du composant

		int taille = 12 * (dimension.width / 120);

		if (taille < 8)
			taille = 8;
		g.setFont(new Font("Tahoma", Font.BOLD, 20));

		if (etat >= 1)
			g.drawLine(l(30), h(120), l(90), h(120));
		if (etat >= 2)
			g.drawLine(l(30), h(120), l(30), h(40));
		if (etat >= 3)
			g.drawLine(l(60), h(120), l(30), h(90));
		if (etat >= 4)
			g.drawLine(l(30), h(40), l(80), h(40));
		if (etat >= 5)
			g.drawLine(l(30), h(60), l(50), h(40));
		if (etat >= 6)
			g.drawLine(l(70), h(40), l(70), h(60));
		if (etat >= 7)
			g.drawOval(l(65), h(60), l(10), h(10)); // t�te
		if (etat >= 8) {
			g.drawLine(l(70), h(70), l(70), h(85)); // corps
			g.drawLine(l(70), h(70), l(65), h(75)); // corps
			g.drawLine(l(70), h(70), l(75), h(75)); // corps
			g.drawLine(l(70), h(85), l(65), h(95)); // corps
			g.drawLine(l(70), h(85), l(75), h(95)); // corps
		}
		if (trouve) {
			g.drawString("Bravo! vous avez trouv�", l(40), h(140));

		} else if (etat == 8) {
			g.drawString("Vous �tes pendu !", l(40), h(140));

		}

		else if (etat == 7) {
			g.drawString("Reste un coup � jouer !", l(40), h(140));
			etat++;
		} else { // (etat >=0 && etat <7)
			g.drawString("Reste " + (8 - etat) + " coups � jouer", l(40), h(140));
			etat++;
		}
	}

	// Mise � l'�chelle en largeur de v

	int l(int v) {
		double k = Math.min(dimension.width / 140., dimension.height / 160);
		return (int) (v * k);
	}

	// Mise � l'�chelle en hauteur de v
	int h(int v) {
		double k = Math.min(dimension.width / 140., dimension.height / 160);
		return (int) (v * k);
	}

}
