package model;

public enum CompassDirection {
    N,S,E,W;

    public CompassDirection turnRight(){
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }
    public CompassDirection turnLeft(){
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }
}
