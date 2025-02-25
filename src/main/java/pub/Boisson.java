package pub;

/**
 * @author Pierre Le Fameux
 *
 */
public class Boisson {
	public String nom;
	public boolean alcoolise;
	public Float degre;
	public Float volume;
	public Float prix;

	/**
	 * Constructor for non-alcoholic drink
	 *
	 * @param nom
	 */
	public Boisson(String nom) {
		this.nom = nom;
		this.alcoolise = false;
	}

	/**
	 * Constructor for alcoholic drink
	 *
	 * @param nom
	 * @param degre
	 */
	public Boisson(String nom, Float degre) {
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retour = this.nom;
		if (this.alcoolise) {
			return retour + " (l'abus d'alcool est dangereux pour la sante)";
		} else {
			return retour;
		}
	}
}
