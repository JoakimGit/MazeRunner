import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Lav ny labyrint med et antal rækker og kolonner
        Maze maze = new Maze(6, 7);
        // Sæt væggene i labyrinten
        maze.createWalls();
        // Lav et insekt og find indgang/udgang
        Bug myBug = new Bug();
        myBug.findEntranceAndExit(maze);
        // Traverser igennem labyrinten og tag tid
        long startTime = System.currentTimeMillis();
        myBug.traverseMaze();
        long endTime = System.currentTimeMillis();
        long millis = endTime - startTime;
        System.out.println("The bug took: " + millis + " milliseconds to find its way through the maze");
    }
}
