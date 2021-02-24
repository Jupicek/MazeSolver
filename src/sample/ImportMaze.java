package sample;

import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class ImportMaze {
    File maze;
    String text;
    int[][] mazeMatrix;
    public ImportMaze(int[][] matrix){
        this.mazeMatrix = matrix;

    }
    public void ReadFile() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.TXT");
        fileChooser.getExtensionFilters().addAll(extFilterTXT);

        maze = fileChooser.showOpenDialog(null);

        Scanner sc = new Scanner(new BufferedReader(new FileReader(maze)));
        while(sc.hasNextLine()) {
            for (int i = 0; i < mazeMatrix.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    mazeMatrix[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(mazeMatrix));

    }
}
