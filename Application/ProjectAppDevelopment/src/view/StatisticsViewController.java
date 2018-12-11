package view;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class StatisticsViewController {
	private MainApp mainApp;
	
	@FXML
	private LineChart<Number, Number> lineChart;
	
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
	private XYChart.Series<Number, Number> series;
	
	@FXML
	private void initialize() {
		lineChart.setTitle("Animal populations");
		series = new XYChart.Series<Number, Number>();
	    
		
		series.setName("Data Series 1");
	    
	    
        series.getData().add(new XYChart.Data<Number, Number>(1, 23));
        series.getData().add(new XYChart.Data<Number, Number>(2, 14));
        series.getData().add(new XYChart.Data<Number, Number>(3, 15));
        series.getData().add(new XYChart.Data<Number, Number>(4, 24));
        series.getData().add(new XYChart.Data<Number, Number>(5, 34));
        series.getData().add(new XYChart.Data<Number, Number>(6, 36));
        
        lineChart.getData().add(series);
	    
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
