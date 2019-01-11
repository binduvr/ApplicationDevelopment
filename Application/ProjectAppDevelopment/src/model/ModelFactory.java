package model;

import domain.NaturePreserve;

public class ModelFactory {
	
	private static IModel selectedModel = new MExponential();
	
	public static IModel getModel() {
		return selectedModel;
	}
	
	public static void setModel(String model) {
		switch(model) {
		case "Logistic Growth": selectedModel = new MLogistic(); break;
		//LotkaVolterra model class not yet implemented.
		case "Growth w/ Competition": selectedModel = new MLogistic(); break;
		default: selectedModel = new MExponential();
		}
		NaturePreserve.setModel(selectedModel);
	}
}
