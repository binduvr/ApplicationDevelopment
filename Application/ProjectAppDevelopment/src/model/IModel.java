package model;

import domain.NaturePreserve;
import species.LargeHerbivore;

public interface IModel {
	//give instance preserve where it can get info on the species at the current state in the naturepreserve
	//what species, at what year, what is the current situation
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve);
}
