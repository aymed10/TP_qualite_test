package pub;
import java.util.Vector; 
import java.util.Enumeration;

/**
 * @author Pierre Le Fameux
 *
 */
public class Bar {
	public Vector<Boisson> boissonChaude;
	public Vector<Boisson> boissonFroide;
	public Vector<Boisson> boissonAlcoolisee;
	public Vector<Cocktail> cocktailSansAlcoole;
	public Vector<Cocktail> cocktailAvecAlcoole;
	
	/**
	 * 
	 */
	public Bar(){
		this.boissonChaude = new Vector<Boisson>();
		this.boissonFroide = new Vector<Boisson>();
		this.boissonAlcoolisee = new Vector<Boisson>();
		
		this.cocktailAvecAlcoole = new Vector<Cocktail>();
		this.cocktailSansAlcoole = new Vector<Cocktail>();	
	}
	
	/**
	 * @param boisson
	 */
	public void add(Boisson boisson){
		if(boisson.alcoolise){
			this.boissonAlcoolisee.add(boisson);
		}else{
			this.boissonFroide.add(boisson);
		}
	}
	
	/**
	 * @param cocktail
	 */
	public void add(Cocktail cocktail){
		if(cocktail.alcoolFree()){
			this.cocktailSansAlcoole.add(cocktail);
		}else{
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}
	
	/**
	 * @param command
	 * @return
	 */
	public Object serv(String command) {
		// Check boissonFroide
		Enumeration<Boisson> eBoisson = this.boissonFroide.elements();
		while (eBoisson.hasMoreElements()) {
			Boisson b = eBoisson.nextElement();
			if (b.nom.equalsIgnoreCase(command)) {
				this.boissonFroide.remove(b);
				return b;
			}
		}

		// Check boissonAlcoolisee
		eBoisson = this.boissonAlcoolisee.elements();
		while (eBoisson.hasMoreElements()) {
			Boisson b = eBoisson.nextElement();
			if (b.nom.equalsIgnoreCase(command)) {
				this.boissonAlcoolisee.remove(b);
				return b;
			}
		}

		// Check boissonChaude
		eBoisson = this.boissonChaude.elements();
		while (eBoisson.hasMoreElements()) {
			Boisson b = eBoisson.nextElement();
			if (b.nom.equalsIgnoreCase(command)) {
				this.boissonChaude.remove(b);
				return b;
			}
		}

		// Check cocktailSansAlcoole
		Enumeration<Cocktail> eCocktail = this.cocktailSansAlcoole.elements();
		while (eCocktail.hasMoreElements()) {
			Cocktail c = eCocktail.nextElement();
			if (c.nom.equalsIgnoreCase(command)) {
				this.cocktailSansAlcoole.remove(c);
				return c;
			}
		}

		// Check cocktailAvecAlcoole
		eCocktail = this.cocktailAvecAlcoole.elements();
		while (eCocktail.hasMoreElements()) {
			Cocktail c = eCocktail.nextElement();
			if (c.nom.equalsIgnoreCase(command)) {
				this.cocktailAvecAlcoole.remove(c);
				return c;
			}
		}

		// No match found
		return null;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = new String();
		String eol = System.getProperty("line.separator"); 
		Enumeration e;
		
		retour = retour + "Bar : " + eol;
		
		retour = retour + "\t Sans alcool" + eol;
		e = this.boissonFroide.elements ();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Avec alcool" + eol;
		e = this.boissonAlcoolisee.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Cocktail sans alcool" + eol;
		e = this.cocktailSansAlcoole.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Cocktail avec alcool" + eol;
		e = this.cocktailAvecAlcoole.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		retour = retour + "\t Boissons chaudes" + eol;
		e = this.boissonChaude.elements();
		while (e.hasMoreElements ()) {
			retour = retour + "\t\t" + e.nextElement().toString() + eol;
		}
		
		return retour;
	}

}
