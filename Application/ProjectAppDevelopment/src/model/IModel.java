package model;

import domain.NaturePreserve;
import species.Species;

public interface IModel {
	//give instance preserve where it can get info and the species with time
	//what species, at what year, what is the current situation
	public NaturePreserve getState(Species species, NaturePreserve preserve);
}
