package model;

import domain.NaturePreserve;
import species.LargeHerbivore;

public class MLotkaVolterra implements IModel {
	
	public double loktaVolterraCalc(int n1, int K1, int r1, int N2, double a, int time) {
		//not yet implemented
		return 0;
	}
	
	
	//alpha is population of wanted animal/ population of competing animal
	//TODO not yet implemented
	@Override
	public LargeHerbivore getState(LargeHerbivore species, NaturePreserve preserve) {
		int time = preserve.getTime();
		if(species.isCompeting()) {
			double a = species.getCurrentPopulation()/(preserve.getSpecies(species.getCompetitor().getName()).getCurrentPopulation());
			
		}
		species.setCurrentPopulation(1);
		return species;
	}

}
