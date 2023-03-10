package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	private Button exit,register,login;
	@FXML
	private Pane pane;
	
	Stage stage;
	
	@FXML
	private void initialize() {
		ImageView exitimg = new ImageView("closeimage.png");
		ImageView registerimg = new ImageView("register.png");
		ImageView loginimg = new ImageView("login.png");
		exitimg.setFitWidth(30);
		exitimg.setFitHeight(30);
		registerimg.setFitWidth(52);
		registerimg.setFitHeight(52);
		loginimg.setFitWidth(52);
		loginimg.setFitHeight(52);
		exit.setGraphic(exitimg);
		register.setGraphic(registerimg);
		login.setGraphic(loginimg);
	}
	
	@FXML
	private void login(ActionEvent e) {
	}
	
	@FXML
	private void close() {
		stage = (Stage) pane.getScene().getWindow();
		stage.hide();
	}
	
}
