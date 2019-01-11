package model;

import domain.NaturePreserve;
import species.LargeHerbivore;

public interface IModel {
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve);
}
