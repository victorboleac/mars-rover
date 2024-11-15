package vehicle;

import plateau.PlateauSize;
import model.Instruction;
import model.Position;

import java.util.List;

public abstract class MarsVehicle {

    private Position position;

    public MarsVehicle(Position initialPosition) {
        System.out.println("\033[38;5;226m"+this.getClass().getSimpleName()+" successfully created \033[0m");
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
            turnRight();
            adjustToGrid();
        }
    }

    public void adjustToGrid() {

        while (!PlateauSize.isInsideTheGrid(position.getX(), position.getY())) {

                switch (position.getFacing()) {
                    case E -> position.setY(PlateauSize.getHeight());
                    case S -> position.setX(PlateauSize.getWidth());
                    case W -> position.setY(0);
                    case N -> position.setX(0);
                }
            }
        }
// lunch time

    public Position getPosition() {
        return position;
    }

}
