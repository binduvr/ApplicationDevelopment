package domain;

import java.time.LocalDate;
import java.util.Set;

import species.Species;

public class NaturePreserve {
	private int size;
	private LocalDate time;
	private Set<Species> differentSpecies;
	
	private NaturePreserve internalObject = null;
	
	public NaturePreserve instance(int size, Set<Species> differentSpecies) {
		if(internalObject==null) {
			internalObject = new NaturePreserve(size, differentSpecies);
		}
		return internalObject;
	}
	private NaturePreserve(int size, Set<Species> differentSpecies) {
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
