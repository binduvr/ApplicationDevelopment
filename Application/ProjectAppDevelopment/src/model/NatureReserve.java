package model;

import java.util.Set;

public class NatureReserve {
	private int size;
	private Set<Species> differentSpecies;
	
	private NatureReserve internalObject = null;
	
	public NatureReserve instance(int size, Set<Species> differentSpecies) {
		if(internalObject==null) {
			internalObject = new NatureReserve(size, differentSpecies);
		}
		return internalObject;
	}
	public NatureReserve(int size, Set<Species> differentSpecies) {
		super();
		this.size = size;
		this.differentSpecies = differentSpecies;
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
}
