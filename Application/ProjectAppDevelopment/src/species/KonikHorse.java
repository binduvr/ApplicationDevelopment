package species;

public class KonikHorse {
	private String name;
	private int initialPopulation;
	private int carryingCapacity;
	private double birthRate;
	private double deathRate;
	private double growthRate;
	public KonikHorse(int initialPopulation, int carryingCapacity, double birthRate, double deathRate) {
		super();
		this.initialPopulation = initialPopulation;
		this.carryingCapacity = carryingCapacity;
		this.birthRate = birthRate;
		this.deathRate = deathRate;
		this.growthRate = birthRate-deathRate;
	}
}
