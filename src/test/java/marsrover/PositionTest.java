package marsrover;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("Testing constructor and getters")
    void test_positionSConstructorAndGetters(){
        //Arrange
        CompassDirection direction = CompassDirection.N;
        //Act
        Position position = new Position(1,2, direction);
        //Assert
        assertAll(
                () -> assertEquals(1, position.getX()),
                () -> assertEquals(2, position.getY()),
                () -> assertEquals(direction, position.getFacing())
        );

    }


}