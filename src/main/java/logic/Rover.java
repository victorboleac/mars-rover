package logic;


public class Rover extends MarsVehicle{
    private final int SPEED = 1;
    public Rover(Position initialPosition) {
        super(initialPosition);

    }

    @Override
    public void performAction() {
        moveForward(SPEED);
    }


//    public static void main(String[] args) {
//        Position position = new Position(2, 2, CompassDirection.N);
//        Rover rover = new Rover(position);
//
//        rover.turnRight();
//        rover.performAction();
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY());
//    }
}
