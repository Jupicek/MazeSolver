package sample;

import javafx.scene.layout.Pane;

public class MazeGrid extends Pane {
    int rows;
    int columns;
    Cell[][] cells;

    public MazeGrid(int rows,int columns){
        this.rows = rows;
        this.columns = columns;

        cells = new Cell[this.rows][this.columns];
    }
    public void CreateCell(Cell cell, int row, int column){
        cell.setLayoutX(51 * column);
        cell.setLayoutY(51 * row);
        cell.setWidth(50);
        cell.setHeight(50);

        cells[row][column] = cell;
        getChildren().add(cell);
    }
}
