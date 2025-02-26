package pub;

/**
 * Virtual PUB
 */
public class Pub {

	private Bar bar;
	private Cave cave;

	/**
	 * Constructor
	 */
	public Pub() {
		this.bar = new Bar();
		this.cave = new Cave();
	}

	/**
	 * Approvisionner le Bar depuis la Cave
	 * @param nom Nom de la boisson
	 */
	public void approvisionnerBar(String nom) {
		this.bar.add(this.cave.take(nom));
	}

	/**
	 * Getter for Cave
	 * @return Cave
	 */
	public Cave getCave() {
		return cave;
	}

	/**
	 * Getter for Bar
	 * @return Bar
	 */
	public Bar getBar() {
		return bar;
	}

	/**
	 * Main Method for testing
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		/* Creation du pub */
		Pub pub = new Pub();

		Boisson coca = new Boisson("Coca");
		Boisson eau = new Boisson("Eau");
		Boisson sky = new Boisson("Whisky", 40.0f);
		Boisson bierre = new Boisson("Bierre", 8.0f);

		pub.getCave().add(coca);
		pub.getCave().add(coca);
		pub.getCave().add(coca);
		pub.getCave().add(sky);
		pub.getCave().add(sky);
		pub.getCave().add(bierre);
		pub.getCave().add(bierre);
		pub.getCave().add(eau);

		System.out.println("Cave initiale :");
		System.out.println(pub.getCave());

		pub.approvisionnerBar("bierre");
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("eau");

		Cocktail maz = new Cocktail("Mazout");
		maz.add("bierre", 50.0);
		maz.add("coca", 50.0);
		pub.getBar().add(maz);

		Boisson cafe = new Boisson("cafe");
		pub.getBar().addBoissonChaude(cafe);

		System.out.println(pub.getCave());
		System.out.println(pub.getBar());

		System.out.println("Boisson servie : " + pub.getBar().serv("cafe"));
		System.out.println(pub.getBar());
	}
}
