package logic;

import java.util.List;

public abstract class MarsVehicle {

    private final Position position;

    public MarsVehicle(Position initialPosition) {
        this.position = initialPosition;

    }

    public void executeInstructions(List<Instruction> instructions) {
        instructions.forEach(this::executeInstruction);
    }

    public void executeInstruction(Instruction instruction) {
        switch (instruction) {
            case L -> turnLeft();
            case M -> moveForward();
            case R -> turnRight();
        }
    }

    public abstract void moveForward();

    public void turnLeft() {
        position.setFacing(position.getFacing().turnLeft());
    }

    public void turnRight() {
        position.setFacing((position.getFacing().turnRight()));
    }

    /* Logic for the vehicle when it is going out of borders
    1st  case - when the destination coordinates are inside the grid and just the way to the destination can go
    out of grid - it has just to reach the destination finding the shortest way
    2nd case - when the destination also is out of grid -
    it has to turn clockwise (turnRight) until the move is possible when it reaches any of bounds ignoring
    current instruction and continue next instructions as it is.

       FOR NOW WILL MAKE ALL THE CASES TO TURN RIGHT WHEN THE NEXT MOVEMENT IS OUT OF GRID
     */
    public void validatePosition(int x, int y) {
        if (PlateauSize.isInsideTheGrid(x, y)) {
            position.setX(x);
            position.setY(y);
        } else {
            adjustToGrid();
        }
    }

    private void adjustToGrid() {

        while (!PlateauSize.isInsideTheGrid(position.getX(), position.getY())) {
                switch (position.getFacing()) {
                    case N -> position.setY(PlateauSize.getHeight());
                    case E -> position.setX(PlateauSize.getWidth());
                    case S -> position.setY(0);
                    case W -> position.setX(0);
                }
                turnRight();
            }
        }


    public Position getPosition() {
        return position;
    }
    public void moveForward(int speed){
        int x = getPosition().getX();
        int y = getPosition().getY();

        switch (getPosition().getFacing()){
            case N -> y+=speed;
            case E -> x+=speed;
            case S -> x-=speed;
            case W -> y-=speed;
        }
        validatePosition(x,y);
        getPosition().setX(x);
        getPosition().setY(y);
    }
}
