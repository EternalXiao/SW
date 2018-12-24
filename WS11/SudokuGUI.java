import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SudokuGUI extends Application {
	public static final int WIDTH = 50;
	public static final int TOTAL_WIDTH = 14 * WIDTH;
	public static final int TOTAL_HEIGHT = 11 * WIDTH;
	public static final int OFFSET = 10;
	private static TextField[][] cells = new TextField[9][9];
	private static Button load, check, exit,solution;
	private static SudokuRead sudokuRead = new SudokuRead();
	private static Sudoku sudoku;
	private static Label prompt = new Label("");
	private final EventHandler<MouseEvent> eventHandlerLoad = e -> {
		try {
			sudoku = sudokuRead.readSudoku("sudoku"+(int)Math.ceil(10*Math.random())+".txt");
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (sudoku.getArray()[i][j] != 0)
						cells[i][j].setText(sudoku.getArray()[i][j] + "");
					else
						cells[i][j].setText("");
				}
			}
		} catch (Exception e1) {
			System.out.println("Invalid input sudoku");
		}
	};
	private final EventHandler<MouseEvent> eventHandlerCheck = e -> {
		int[][] sudokuArr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (cells[i][j].getText().length() > 0)
					sudokuArr[i][j] = Integer.parseInt(cells[i][j].getText());
				else
					sudokuArr[i][j] = 0;
			}
		}
		boolean[][] solved = SudokuCheck.check(new Sudoku(sudokuArr));
		boolean res = true;
		for(boolean[] elements:solved) {
			for(boolean element:elements) {
				res &= element;
			}
		}
		if(res) {
			prompt.setText("Congratulations!\nSudoku solved!");
		}
		else {
			prompt.setText("Still something Wrong.");
		}
	};
	private final EventHandler<MouseEvent> eventHandlerExit =e->{
		System.exit(1);
	};
	private final EventHandler<MouseEvent> eventHandlerSolution = e->{
		SudokuSolve.solve(sudoku);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				cells[i][j].setText(sudoku.getArray()[i][j]+"");
			}
		}
	};

	public void generateBoardLayout(Group root) {
		for (int i = 0; i < 10; i++) {
			Line l1 = new Line(WIDTH + WIDTH * i, WIDTH, WIDTH + WIDTH * i, 10 * WIDTH);
			Line l2 = new Line(WIDTH, WIDTH + WIDTH * i, 10 * WIDTH, WIDTH + WIDTH * i);
			if (i % 3 == 0) {
				l1.setStrokeWidth(3);
				l2.setStrokeWidth(3);
			}
			root.getChildren().add(l1);
			root.getChildren().add(l2);
		}
	}

	public void generateCell(Group root) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cells[i][j] = new TextField();
				cells[i][j].setLayoutX(WIDTH + OFFSET + WIDTH * j);
				cells[i][j].setLayoutY(WIDTH + OFFSET + WIDTH * i);
				cells[i][j].setPrefWidth(30);
				cells[i][j].setPrefHeight(30);
				root.getChildren().add(cells[i][j]);
			}
		}
	}

	public void addButtons(Group root) {
		load = new Button("Load Sudoku");
		check = new Button("Check solved");
		exit = new Button("Exit");
		solution = new Button("Solution");
		root.getChildren().add(load);
		root.getChildren().add(check);
		root.getChildren().add(exit);
		root.getChildren().add(solution);
		load.setLayoutX(TOTAL_HEIGHT);
		load.setLayoutY(1 * WIDTH);
		load.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerLoad);
		check.setLayoutX(TOTAL_HEIGHT);
		check.setLayoutY(3.67 * WIDTH);
		check.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCheck);
		exit.setLayoutX(TOTAL_HEIGHT);
		exit.setLayoutY(9 * WIDTH);
		exit.setPrefWidth(100);
		exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerExit);
		solution.setLayoutX(TOTAL_HEIGHT);
		solution.setLayoutY(6.33*WIDTH);
		solution.setPrefWidth(100);
		solution.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerSolution);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		generateBoardLayout(root);
		generateCell(root);
		addButtons(root);
		root.getChildren().add(prompt);
		Scene scene = new Scene(root, TOTAL_WIDTH, TOTAL_HEIGHT);
		stage.setScene(scene);
		stage.setTitle("Sudoku");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
