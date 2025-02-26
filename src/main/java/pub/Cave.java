package pub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Virtual Cave that holds Boissons.
 */
public class Cave {
	private List<Boisson> rayons;

	/**
	 * Constructor
	 */
	public Cave() {
		this.rayons = new ArrayList<>();
	}

	/**
	 * Adds a Boisson to the cave.
	 *
	 * @param b The Boisson to add.
	 */
	public void add(Boisson b) {
		this.rayons.add(b);
	}

	/**
	 * Takes a Boisson from the cave by name.
	 *
	 * @param nom The name of the Boisson to take.
	 * @return The Boisson if found; otherwise, null.
	 */
	public Boisson take(String nom) {
		Iterator<Boisson> it = rayons.iterator();
		while (it.hasNext()) {
			Boisson b = it.next();
			if (b.getNom().equalsIgnoreCase(nom)) {
				it.remove();
				return b;
			}
		}
		return null;
	}

	/**
	 * Returns a string representation of the cave.
	 *
	 * @return The string representation.
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.getProperty("line.separator");
		retour.append("Cave : ").append(eol);
		for (Boisson b : rayons) {
			retour.append("\t").append(b.toString()).append(eol);
		}
		return retour.toString();
	}

	// Getter for rayons to allow test access
	public List<Boisson> getRayons() {
		return new ArrayList<>(rayons);
	}
}
