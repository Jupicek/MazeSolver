package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    int rows = 5;
    int columns = 5;

    @Override
    public void start(Stage primaryStage) {
        try {
            /*Pane pane = new Pane();

            MazeGrid mazeGrid = new MazeGrid( columns, rows);

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {

                    Cell cell = new Cell(column, row);


                    mazeGrid.CreateCell(cell, column, row);
                }
            }*/
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

