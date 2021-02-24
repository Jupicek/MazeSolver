package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class Controller {
    int rows = 5;
    int columns = 5;
    @FXML
    private Pane mazePane;
    public Controller()
    {
        MazeGrid mazeGrid = new MazeGrid( columns, rows);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                Cell cell = new Cell(column, row);


                mazeGrid.CreateCell(cell, column, row);
            }
        }
        mazePane.getChildren().add(mazeGrid);

    }


}
