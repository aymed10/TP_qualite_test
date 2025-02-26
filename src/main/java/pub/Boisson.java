package pub;

public class Boisson {
	private String nom;
	private boolean alcoolise;
	private float degre;
	private float volume;
	private float prix;

	public Boisson(String nom) {
		this.nom = nom;
		this.alcoolise = false;
	}

	public Boisson(String nom, float degre) {
		this.nom = nom;
		this.alcoolise = true;
		this.degre = degre;
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

	@Override
	public String toString() {
		if (alcoolise) {
			return nom + " (l'abus d'alcool est dangereux pour la sante)";
		} else {
			return nom;
		}
	}
}
