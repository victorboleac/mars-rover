package inputlayer;

import logic.CompassDirection;
import logic.Instruction;
import logic.PlateauSize;
import logic.Position;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public PlateauSize parsePlateauSize(String input){
        String[] coordinates = input.trim().split(" ");
        // checking if it has only 2 parts as we need only a coordinates
        if(coordinates.length!=2) throw new IllegalArgumentException("Invalid format for plateau size: "+ input);
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        return PlateauSize.getInstance(x,y);
    }

    public Position parsePosition(String input){
        String[] position = input.trim().split(" ");

        if(position.length!=3) throw new IllegalArgumentException("Invalid format for position: " + input);

        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);

        if(!PlateauSize.isInsideTheGrid(x,y)) throw new IllegalArgumentException("The position " +
                x + ";" + y + " is out of plateau size" );

        CompassDirection facing = CompassDirection.valueOf(position[2].toUpperCase());

        return new Position(x, y, facing);
    }
    public List<Instruction> parseInstructions(String input){
        List<Instruction> instructions = new ArrayList<>();
        for (char c: input.trim().toCharArray()) {
            instructions.add(Instruction.fromChar(c));
        }
        return instructions;
    }
}
