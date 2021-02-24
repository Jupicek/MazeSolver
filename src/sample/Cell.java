package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    int row;
    int column;
    int state;


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
    }
    public void FieldChange()
    {
        this.setFill(Color.WHITE);
    }

    }
