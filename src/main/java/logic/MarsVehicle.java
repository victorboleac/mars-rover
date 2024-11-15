package logic;

import java.util.List;

public abstract class MarsVehicle {
    private Position position;

    public MarsVehicle(Position initialPosition){
        this.position = initialPosition;
    }

    public void executeInstructions(List<Instruction> instructions){
        instructions.forEach(this::move);
    }
    public void move(Instruction instruction){
        switch (instruction){
            case L -> turnLeft();
            case M -> performAction();
            case R -> turnRight();
            default -> throw new IllegalArgumentException(this.getClass().getSimpleName()+" doesn't recognise this " +
            "instruction");
        }
    }

    public abstract void performAction();
    public void turnLeft(){
        position.setFacing(position.getFacing().turnLeft());
    }
    public void turnRight(){
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
    public void validatePosition(int x, int y){
        if(x >= 0 && x <= PlateauSize.getWidth() && y >= 0 && y <= PlateauSize.getHeight()) {
            position.setX(x);
            position.setY(y);
        }

        if(x < 0 || x > PlateauSize.getWidth() || y < 0 || y > PlateauSize.getHeight()){
            while (x < 0 || x > PlateauSize.getWidth() || y < 0 || y > PlateauSize.getHeight()){
                switch (position.getFacing()){
                    case N -> y = PlateauSize.getHeight();
                    case E -> x = PlateauSize.getWidth();
                    case S -> y = 0;
                    case W -> x = 0;
                }
                turnRight();
            }
        }
        position.setX(x);
        position.setY(y);
    }

}
