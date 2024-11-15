package logic;

import model.CompassDirection;
import model.Position;
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
    @Test
    @DisplayName("Testing setters")
    void test_positionSetters(){
        //Arrange
        CompassDirection direction = CompassDirection.N;
        Position position = new Position(0,0, direction);
        //Act
        position.setX(5);
        position.setY(10);
        position.setFacing(CompassDirection.W);
        //Assert
        assertAll(
                () -> assertEquals(5, position.getX()),
                () -> assertEquals(10, position.getY()),
                () -> assertEquals(CompassDirection.W, position.getFacing())
        );

    }


}