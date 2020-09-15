import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Maze {

    private Cell[][] maze;
    private int rowNum;
    private int columnNum;

    public Maze(int rows, int columns) {
        maze = new Cell[rows +1][columns +1];
        rowNum = rows;
        columnNum = columns;
        for (int i = -1; i < rows; i++) {
            for (int j = -1; j < columns; j++) {
                maze[i + 1][j + 1] = new Cell();
                maze[i + 1][j + 1].setPosition(new Point(i, j));
            }
        }
    }

    public void createWalls() throws FileNotFoundException {
        Scanner input = new Scanner(new File("E:\\Users\\Joakim\\Skoleting\\Opgaver\\Java\\Semester 3\\MazeRunner-2.txt"));
        input.nextLine();
        String[] tokens;
        boolean columnSwitch = false;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.length() == 1) {
                columnSwitch = true;
                continue;
            }
            else {
                tokens = line.split(",");
            }
            if (!columnSwitch) {
                int row = Integer.parseInt(tokens[0]);
                int count = 1;
                for (int i = 0; i < columnNum-1; i++) {
                    String wall = tokens[count];
                    int isWall = Integer.parseInt(wall.strip());
                    if (isWall == 1) {
                        maze[row+1][i+1].setSouth(true);
                        maze[row][i+1].setNorth(true);
                    }
                    count++;
                }
            }
            else {
                int col = Integer.parseInt(tokens[0]);
                int count = 1;
                for (int i = 0; i < rowNum-1; i++) {
                    String wall = tokens[count];
                    int isWall = Integer.parseInt(wall.strip());
                    if (isWall == 1) {
                        maze[i+1][col+1].setWest(true);
                        maze[i+1][col].setEast(true);
                    }
                    count++;
                }
            }
        }
    }

    public void printMaze() {
        for (Cell[] c : maze) {
            for (Cell d : c) {
                System.out.println(d);
            }
        }
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

    @Override
    public String toString() {
        return Arrays.toString(maze);
    }
}
