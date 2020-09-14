import java.awt.*;

public class Cell {
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;
    private boolean visited;
    private Point position;

    public Cell() {
    }

    public boolean isNorth() {
        return north;
    }

    public void setNorth(boolean north) {
        this.north = north;
    }

    public boolean isEast() {
        return east;
    }

    public void setEast(boolean east) {
        this.east = east;
    }

    public boolean isSouth() {
        return south;
    }

    public void setSouth(boolean south) {
        this.south = south;
    }

    public boolean isWest() {
        return west;
    }

    public void setWest(boolean west) {
        this.west = west;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Cell: " +
                "north=" + north +
                ", east=" + east +
                ", south=" + south +
                ", west=" + west +
                ", visited=" + visited +
                ", position=(" + (int) position.getX() + "," + (int) position.getY() + ")";
    }
}
