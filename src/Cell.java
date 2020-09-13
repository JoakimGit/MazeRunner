import java.awt.*;

public class Cell {
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;
    private String state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
                ", position=(" + (int) position.getX() + "," + (int) position.getY() + ")";
    }

    /*private static final char OPEN = 'o';
    private static final char VISITED = 'v';
    private static final char CLOSED = '#';
    private static final char ENTRANCE = 'e';
    private static final char EXIT = 'x';

    *//* Member variables. *//*
    private int row;
    private int column;
    private char state;

    *//* Constructor *//*
    public Cell(int row,int column,char code) {
        this.row = row;
        this.column = column;
        state = code;
    }

    *//* Accessor methods *//*
    public boolean isOpen() { return state == OPEN || state == ENTRANCE || state == EXIT; }
    public boolean isEntrance() { return state == ENTRANCE; }
    public boolean isExit() { return state == EXIT; }
    public int getRow() { return row; }
    public int getColumn() { return column; }
    public char toChar() {
        return state;
    }
    public String toString() {
        return "(" + row + "," + column + ":" + toChar() + ")";
    }

    *//* Mutator methods *//*
    public void markVisited() {
        if(state == OPEN)
            state = VISITED;
    }
    public void clearVisited() {
        if(state == VISITED)
            state = OPEN;
    }*/
}
