package domain;

import java.time.Year;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import model.IModel;
import model.ModelFactory;
import species.LargeHerbivore;

public class NaturePreserve {
	private Year time;
	private static IModel model;
	private Set<LargeHerbivore> differentSpecies;
	private TreeSet<Integer> speciesPopulations;
	
	private static NaturePreserve internalObject = null;
	
	public static NaturePreserve instance(Set<LargeHerbivore> differentSpecies) {
		if(internalObject==null) {
			internalObject = new NaturePreserve(differentSpecies);
		}
		return internalObject;
	}
	
	private NaturePreserve(Set<LargeHerbivore> differentSpecies) {
		super();
		this.time = Year.parse("1983");
		NaturePreserve.model = ModelFactory.getModel();
		this.differentSpecies = differentSpecies;
	}
	
	public NaturePreserve getState(Year time) {
		this.time = time;
		Iterator<LargeHerbivore> it = differentSpecies.iterator();
		while(it.hasNext()) {
			LargeHerbivore temp = it.next();
			if(temp.getYearIntroduced().equals(time) || temp.getYearIntroduced().isBefore(time)) {
				temp = model.getState(temp, this);
			} else {
				temp.setCurrentPopulation(0);
			}
		}
		return this;
	}
	
	public void addSpecies(LargeHerbivore species) {
		differentSpecies.add(species);
	}
	
	public LargeHerbivore getSpecies(String name) {
		Iterator<LargeHerbivore> it = differentSpecies.iterator();
		while(it.hasNext()) {
			LargeHerbivore temp = it.next();
			if(temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	
	//Getters and setters
	public Year getTime() {
		return time;
	}
	public void setTime(Year time) {
		this.time = time;
	}
	public Set<LargeHerbivore> getDifferentSpecies() {
		return differentSpecies;
	}
	public void setDifferentSpecies(Set<LargeHerbivore> differentSpecies) {
		this.differentSpecies = differentSpecies;
	}
	public static void setModel(IModel model) {
		NaturePreserve.model = model;
	}
}
