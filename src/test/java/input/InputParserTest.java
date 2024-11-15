package input;

import model.CompassDirection;
import model.Instruction;
import plateau.PlateauSize;
import model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    public void test_ParsePlateauSizeWithValidInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "5 5";

        // Act
        PlateauSize plateau = parser.parsePlateauSize(input);

        // Assert
        assertEquals(5, PlateauSize.getWidth());
        assertEquals(5, PlateauSize.getHeight());
    }

    @Test
    public void test_ParsePlateauSizeWithInvalidInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "5";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                parser.parsePlateauSize(input)
        );
        assertEquals("Invalid format for plateau size: 5", exception.getMessage());
    }

    @Test
    public void test_ParsePositionWithValidInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "1 2 N";
        parser.parsePlateauSize("5 5");
        // Act
        Position position = parser.parsePosition(input);

        // Assert
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(CompassDirection.N, position.getFacing());
    }

    @Test
    public void test_ParsePositionWithInvalidInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "1 2";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                parser.parsePosition(input)
        );
        assertEquals("Invalid format for position: 1 2", exception.getMessage());
    }
    @Test
    public void test_ParseInstructionsWithValidInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "LMLMLMLMM";

        // Act
        List<Instruction> instructions = parser.parseInstructions(input);

        // Assert
        assertEquals(9, instructions.size());
        assertEquals(Instruction.L, instructions.get(0));
        assertEquals(Instruction.M, instructions.get(1));
        assertEquals(Instruction.L, instructions.get(2));
    }
    @Test
    public void test_ParseInstructionsWithInvalidInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "LMX";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                parser.parseInstructions(input)
        );
        assertEquals("Invalid Instruction: X", exception.getMessage());
    }
    @Test
    public void test_ParseInstructionsWithEmptyInput() {
        // Arrange
        InputParser parser = new InputParser();
        String input = "";

        // Act
        List<Instruction> instructions = parser.parseInstructions(input);

        // Assert
        assertEquals(0, instructions.size());
    }
}