package model;

import domain.NaturePreserve;

public class ModelFactory {
	
	private static IModel selectedModel = new MExponential();
	
	public static IModel getModel() {
		return selectedModel;
	}
	
	public static void setModel(String model) {
		switch(model) {
		case "LOG": selectedModel = new MLogistic(); break;
		default: selectedModel = new MExponential();
		}
		NaturePreserve.setModel(selectedModel);
	}
}
