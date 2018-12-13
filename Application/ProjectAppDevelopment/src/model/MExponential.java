package model;

import domain.NaturePreserve;
import species.Species;

public class MExponential implements IModel {
	
	//Basic exponential growth model
	public double basicExponentialCalc(int N0, double r, int t) {
		return N0*(Math.exp(r*t));
	}
	
	@Override
	public Species getState(Species species, NaturePreserve preserve) {
		return null;
	}
	
}
