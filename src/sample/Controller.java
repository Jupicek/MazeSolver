package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    int rows = 8;
    int columns = 8;
    @FXML
    private Pane mazePane;
    @FXML
    private Button importButton;

    MazeGrid mazeGrid;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("nacteno");
        mazeGrid = new MazeGrid(columns, rows);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                Cell cell = new Cell(column, row);


                mazeGrid.CreateCell(cell, column, row);
                mazePane.getChildren().add(cell);

            }
        }

    }

    @FXML
    void importMazeButtonAction(ActionEvent event) throws FileNotFoundException {
        int[][] matrix;
        ImportMaze readFileMaze = new ImportMaze(rows,columns);
        matrix = readFileMaze.ReadFile();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] == 1)
                {
                    mazeGrid.cells[row][column].WallChange();
                }

            }
        }





    }
}
