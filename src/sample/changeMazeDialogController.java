package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class changeMazeDialogController {

    @FXML
    private TextField rowLabel;

    @FXML
    private TextField columnLabel;

    @FXML
    private Label errorInfoLabel;
    @FXML
    private Button generateButton;
    int result;
    int columns;
    int rows;

    public String returnRows()
    {
        return rowLabel.getText();
    }
    public String returnColumns()
    {
        return columnLabel.getText();
    }

    @FXML
    void generateNewMaze(ActionEvent event) {
        rows = Integer.parseInt(rowLabel.getText());
        columns = Integer.parseInt(columnLabel.getText());
        result = 1;


        Stage stage = (Stage) generateButton.getScene().getWindow();
        stage.close();

    }
    @FXML
    boolean checkInputNumberRows() {
        try {
            int number = Integer.parseInt(rowLabel.getText());
            if(number <= 0)
            {
                errorInfoLabel.setText("Set not 0 number");
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (Exception ex)
        {
            errorInfoLabel.setText("Rows must be in int");
            return false;
        }

    }
    @FXML
    boolean checkInputNumberColumns() {
        int number = 0;
        try {
            number = Integer.parseInt(columnLabel.getText());
            if(number <= 0)
            {
                errorInfoLabel.setText("Set not 0 number");
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (Exception ex)
        {
            errorInfoLabel.setText("Columns must be in int");
            return false;
        }

    }
    @FXML
    void numberCheck(KeyEvent event) {
        String ch = event.getText();
        try
        {
            Integer.parseInt(ch);
            errorInfoLabel.setText("");
        }
        catch (Exception ex)
        {
            errorInfoLabel.setText("Not number");
        }
    }
}