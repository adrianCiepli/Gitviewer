package controller;

/**
 * @author Adrian Cieplicki
 * date 06/12/2024
 * The controller for the login scene
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import data.Database;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Login Controller Class
 */
public class LoginController implements Initializable {

	// FXML object injection
		@FXML private Label header;
		@FXML private Rectangle headerRect;
		@FXML private TextField userField;
		@FXML private Rectangle userRect;
		@FXML private PasswordField passField;
		@FXML private Rectangle passRect;
		@FXML private Label wrongInput;
		
		// Methods and objects to run and initialize on startup
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			// Have the header of the registration scene fade in
			FadeTransition headerFade = new FadeTransition();
			headerFade.setNode(header);
			headerFade.setFromValue(0.0);
			headerFade.setToValue(1.0);
			headerFade.setDuration(Duration.seconds(2.0));
			headerFade.play();
			
			// Have a cosmetic rectangle under the header fade in with it, slightly slower
			FadeTransition headerRectFade = new FadeTransition();
			headerRectFade.setNode(headerRect);
			headerRectFade.setFromValue(0.0);
			headerRectFade.setToValue(1.0);
			headerRectFade.setDuration(Duration.seconds(3.0));
			headerRectFade.play();
			
		}
		
		/**
		 * Displays a line under the username field when the field is clicked on
		 */
		public void userClickOn() {
			// Fade in animation for the username field line
			FadeTransition fade = new FadeTransition();
			fade.setNode(userRect);
			fade.setFromValue(0.0);
			fade.setToValue(1.0);
			fade.setDuration(Duration.seconds(0.15));
			fade.play();
			
			// Fade out the password field line if it is currently displayed when the username field is clicked on
			if (passRect.getOpacity() == 1.0) {
				FadeTransition passUser = new FadeTransition();
				passUser.setNode(passRect);
				passUser.setFromValue(1.0);
				passUser.setToValue(0.0);
				passUser.setDuration(Duration.seconds(0.15));
				passUser.play();
			}
		}
		
		/**
		 * Displays a line under the password field when the field is clicked on
		 */
		public void passClickOn() {
			// Fade in animation for the password field line
			FadeTransition fade = new FadeTransition();
			fade.setNode(passRect);
			fade.setFromValue(0.0);
			fade.setToValue(1.0);
			fade.setDuration(Duration.seconds(0.15));
			fade.play();
			
			// Fade out the username field line if it is currently displayed when the password field is clicked on
			if (userRect.getOpacity() == 1.0) {
				FadeTransition fadeUser = new FadeTransition();
				fadeUser.setNode(userRect);
				fadeUser.setFromValue(1.0);
				fadeUser.setToValue(0.0);
				fadeUser.setDuration(Duration.seconds(0.15));
				fadeUser.play();
			}
		}
		
		/**
		 * Fades out any currently displaying field lines if the user clicks anywhere  on the background of the scene
		 */
		public void userClickOff() {
			// Create fade animation objects for both the username and password field lines
			FadeTransition fadeUser = new FadeTransition();
			FadeTransition fadePass = new FadeTransition();
			
			// Check if the username rectangle is opaque and fades if necessary
			if (userRect.getOpacity() == 1.0) {
				fadeUser.setNode(userRect);
				fadeUser.setFromValue(1.0);
				fadeUser.setToValue(0.0);
				fadeUser.setDuration(Duration.seconds(0.5));
				fadeUser.play();
			}
			
			// Check if the username rectangle is opaque and fades if necessary
			if (passRect.getOpacity() == 1.0) {
				fadePass.setNode(passRect);
				fadePass.setFromValue(1.0);
				fadePass.setToValue(0.0);
				fadePass.setDuration(Duration.seconds(0.5));
				fadePass.play();
			}
		}
	
	/**
	 * When the login button is pressed, checks if the username and password match the saved instances in the database, and if so, switches to GitHub viewing scene
	 * @param e Event object for when the method is called by the register button being pressed
	 * @throws IOException Do not load an fxml file that does not exist
	 */
	public void login(ActionEvent e) throws IOException {
		
		// Check inputted username and password against the database
		if (userField.getText().equals(Database.username) && passField.getText().equals(Database.password)) {
			// Display the GitHub viewing scene
			Parent root = FXMLLoader.load(getClass().getResource("/view/Git.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} 
		else {
			// Display invalid username or password message
			wrongInput.setVisible(true);
		}
	}
	
}