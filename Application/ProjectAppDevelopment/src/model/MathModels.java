package model;

import javafx.scene.chart.XYChart;

public class MathModels {
	
	//Basic exponential growth model
	public double basicExponentialCalc(int N0, double r, int t) {
		return N0*(Math.exp(r*t));
	}
	
	//Basic logistic growth model with carrying capacity kept in mind
	public double basicLogisticCalc(int N0, int K, double r, int t) {
		return K/(1+(((K-N0)/N0)*Math.exp((-r)*t)));
	}
	
	
	public XYChart.Series<Number, Number> basicExpGrowth(Species species, int time) {		
		XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
		series.setName(species.getName());
		
		int N0 = species.getInitialPopulation();
		double r = species.getGrowthRate();
		
		for(int i=0;i<time;i++) {
			double y = basicExponentialCalc(N0, r, i);
	        series.getData().add(new XYChart.Data<Number, Number>(i, y));
		}
        return series;
	}
	
	public XYChart.Series<Number, Number> basicLogisticGrowth(Species species, int time) {
		XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
		series.setName(species.getName());
		
		int N0 = species.getInitialPopulation();
		double r = species.getGrowthRate();
		int K = species.getCarryingCapacity();
	
		for(int i=0;i<=time;i++) {
			double y = basicLogisticCalc(N0, K, r, i);
			series.getData().add(new XYChart.Data<Number, Number>(i,y));
		}
		return series;
	}
}
