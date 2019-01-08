package view;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import application.MainApp;
import domain.NaturePreserve;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

	private int timeRange;
	private int selectedYear;
	private static ObservableList<LargeHerbivore> speciesList;
	private ObservableList<String> options;

	@FXML
	private void initialize() {
		speciesList = FXCollections.observableArrayList();
		options = FXCollections.observableArrayList("Exponential Growth","Logistic Growth", "Growth w/ Competition");
		timeRange = 20;
		selectedYear = 0;
		numYears.setText(Integer.toString(timeRange));
		selectedYearField.setText(Integer.toString(selectedYear));
		modelChoice.setItems(options);
		modelChoice.getSelectionModel().selectFirst();
		lineChart.setTitle("Animal Populations");
		lineChart.setCreateSymbols(false);
		
		selectedYearField.textProperty().addListener(ensureInt());
		numYears.textProperty().addListener(ensureInt());
		
		handleShowGraph();
		showSpecies();
	}

	public void handleShowGraph() {
		lineChart.getData().clear();
		NaturePreserve preserve = NaturePreserve.instance(null);

		// Doing this because switch isnt working
		if (modelChoice.getSelectionModel().getSelectedItem() == "Exponential Growth") {
			ModelFactory.setModel("EXP");
		} else if (modelChoice.getSelectionModel().getSelectedItem() == "Logistic Growth") {
			ModelFactory.setModel("LOG");
		} else {
			ModelFactory.setModel("LOT");
		}

		// Working on this

		if (!numYears.getText().equals("")) {
			timeRange = Integer.parseInt(numYears.getText().toString());
		} else {
			numYears.setText("20");
		}

		// Add this to a different thread that updates gui as it works
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
		if(!selectedYearField.getText().equals("")) {
			selectedYear = Integer.parseInt(selectedYearField.getText());
		} else {
			selectedYearField.setText("0");
		}
		NaturePreserve.instance(null).getState(selectedYear);
		speciesColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		popColumn.setCellValueFactory(cellData -> cellData.getValue().currentPopulationProperty());
		speciesList.clear();

		// Adds selection listener so it shows which time is selected
		lineChart.setOnMousePressed((MouseEvent event) -> {
			Point2D mouseSceneCoords = new Point2D(event.getSceneX(), event.getSceneY());
			int x = (int) Math.round(xAxis.sceneToLocal(mouseSceneCoords).getX());
			selectedYearField.setText(Integer.toString(xAxis.getValueForDisplay(x).intValue()));

		});
		speciesList.addAll(NaturePreserve.instance(null).getDifferentSpecies());
		populationTable.setItems(speciesList);
	}

	@FXML
	public void handleOk() {
		handleShowGraph();
		showSpecies();
	}

	public ChangeListener<String> ensureInt() {
		return new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	selectedYearField.setText(newValue.replaceAll("[^\\d]", ""));
		        	numYears.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		};
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void update(Observable o, Object arg) {
		showSpecies();
	}
}
