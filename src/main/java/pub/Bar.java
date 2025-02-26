package pub;

import java.util.ArrayList;
import java.util.List;

public class Bar {
	private List<Boisson> boissonChaude;
	private List<Boisson> boissonFroide;
	private List<Boisson> boissonAlcoolisee;
	private List<Cocktail> cocktailSansAlcoole;
	private List<Cocktail> cocktailAvecAlcoole;

	public Bar() {
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}

	public void add(Boisson boisson) {
		if (boisson.isAlcoolise()) {
			this.boissonAlcoolisee.add(boisson);
		} else {
			this.boissonFroide.add(boisson);
		}
	}

	public void add(Cocktail cocktail) {
		if (cocktail.alcoolFree()) {
			this.cocktailSansAlcoole.add(cocktail);
		} else {
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}


	public void addBoissonChaude(Boisson boisson) {
		this.boissonChaude.add(boisson);
	}


	public Object serv(String command) {
		for (Boisson b : this.boissonFroide) {
			if (b.getNom().equalsIgnoreCase(command)) {
				this.boissonFroide.remove(b);
				return b;
			}
		}

		for (Boisson b : this.boissonAlcoolisee) {
			if (b.getNom().equalsIgnoreCase(command)) {
				this.boissonAlcoolisee.remove(b);
				return b;
			}
		}

		for (Boisson b : this.boissonChaude) {
			if (b.getNom().equalsIgnoreCase(command)) {
				this.boissonChaude.remove(b);
				return b;
			}
		}

		for (Cocktail c : this.cocktailSansAlcoole) {
			if (c.getNom().equalsIgnoreCase(command)) {
				this.cocktailSansAlcoole.remove(c);
				return c;
			}
		}

		for (Cocktail c : this.cocktailAvecAlcoole) {
			if (c.getNom().equalsIgnoreCase(command)) {
				this.cocktailAvecAlcoole.remove(c);
				return c;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.getProperty("line.separator");

		retour.append("Bar : ").append(eol);

		retour.append("\t Sans alcool").append(eol);
		for (Boisson b : this.boissonFroide) {
			retour.append("\t\t").append(b.toString()).append(eol);
		}

		retour.append("\t Avec alcool").append(eol);
		for (Boisson b : this.boissonAlcoolisee) {
			retour.append("\t\t").append(b.toString()).append(eol);
		}

		retour.append("\t Cocktail sans alcool").append(eol);
		for (Cocktail c : this.cocktailSansAlcoole) {
			retour.append("\t\t").append(c.toString()).append(eol);
		}

		retour.append("\t Cocktail avec alcool").append(eol);
		for (Cocktail c : this.cocktailAvecAlcoole) {
			retour.append("\t\t").append(c.toString()).append(eol);
		}

		retour.append("\t Boissons chaudes").append(eol);
		for (Boisson b : this.boissonChaude) {
			retour.append("\t\t").append(b.toString()).append(eol);
		}

		return retour.toString();
	}

	// Added Getters for Private Lists
	public List<Boisson> getBoissonChaude() {
		return boissonChaude;
	}

	public List<Boisson> getBoissonFroide() {
		return boissonFroide;
	}

	public List<Boisson> getBoissonAlcoolisee() {
		return boissonAlcoolisee;
	}

	public List<Cocktail> getCocktailSansAlcoole() {
		return cocktailSansAlcoole;
	}

	public List<Cocktail> getCocktailAvecAlcoole() {
		return cocktailAvecAlcoole;
	}
}
