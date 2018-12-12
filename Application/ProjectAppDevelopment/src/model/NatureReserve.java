package model;

import java.util.Set;

public class NatureReserve {
	private int size;
	private Set<Species> differentSpecies;
	//dont have to do total
	private int totalInitialPopulation;
	private double totalBirthRate;
	private double totalDeathRate;
	private double totalGrowthRate;
	private int totalCarryingCapacity;
	
	
	public NatureReserve(int size, Set<Species> differentSpecies, int totalInitialPopulation, double totalBirthRate,
			double totalDeathRate, int totalCarryingCapacity) {
		super();
		this.size = size;
		this.differentSpecies = differentSpecies;
		this.totalInitialPopulation = totalInitialPopulation;
		this.totalBirthRate = totalBirthRate;
		this.totalDeathRate = totalDeathRate;
		this.totalGrowthRate = totalBirthRate-totalDeathRate;
		this.totalCarryingCapacity = totalCarryingCapacity;
	}
	
	public void addSpecies(Species species) {
		differentSpecies.add(species);
	}
	
	//Getters and setters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Set<Species> getDifferentSpecies() {
		return differentSpecies;
	}
	public void setDifferentSpecies(Set<Species> differentSpecies) {
		this.differentSpecies = differentSpecies;
	}
	public int getTotalInitialPopulation() {
		return totalInitialPopulation;
	}
	public void setTotalInitialPopulation(int totalInitialPopulation) {
		this.totalInitialPopulation = totalInitialPopulation;
	}
	public double getTotalBirthRate() {
		return totalBirthRate;
	}
	public void setTotalBirthRate(double totalBirthRate) {
		this.totalBirthRate = totalBirthRate;
	}
	public double getTotalDeathRate() {
		return totalDeathRate;
	}
	public void setTotalDeathRate(double totalDeathRate) {
		this.totalDeathRate = totalDeathRate;
	}
	public int getTotalCarryingCapacity() {
		return totalCarryingCapacity;
	}
	public void setTotalCarryingCapacity(int totalCarryingCapacity) {
		this.totalCarryingCapacity = totalCarryingCapacity;
	}
	public double getTotalGrowthRate() {
		return totalGrowthRate;
	}
}
