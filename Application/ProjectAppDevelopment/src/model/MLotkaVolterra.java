package model;

import domain.NaturePreserve;
import species.LargeHerbivore;

public class MLotkaVolterra implements IModel {
	
	//Basic logistic growth model with carrying capacity kept in mind
	public double loktaVolterraCalc(int N0, int K, double r, int t) {
		return K/(1+(((K-N0)/N0)*Math.exp((-r)*t)));
	}
	
	@Override
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve) {
		int time = preserve.getTime();
		species.setCurrentPopulation((int) loktaVolterraCalc(species.getInitialPop(), species.getCarryingCap(), species.getGrowthRate(), time));
		return species;
	}

}
