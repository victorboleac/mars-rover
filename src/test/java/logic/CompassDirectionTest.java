package logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompassDirectionTest {

    @Test
    @DisplayName("Testing turning left")
    void test_turnLeft() {
        //Arrange
        CompassDirection nDirection = CompassDirection.N;
        //Act
        CompassDirection wDirection = nDirection.turnLeft();
        CompassDirection sDirection = wDirection.turnLeft();
        CompassDirection eDirection = sDirection.turnLeft();
        CompassDirection direction360 = eDirection.turnLeft();
        //Assert
        assertEquals(wDirection, CompassDirection.W);
        assertEquals(sDirection, CompassDirection.S);
        assertEquals(eDirection, CompassDirection.E);
        assertEquals(direction360, nDirection);
    }

    @Test
    @DisplayName("Testing turning right")
    void test_turnRight() {
        //Arrange
        CompassDirection nDirection = CompassDirection.N;
        //Act
        CompassDirection eDirection = nDirection.turnRight();
        CompassDirection sDirection = eDirection.turnRight();
        CompassDirection wDirection = sDirection.turnRight();
        CompassDirection direction360 = wDirection.turnRight();
        //Assert
        assertEquals(wDirection, CompassDirection.W);
        assertEquals(sDirection, CompassDirection.S);
        assertEquals(eDirection, CompassDirection.E);
        assertEquals(direction360, nDirection);

    }
    @Test
    @DisplayName("Testing an list of instructions")
    void test_CompassDirectionWithAListOfInstructions(){
        //Arrange
        char[] instructions = {'R', 'R', 'L', 'R', 'R'};
        CompassDirection initialDirection = CompassDirection.N;
        // Act
        for (char c:instructions) {
            if(c=='R') {initialDirection= initialDirection.turnRight();}
            else initialDirection= initialDirection.turnLeft();

        }
        //Assert
        assertEquals(initialDirection, CompassDirection.W);
    }
}