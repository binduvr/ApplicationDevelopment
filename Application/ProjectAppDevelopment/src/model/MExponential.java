package model;

import java.time.Year;

import domain.NaturePreserve;
import species.LargeHerbivore;

public class MExponential implements IModel {
	
	//Basic exponential growth model
	public double basicExponentialCalc(int N0, double r, int t) {
		return N0*(Math.exp(r*t));
	}
	
	@Override
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve) {
		Year time = preserve.getTime();
		species.setCurrentPopulation((int) basicExponentialCalc(species.getInitialPop(), species.getGrowthRate(), Integer.parseInt(time.toString())-1983));
		return species;
	}
	
}
