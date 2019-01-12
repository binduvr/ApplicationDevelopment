package view;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import application.MainApp;
import domain.NaturePreserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.ModelFactory;
import species.LargeHerbivore;
import util.ValidateNumericTextfield;

public class StatisticsViewController implements Observer {
	private MainApp mainApp;

	@FXML
	private TableView<LargeHerbivore> populationTable;
	@FXML
	private TableColumn<LargeHerbivore, String> speciesColumn;
	@FXML
	private TableColumn<LargeHerbivore, Number> popColumn;

	@FXML
	private TextField selectedYearField;
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

	private NaturePreserve preserve;
	private int timeRange;
	private int selectedYear;
	private static ObservableList<LargeHerbivore> speciesList;
	private ObservableList<String> options;

	@FXML
	private void initialize() {
		preserve = NaturePreserve.instance();
		speciesList = FXCollections.observableArrayList();
		options = FXCollections.observableArrayList("Exponential Growth","Logistic Growth", "Growth w/ Competition");
		timeRange = 20;
		selectedYear = 0;
		numYears.setText(Integer.toString(timeRange));
		selectedYearField.setText(Integer.toString(selectedYear));
		modelChoice.setItems(options);
		modelChoice.getSelectionModel().selectFirst();
		lineChart.setTitle("Animal Population Growth");
		lineChart.setCreateSymbols(false);
		
		ValidateNumericTextfield.validate(selectedYearField);
		ValidateNumericTextfield.validate(numYears);
		
		//Adds selection listener so it shows which time is clicked on the graph
		//TODO Allow drag + click to work
		lineChart.setOnMousePressed((MouseEvent event) -> {
			Point2D mouseSceneCoords = new Point2D(event.getSceneX(), event.getSceneY());
			int x = (int) Math.round(xAxis.sceneToLocal(mouseSceneCoords).getX());
			selectedYearField.setText(Integer.toString(xAxis.getValueForDisplay(x).intValue()));
			showSpecies();
		});
		handleShowGraph();
		showSpecies();
	}

	public void handleShowGraph() {
		lineChart.getData().clear();

		//TODO get from settings file
		if (!numYears.getText().equals("") && Integer.parseInt(numYears.getText().toString())<300) {
			timeRange = Integer.parseInt(numYears.getText().toString());
		} else {
			numYears.setText("20");
		}

		
		//Sets selected model
		ModelFactory.setModel(modelChoice.getSelectionModel().getSelectedItem());
		
		//TODO Add this to a different thread that updates gui as it works
		Iterator<LargeHerbivore> it = preserve.getDifferentSpecies().iterator();
		while (it.hasNext()) {
			LargeHerbivore species = it.next();
			XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
			series.setName(species.getName());
			for (int i = 0; i <= timeRange; i++) {
				int population = preserve.getState(i).getSpecies(species.getName()).getCurrentPopulation();
				series.getData().add(new XYChart.Data<Number, Number>(i, population));
			}
			lineChart.getData().add(series);
		}
	}

	public void showSpecies() {
		if(!selectedYearField.getText().equals("") && Integer.parseInt(selectedYearField.getText())<300) {
			selectedYear = Integer.parseInt(selectedYearField.getText());
		} else {
			selectedYearField.setText("0");
		}
		preserve.getState(selectedYear);
		speciesColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		popColumn.setCellValueFactory(cellData -> cellData.getValue().currentPopulationProperty());
		speciesList.clear();

		speciesList.addAll(preserve.getDifferentSpecies());
		populationTable.setItems(speciesList);
	}

	@FXML
	public void handleOk() {
		handleShowGraph();
		showSpecies();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void update(Observable o, Object arg) {
		showSpecies();
	}
}
