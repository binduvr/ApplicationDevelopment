package domain;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import model.IModel;
import model.ModelFactory;
import species.LargeHerbivore;

public class NaturePreserve {
	private int time;
	private static IModel model;
	private Set<LargeHerbivore> differentSpecies;
	private static NaturePreserve internalObject = null;
	
	public static NaturePreserve instance() {
		if(internalObject==null) {
			internalObject = new NaturePreserve();
		}
		return internalObject;
	}
	
	private NaturePreserve() {
		super();
		this.time = 0;
		NaturePreserve.model = ModelFactory.getModel();
		this.differentSpecies = new TreeSet<LargeHerbivore>();
	}
	
	public NaturePreserve getState(int time) {
		this.time = time;
		Iterator<LargeHerbivore> it = differentSpecies.iterator();
		while(it.hasNext()) {
			LargeHerbivore temp = it.next();
			temp = model.getState(temp, this);
		}
		return this;
	}
	
	public void addSpecies(LargeHerbivore species) {
		differentSpecies.add(species);
	}
	
	public void addAllSpecies(Set<LargeHerbivore> species) {
		differentSpecies.addAll(species);
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
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
