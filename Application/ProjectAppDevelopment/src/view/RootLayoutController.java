package view;

import java.io.IOException;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootLayoutController {
	@FXML
	private void handleExit() {
		System.exit(0);
	}
	@FXML
	private void handleShowAssumptions() {
		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("../view/AssumptionsDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Assumptions");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MainApp.getPrimaryStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
