package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    int row;
    int column;
    int wall = 0;
    int start = 0;
    int finnish = 0;


    public Cell(int row, int column)
    {
        this.row = row;
        this.column = column;
        this.setStroke(Color.BLACK);
        this.setFill(Color.WHITE);
    }
    public void WallChange()
    {
        this.setFill(Color.BLACK);
        wall = 1;
    }
    public void FieldChange()
    {
        this.setFill(Color.WHITE);
        wall = 0;
    }

}
