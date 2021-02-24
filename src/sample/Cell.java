package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    int row;
    int column;


    public Cell(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    public void WallChange()
    {
        this.setFill(Color.BLACK);
    }
}
