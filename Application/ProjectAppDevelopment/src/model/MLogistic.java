package model;

import java.time.Year;

import domain.NaturePreserve;
import species.LargeHerbivore;

public class MLogistic implements IModel {
	
	//Basic logistic growth model with carrying capacity kept in mind
	public double basicLogisticCalc(int N0, int K, double r, int t) {
		return K/(1+(((K-N0)/N0)*Math.exp((-r)*t)));
	}
	
	@Override
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve) {
		Year time = preserve.getTime();
		species.setCurrentPopulation((int) basicLogisticCalc(species.getInitialPop(), species.getCarryingCap(), species.getGrowthRate(), Integer.parseInt(time.toString())-1983));
		return species;
	}

}
