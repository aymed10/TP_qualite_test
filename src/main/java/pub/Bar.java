package pub;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Bar {
	public List<Boisson> boissonChaude;
	public List<Boisson> boissonFroide;
	public List<Boisson> boissonAlcoolisee;
	public List<Cocktail> cocktailSansAlcoole;
	public List<Cocktail> cocktailAvecAlcoole;

	/**
	 * Constructor
	 */
	public Bar() {
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();

		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}

	/**
	 * Add a Boisson to the Bar
	 *
	 * @param boisson
	 */
	public void add(Boisson boisson) {
		if (boisson.alcoolise) {
			this.boissonAlcoolisee.add(boisson);
		} else {
			this.boissonFroide.add(boisson);
		}
	}

	/**
	 * Add a Cocktail to the Bar
	 *
	 * @param cocktail
	 */
	public void add(Cocktail cocktail) {
		if (cocktail.alcoolFree()) {
			this.cocktailSansAlcoole.add(cocktail);
		} else {
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}

	/**
	 * Serve a drink based on the command
	 *
	 * @param command
	 * @return
	 */
	public Object serv(String command) {
		// Check boissonFroide
		for (Boisson b : this.boissonFroide) {
			if (b.nom.equalsIgnoreCase(command)) {
				this.boissonFroide.remove(b);
				return b;
			}
		}

		// Check boissonAlcoolisee
		for (Boisson b : this.boissonAlcoolisee) {
			if (b.nom.equalsIgnoreCase(command)) {
				this.boissonAlcoolisee.remove(b);
				return b;
			}
		}

		// Check boissonChaude
		for (Boisson b : this.boissonChaude) {
			if (b.nom.equalsIgnoreCase(command)) {
				this.boissonChaude.remove(b);
				return b;
			}
		}

		// Check cocktailSansAlcoole
		for (Cocktail c : this.cocktailSansAlcoole) {
			if (c.nom.equalsIgnoreCase(command)) {
				this.cocktailSansAlcoole.remove(c);
				return c;
			}
		}

		// Check cocktailAvecAlcoole
		for (Cocktail c : this.cocktailAvecAlcoole) {
			if (c.nom.equalsIgnoreCase(command)) {
				this.cocktailAvecAlcoole.remove(c);
				return c;
			}
		}

		// No match found
		return null;
	}

	/**
	 * Display the Bar inventory as a string
	 *
	 * @return
	 */
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
}
