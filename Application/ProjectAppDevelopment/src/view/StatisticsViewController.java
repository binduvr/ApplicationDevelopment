package view;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.Species;
import model.MathModels;

public class StatisticsViewController {
	private MainApp mainApp;
	private MathModels models;
	@FXML
	private LineChart<Number, Number> lineChart;
	
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
    
	
	@FXML
	private void initialize() {
		models = new MathModels();
		lineChart.setTitle("Animal Populations");

		showGraph();
	}
	
	@FXML
	public void handleShowGraph() {
		
	}
	public void showGraph() {
		Species cow = new Species("Cow", 30, 400, 1.33, 1);

		//Shows carrying capacity for testing purposes
		XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
		series.setName("Carrying capacity");
		series.getData().add(new XYChart.Data<Number, Number>(0,cow.getCarryingCapacity()));
		series.getData().add(new XYChart.Data<Number, Number>(20,cow.getCarryingCapacity()));
		
        lineChart.getData().add(series);
        lineChart.getData().add(models.basicLogisticGrowth(cow, 20));

	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
