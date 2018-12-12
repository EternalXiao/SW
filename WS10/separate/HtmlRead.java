package separate;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class HtmlRead extends Application {
	Button downloadButton = new Button("Download");
	Button exitButton = new Button("Exit");
	TextField textfield1 = new TextField("Please enter URL");
	TextField textfield2 = new TextField("Please enter filename");

	@Override
	public void start(Stage stage) throws Exception {

		downloadButton.setLayoutX(70);
		downloadButton.setLayoutY(500);
		exitButton.setLayoutX(170);
		exitButton.setLayoutY(500);

		textfield1.setLayoutX(70);
		textfield1.setLayoutY(300);
		textfield1.setPrefWidth(300);
		textfield2.setLayoutX(70);
		textfield2.setLayoutY(400);
		DownloadHandler eventHandlerDownload= new DownloadHandler(downloadButton,textfield1,textfield2);
		ExitHandler eventHandlerExit = new ExitHandler();
		downloadButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerDownload);
		exitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerExit);

		Group root = new Group(downloadButton, exitButton, textfield1, textfield2);
		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
