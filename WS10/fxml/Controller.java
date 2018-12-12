package fxml;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
public class Controller extends VBox{
	@FXML private TextField URLText;
	@FXML private TextField nameText;
	@FXML private Button downloadButton;
	@FXML private Button exitButton;
	
	public Controller() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("html.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
			URLText.setPromptText("Please enter URL");
			nameText.setPromptText("Please enter filename");
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	@FXML
	public void downloadApplication() {
		try {
			String s;
			URL url = new URL(URLText.getText());
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedWriter out = new BufferedWriter(new FileWriter(nameText.getText()));
			while ((s = in.readLine()) != null) {
				out.write(s + "\n");
			}
			out.close();
			downloadButton.setStyle("-fx-background-color: green;");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			downloadButton.setStyle("-fx-background-color: red;");
		}
	}
	@FXML
	public void exitApplication() {
		System.exit(1);
	}
}
