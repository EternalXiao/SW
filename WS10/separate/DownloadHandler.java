package separate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DownloadHandler implements EventHandler<MouseEvent>{
	private Button downloadButton;
	private TextField textfield1,textfield2;
	public DownloadHandler(Button downloadButton, TextField textfield1, TextField textfield2) {
		this.downloadButton = downloadButton;
		this.textfield1 = textfield1;
		this.textfield2 = textfield2;
	}
	public void handle(MouseEvent e) {
		try {
			String s;
			URL url = new URL(textfield1.getText());
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedWriter out = new BufferedWriter(new FileWriter(textfield2.getText()));
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
}
