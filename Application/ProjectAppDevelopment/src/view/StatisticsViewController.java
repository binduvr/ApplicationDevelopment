package view;

import java.time.Year;
import java.util.Iterator;

import application.MainApp;
import domain.NaturePreserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.MathModels;
import model.ModelFactory;
import species.*;

public class StatisticsViewController {
	private MainApp mainApp;
	private MathModels models;
	
	@FXML
	private TextField numYears;
	@FXML
	private ComboBox<String> modelChoice;
	@FXML
	private LineChart<Number, Number> lineChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
    private int timeRange;
    private ObservableList<String> options;
	@FXML
	private void initialize() {
		options = FXCollections.observableArrayList("Exponential Growth","Logistic Growth");
//		models = new MathModels();
		timeRange = 20;
		numYears.setText(Integer.toString(timeRange));
		modelChoice.setItems(options);
		modelChoice.getSelectionModel().selectFirst();
		lineChart.setTitle("Animal Populations");
		lineChart.setCreateSymbols(false);
		
		handleShowGraph();
	}
	
	@FXML
	public void handleShowGraph() {
		lineChart.getData().clear();
		NaturePreserve preserve = NaturePreserve.instance(null);
		
		//Doing this because switch isnt working
		if(modelChoice.getSelectionModel().getSelectedItem()=="Exponential Growth") {
			ModelFactory.setModel("EXP");
		} else {
			ModelFactory.setModel("LOG");
		}
		
		
		//Really sloppy just temporary to show graph
//		LargeHerbivore cow = new HeckCattle();
//		LargeHerbivore horse = new KonikHorse();
//		LargeHerbivore deer = new RedDeer();
//		if(!numYears.getText().equals("")) {
//			timeRange = Integer.parseInt(numYears.getText().toString());
//		}
//		
//        lineChart.getData().add(models.basicLogisticGrowth(cow, timeRange));
//        lineChart.getData().add(models.basicLogisticGrowth(horse, timeRange));
//        lineChart.getData().add(models.basicLogisticGrowth(deer, timeRange));
//        
        
        //Working on this
		
		if(!numYears.getText().equals("")) {
		timeRange = Integer.parseInt(numYears.getText().toString());
		}
		Iterator<LargeHerbivore> it = preserve.getDifferentSpecies().iterator();
		while(it.hasNext()) {
			LargeHerbivore species = it.next();
			XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
			series.setName(species.getName());
			for(int i=0;i<=timeRange;i++) {
				int population = preserve.getState(i).getSpecies(species.getName()).getCurrentPopulation();
				series.getData().add(new XYChart.Data<Number, Number>(i,population));
			}
			lineChart.getData().add(series);
		}

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
