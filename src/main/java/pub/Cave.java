package pub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cave {
	public List<Boisson> rayons; // Changed from Vector to List

	/**
	 * Constructor
	 */
	public Cave() {
		this.rayons = new ArrayList<>(); // Changed from Vector to ArrayList
	}

	/**
	 * Add a Boisson to the Cave
	 *
	 * @param b Boisson to add
	 */
	public void add(Boisson b) {
		this.rayons.add(b);
	}

	/**
	 * Take a Boisson from the Cave by name
	 *
	 * @param nom Name of the Boisson
	 * @return The Boisson if found, otherwise null
	 */
	public Boisson take(String nom) {
		Boisson retour = null;
		Iterator<Boisson> iterator = this.rayons.iterator(); // Using Iterator instead of Enumeration
		while (iterator.hasNext()) {
			retour = iterator.next();
			if (retour.nom.equalsIgnoreCase(nom)) {
				iterator.remove();
				return retour;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.getProperty("line.separator");

		retour.append("Cave : ").append(eol);

		for (Boisson boisson : this.rayons) {
			retour.append("\t").append(boisson.toString()).append(eol);
		}

		return retour.toString();
	}
}
