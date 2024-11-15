import controller.MissionControl;
import input.InputParser;
import model.Instruction;
import model.Position;
import plateau.PlateauSize;
import vehicle.Rover;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MissionControl missionOne = new MissionControl();
        missionOne.printName();
        missionOne.printMarsRover();
        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser();

        System.out.print("Enter plateau size (x y): ");
        PlateauSize plateauSize = inputParser.parsePlateauSize(scanner.nextLine());
        System.out.print("Enter the initial position (x y direction): ");
        Position initialPosition = inputParser.parsePosition(scanner.nextLine());

        Rover rover = new Rover(initialPosition);

        System.out.print("Please enter the instructions (ex: LRMMMLR): ");
        List<Instruction> instructions = inputParser.parseInstructions(scanner.nextLine());
        missionOne.executeMission(rover, instructions);
        Position finalPosition = rover.getPosition();
        System.out.println("\033[38;5;226m" + "Final Position is: " + finalPosition.getX() + " " +
                finalPosition.getY() + " " + finalPosition.getFacing().toString()+ "\033[0m");


    }
}
