import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bug {
    private Point start;
    private Point end;
    private Point position;
    private Maze maze;
    private final Stack<Point> path = new Stack<>();

    public Bug() {
    }

    public void findEntranceAndExit(Maze maze) {
        this.maze = maze;
        findEntrance();
        findExit();
    }

    public void findEntrance() {
        Cell[][] fullMaze = maze.getMaze();
        Cell[] bottomRow = fullMaze[0];
        // Loop through bottom row to find the missing wall, i.e. the entrance
        for (Cell c : bottomRow) {
            if (!c.isNorth() && c.getPosition().getY() > -1) {
                setStart(c.getPosition());
                setPosition(c.getPosition());
                return;
            }
        }
    }

    public void findExit() {
        for (Cell[] c : maze.getMaze()) {
            for (Cell d : c) {
                // Check if exit is at the top
                if (d.getPosition().getX() == maze.getRowNum()-1 && !d.isSouth() && d.getPosition().getY() > -1 && d.getPosition().getY() < maze.getColumnNum()-1) {
                    setEnd(d.getPosition());
                    return;
                }
                // Check if exit is on the left side
                else if (d.getPosition().getY() == -1 && !d.isEast() && d.getPosition().getX() > -1 && d.getPosition().getX() < maze.getRowNum()-1) {
                    setEnd(d.getPosition());
                    return;
                }
                // Check if exit is on the right side
                else if (d.getPosition().getY() == maze.getColumnNum()-1 && !d.isWest() && d.getPosition().getX() > -1 && d.getPosition().getX() < maze.getRowNum()-1) {
                    setEnd(d.getPosition());
                    return;
                }
            }
        }
    }

    public void traverseMaze() {
        Cell[][] myMaze = maze.getMaze();
        List<Point> branches = new ArrayList<>();

        System.out.println("Starting position is at: (" + (int) position.getX() + "," + (int) position.getY() + ")");
        // Move one stop so the bug is inside the maze. Then set that position and the previous one to visited.
        position.translate(1, 0);
        myMaze[position.x+1][position.y+1].setVisited(true);
        myMaze[position.x][position.y+1].setVisited(true);
        path.push(new Point(getPosition()));
        System.out.println("Current position is at: (" + (int) position.getX() + "," + (int) position.getY() + ")");

        boolean go = true;
        while (go) {
            int directions = 0;
            // Check to see if there are multiple paths from current position. If yes, save this position as a branch.
            if (!myMaze[position.x+1][position.y+1].isWest() && !myMaze[position.x+1][position.y].isVisited()) {
                directions++;
            }
            if (!myMaze[position.x+1][position.y+1].isNorth() && !myMaze[position.x+2][position.y+1].isVisited()) {
                directions++;
            }
            if (!myMaze[position.x+1][position.y+1].isEast() && !myMaze[position.x+1][position.y+2].isVisited()) {
                directions++;
            }
            if (!myMaze[position.x+1][position.y+1].isSouth() && !myMaze[position.x][position.y+1].isVisited()) {
                directions++;
            }
            if (directions > 1) {
                Point branch = new Point(getPosition());
                branches.add(branch);
                System.out.println("A branch is at: (" + (int) branch.getX() + "," + (int) branch.getY() + ")" + " with " + directions + " branches");
            }

            // Move left if possible. If not, then try north, then try east and finally try south.
            if (!myMaze[position.x+1][position.y+1].isWest() && !myMaze[position.x+1][position.y].isVisited()) {
                myMaze[position.x+1][position.y].setVisited(true);
                position.translate(0, -1);
                path.push(new Point(getPosition()));
                System.out.println("Current position is at: (" + (int) position.getX() + "," + (int) position.getY() + ")");
            }
            else if (!myMaze[position.x+1][position.y+1].isNorth() && !myMaze[position.x+2][position.y+1].isVisited()) {
                myMaze[position.x+2][position.y+1].setVisited(true);
                position.translate(1, 0);
                path.push(new Point(getPosition()));
                System.out.println("Current position is at: (" + (int) position.getX() + "," + (int) position.getY() + ")");
            }
            else if (!myMaze[position.x+1][position.y+1].isEast() && !myMaze[position.x+1][position.y+2].isVisited()) {
                myMaze[position.x+1][position.y+2].setVisited(true);
                position.translate(0, 1);
                path.push(new Point(getPosition()));
                System.out.println("Current position is at: (" + (int) position.getX() + "," + (int) position.getY() + ")");
            }
            else if (!myMaze[position.x+1][position.y+1].isSouth() && !myMaze[position.x][position.y+1].isVisited()) {
                myMaze[position.x][position.y+1].setVisited(true);
                position.translate(-1, 0);
                path.push(new Point(getPosition()));
                System.out.println("Current position is at: (" + (int) position.getX() + "," + (int) position.getY() + ")");
            }

            // If the bug couldn't go any direction, it's a dead end and it goes back to the most recent branch.
            else {
                System.out.println("Dead end has been reached, turning around");
                Point recentBranch = branches.get(branches.size() - 1);
                branches.remove(branches.size()-1);
                while (!path.empty() && !(path.peek().equals(recentBranch))) {
                    Point popped = path.pop();
                    System.out.println("Pop path coordinate (" + (int) popped.getX() + "," + (int) popped.getY() + ")");
                }
                position = recentBranch;
                System.out.println("We are back at position: (" + (int) position.getX() + "," + (int) position.getY() + ")");
            }
            // When out of maze, set go to false to stop the loop.
            if (position.equals(end)) {
                System.out.println("We've reached the end of the maze!");
                go = false;
            }
        }
        System.out.println("The route through the maze is " + path.size() + " steps, and is as follows:");
        printStack();
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void printStack() {
        if (path.isEmpty())
            return;

        Point coord = path.peek();
        path.pop();
        printStack();

        System.out.println("Coordinate: (" + (int) coord.getX() + "," + (int)  coord.getY() + ")");
        path.push(coord);
    }

    @Override
    public String toString() {
        return "Bug{" +
                "start=" + start +
                ", end=" + end +
                ", position=" + position +
                '}';
    }
}
