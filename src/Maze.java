import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Maze {

    private Cell[][] maze;
    private int rowNum;
    private int columnNum;

    public Maze(int rows, int columns) throws FileNotFoundException {
        maze = new Cell[rows+1][columns+1];
        rowNum = rows;
        columnNum = columns;
        for (int i = -1; i < rows; i++) {
            for (int j = -1; j < columns; j++) {
                maze[i+1][j+1] = new Cell();
                maze[i+1][j+1].setPosition(new Point(i, j));
            }
        }
        Scanner input = new Scanner(new File("E:\\Users\\Joakim\\Skoleting\\Opgaver\\Java\\Semester 3\\MazeRunner.txt"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] tokens = line.split(",");

            if (tokens.length == columns) {
                int count = 1;
                int row = Integer.parseInt(tokens[0]);
                for (int i = 0; i < columns-1; i++) {
                    String wall = tokens[count];
                    int asint = Integer.parseInt(wall.strip());
                    if (asint == 1) {
                        if (row != 0) {
                            maze[row+1][i+1].setSouth(true);
                            maze[row][i+1].setNorth(true);
                        }
                        else {
                            maze[row+1][i+1].setSouth(true);
                            maze[row][i+1].setNorth(true);
                        }
                    }
                    count++;
                }
            }
            else if (tokens.length == rows) {
                int count = 1;
                int col = Integer.parseInt(tokens[0]);
                for (int i = 0; i < rows-1; i++) {
                    String wall = tokens[count];
                    int asint = Integer.parseInt(wall.strip());
                    if (asint == 1) {
                        if (col != 0) {
                            maze[i+1][col+1].setWest(true);
                            maze[i+1][col].setEast(true);
                        }
                        else {
                            maze[i+1][col+1].setWest(true);
                            maze[i+1][col].setEast(true);
                        }
                    }
                    count++;
                }
            }
        }
        for (Cell[] c :maze) {
            for (Cell d :c) {
                System.out.println(d);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(maze);
    }

    public Cell[][] getMaze() {
        return maze;
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }
}
