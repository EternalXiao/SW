package fxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HtmlReadMain extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Controller control = new Controller();
		stage.setScene(new Scene(control,500,200));
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
