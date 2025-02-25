package pub;

import java.util.Vector; 
import java.util.Enumeration;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cocktail {
	
	private class Ingrediant{
		public String ingrediant;
		public Double quantite;
		
		public Ingrediant(String ingrediant, Double quantite){
			this.ingrediant = ingrediant;
			this.quantite = quantite;
		}
	}
	
	public String nom;
	public Vector<Ingrediant> ingrediants;
	public Boolean alcoolise;
	
	/**
	 * Creates a Cocktail with its name
	 * @param nom
	 */
	public Cocktail(String nom){
		this.nom = nom;
		this.ingrediants = new Vector<Ingrediant>();
		this.alcoolise = false;
	}
	
	/**
	 * add a new element into the Cocktail.
	 * @param ingrediant
	 * @param quantite
	 */
	public void add(String ingrediant, Double quantite){
		this.ingrediants.add(new Ingrediant(ingrediant, quantite));
	}
	
	/**
	 * alcoolFree test if the Cocktail is free alcool.
	 * @return true if the Cocktail is free alcool
	 */
	public Boolean alcoolFree(){
		return !this.alcoolise;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		// Start with the cocktail's name.
		String retour = this.nom;
		// If there are ingredients, add them.
		if (!ingrediants.isEmpty()) {
			retour += " : ";
			Enumeration<Ingrediant> e = this.ingrediants.elements();
			while (e.hasMoreElements()) {
				Ingrediant current = e.nextElement();
				retour += current.ingrediant + " " + current.quantite + "%" + "\t";
			}
		}
		return retour;
	}


}
