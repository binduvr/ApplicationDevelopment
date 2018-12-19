package application;

import java.io.IOException;
import java.util.TreeSet;

import domain.NaturePreserve;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import species.HeckCattle;
import species.KonikHorse;
import species.LargeHerbivore;
import species.RedDeer;
import view.StatisticsViewController;

public class MainApp extends Application {
	
	private static Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		MainApp.primaryStage = primaryStage;
		MainApp.primaryStage.setTitle("ProjectAP v1.0");

		initData();
		initRootLayout();
		initStatisticsView();
	}
	
	public void initData() {
		LargeHerbivore deer = new RedDeer();
		LargeHerbivore horse = new KonikHorse();
		LargeHerbivore cow = new HeckCattle();
		TreeSet<LargeHerbivore> set = new TreeSet<LargeHerbivore>();
		set.add(deer);
		set.add(horse);
		set.add(cow);
		NaturePreserve.instance(set);
	}
	
	public void initRootLayout() {
		try {
	        // Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
            // Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initStatisticsView() {
		//Init species
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/StatisticsView.fxml"));
			AnchorPane content = (AnchorPane) loader.load();
			
			rootLayout.setCenter(content);
			StatisticsViewController controller = loader.getController();
			controller.setMainApp(this);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
