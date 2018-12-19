package model;

import domain.NaturePreserve;
import species.LargeHerbivore;

public class MExponential implements IModel {
	
	//Basic exponential growth model
	public double basicExponentialCalc(int N0, double r, int t) {
		return N0*(Math.exp(r*t));
	}
	
	@Override
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve) {
		int time = preserve.getTime();
		species.setCurrentPopulation((int) basicExponentialCalc(species.getInitialPop(), species.getGrowthRate(), time));
		return species;
	}
	
}
