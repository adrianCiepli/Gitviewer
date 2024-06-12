package application;
	
/**
 * @author Adrian Cieplicki
 * date 06/12/2024
 * A GUI application for viewing adrianCiepli's GitHub account page
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/**
 * Main class of the GUI application
 */
public class Main extends Application {
	
	/**
	 * Start method for the GUI's stage
	 * @param primaryStage The main stage of the GUI application
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		// Link to fxml file
		Parent root = FXMLLoader.load(
				getClass().getResource("/view/Main.fxml")
		);
		
		// Stage and scene setup
		Scene scene = new Scene(root);
	
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}