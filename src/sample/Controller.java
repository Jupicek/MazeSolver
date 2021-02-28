package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    int rows = 8;
    int columns = 8;
    @FXML
    private Pane mazePane;
    private changeMazeDialogController secondController;


    MazeGrid mazeGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resizeMaze(rows, columns);

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
                    mazeGrid.cells[row][column].wall = 1;
                }
            }
        }
    }

    @FXML
    void clearMazeButtonAction(ActionEvent event) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                mazeGrid.cells[row][column].FieldChange();
            }
        }
    }
    @FXML
    void changeMazeDialog(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changeMazeDialogsample.fxml"));

        Parent root = fxmlLoader.load();
        secondController = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 360, 219));
        stage.showAndWait();
        while(true)
        {
            if (secondController.result == 1)
            {
                resizeMaze(secondController.rows,
                        secondController.columns);
                return;
            }
        }

    }


    public void resizeMaze(int mazeRows, int mazeColumns)
    {
        mazePane.getChildren().clear();
        mazeGrid = new MazeGrid(mazeRows, mazeColumns);
        for (int row = 0; row < mazeRows; row++) {
            for (int column = 0; column < mazeColumns; column++) {

                Cell cell = new Cell(column, row);
                cell.setOnMousePressed(evt -> {
                    if (cell.wall == 1) {
                        cell.FieldChange();
                    }
                    else {
                        cell.WallChange();
                    }

                });
                mazeGrid.CreateCell(cell, column, row);
                mazePane.getChildren().add(cell);
            }
        }
    }
}
