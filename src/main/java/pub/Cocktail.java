package pub;

import java.util.HashMap;
import java.util.Map;

public class Cocktail {
	private String nom;
	private boolean alcoolise;
	private Map<String, Double> ingredients;

	public Cocktail(String nom) {
		this.nom = nom;
		this.alcoolise = false;
		this.ingredients = new HashMap<>();
	}

	public void add(String ingredient, Double pourcentage) {
		ingredients.put(ingredient, pourcentage);
	}

	public String getNom() {
		return nom;
	}

	public boolean isAlcoolise() {
		return alcoolise;
	}

	public void setAlcoolise(boolean alcoolise) {
		this.alcoolise = alcoolise;
	}

	public boolean alcoolFree() {
		return !alcoolise;
	}

	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder(nom + " : ");
		for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
			retour.append(entry.getKey()).append(" ").append(entry.getValue()).append("%    ");
		}
		return retour.toString();
	}
}
