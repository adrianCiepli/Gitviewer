package controller;

/**
 * @author Adrian Cieplicki
 * date 06/12/2024
 * The controller for the GitHub viewing scene
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * GitHub Viewing Controller Class
 */
public class GitController implements Initializable {

	// FXML object injection
	@FXML private WebView webView;
	@FXML private Label msgLabel;
	
	private WebEngine engine;
	
	// Methods and objects to run and initialize on startup
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Display the GitHub page on the web view
		engine = webView.getEngine();
		loadPage();
		
		// Set up pleading message to move left and right continuously
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(msgLabel);
		translate.setByX(385);
		translate.setDuration(Duration.seconds(10.0));
		translate.setAutoReverse(true);
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.play();
		
		// Set up pleading message to tilt left and right continuously
		RotateTransition rotate = new RotateTransition();
		rotate.setNode(msgLabel);
		rotate.setByAngle(20);
		rotate.setDuration(Duration.seconds(5.0));
		rotate.setAutoReverse(true);
		rotate.setCycleCount(RotateTransition.INDEFINITE);
		rotate.play();
	}
	
	/**
	 * Has the engine load the GitHub site to be displayed on the web view
	 */
	public void loadPage() {
		engine.load("https://github.com/adrianCiepli");
	}

}