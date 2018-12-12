package separate;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ExitHandler implements EventHandler<MouseEvent>{
	public ExitHandler() {
		
	}
	public void handle(MouseEvent e) {
		System.exit(1);
	}
}
