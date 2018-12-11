package model;

public class Species implements Comparable<Species> {
	private String name;
	private int initialPopulation;
	private int carryingCapacity;
	private double birthRate;
	private double deathRate;
	private double growthRate;
	
	public Species(String name, int initialPopulation, int carryingCapacity, double birthRate, double deathRate) {
		super();
		this.name = name;
		this.initialPopulation = initialPopulation;
		this.carryingCapacity = carryingCapacity;
		this.birthRate = birthRate;
		this.deathRate = deathRate;
		this.growthRate = birthRate-deathRate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Species other) {
		return this.name.compareTo(other.name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInitialPopulation() {
		return initialPopulation;
	}
	public void setInitialPopulation(int initialPopulation) {
		this.initialPopulation = initialPopulation;
	}
	public int getCarryingCapacity() {
		return carryingCapacity;
	}
	public void setCarryingCapacity(int carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}
	public double getBirthRate() {
		return birthRate;
	}
	public void setBirthRate(float birthRate) {
		this.birthRate = birthRate;
	}
	public double getDeathRate() {
		return deathRate;
	}
	public void setDeathRate(float deathRate) {
		this.deathRate = deathRate;
	}
	public double getGrowthRate() {
		return growthRate;
	}
}
