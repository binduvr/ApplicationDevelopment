package model;

import domain.NaturePreserve;
import species.Species;

public interface IModel {
	//give instance preserve where it can get info and the species with time
	//what species, when, what is the current situation
	public Species getState(Species species, NaturePreserve preserve);
}
