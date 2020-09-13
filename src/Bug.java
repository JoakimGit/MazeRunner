import java.awt.*;
import java.util.Arrays;

public class Bug {
    private Point start;
    private Point end;
    private Point position;

    public Bug() {
    }

    public void findEntranceAndExit(Maze maze) {
        findStart(maze);
        findEnd(maze);
    }

    public void findStart(Maze maze) {
        Cell[][] fullMaze = maze.getMaze();
        Cell[] bottomRow = fullMaze[0];
        for (Cell c : bottomRow) {
            if (!c.isSouth()) {
                setStart(c.getPosition());
                break;
            }
        }
    }

    public void findEnd(Maze maze) {
        for (Cell[] c : maze.getMaze()) {
            for (Cell d : c) {
                if (d.getPosition().getX() == maze.getRowNum()-1 && !d.isSouth()) {
                    System.out.println("It's me");
                    setEnd(d.getPosition());
                    break;
                }
                else if (d.getPosition().getY() == 0 && !d.isWest() && d.getPosition().getX() < maze.getRowNum() -1) {
                    System.out.println("No me");
                    setEnd(d.getPosition());
                    break;
                }
                else if (d.getPosition().getY() == maze.getColumnNum()-1 && !d.isWest()) {
                    System.out.println("You're both wrong");
                    setEnd(d.getPosition());
                    break;
                }
            }
        }
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

    @Override
    public String toString() {
        return "Bug{" +
                "start=" + start +
                ", end=" + end +
                ", position=" + position +
                '}';
    }
}
