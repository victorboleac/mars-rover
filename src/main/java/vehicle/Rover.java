package vehicle;


import plateau.PlateauSize;
import model.CompassDirection;
import model.Position;

public class Rover extends MarsVehicle{
    private final int SPEED = 1;
    public Rover(Position initialPosition) {
        super(initialPosition);

    }

    @Override
    public void moveForward() {
        int x = getPosition().getX();
        int y = getPosition().getY();

        switch (getPosition().getFacing()){
                case N -> y+=SPEED;
                case E -> x+=SPEED;
                case S -> x-=SPEED;
                case W -> y-=SPEED;
            }
            validatePosition(x,y);

        }





//    public static void main(String[] args) {
//        PlateauSize.getInstance(5,5);
//        Position position = new Position(2, 2, CompassDirection.N);
//        Rover rover = new Rover(position);
//        rover.moveForward();
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY()+" "+
//                rover.getPosition().getFacing().toString());
//        rover.moveForward();
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY()+" "+
//                rover.getPosition().getFacing().toString());
//        rover.moveForward();
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY()+" "+
//                rover.getPosition().getFacing().toString());
//        rover.moveForward();
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY()+" "+
//                rover.getPosition().getFacing().toString());
//        rover.moveForward();
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY()+" "+
//                rover.getPosition().getFacing().toString());
//        rover.turnRight();
//
//
//        System.out.println(rover.getPosition().getX()+" " + rover.getPosition().getY()+" "+
//                rover.getPosition().getFacing().toString());
//    }
}
