package logic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeTest {
    @Test
    public void test_SingletonInstanceCreation() {
        // ARRANGE
        int width = 10;
        int height = 20;

        // ACT
        PlateauSize plateau = PlateauSize.getInstance(width, height);

        // ASSERT
        assertNotNull(plateau);
        assertEquals(width, plateau.getWidth());
        assertEquals(height, plateau.getHeight());
    }
    @Test
    public void test_SingletonSameInstance() {
        // ARRANGE
        int width1 = 10;
        int height1 = 20;
        int width2 = 30;
        int height2 = 40;

        // ACT
        PlateauSize plateau1 = PlateauSize.getInstance(width1, height1);
        PlateauSize plateau2 = PlateauSize.getInstance(width2, height2);

        // ASSERT
        assertSame(plateau1, plateau2);
        assertEquals(width1, plateau2.getWidth());
        assertEquals(height1, plateau2.getHeight());
    }
    @Test
    public void test_NegativeWidthOrHeight() {
        // ARRANGE & ACT & ASSERT
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PlateauSize.getInstance(-10, 20);
        });
        assertEquals("Height and Width must be positive", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            PlateauSize.getInstance(10, -20);
        });
        assertEquals("Height and Width must be positive", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            PlateauSize.getInstance(-10, -20);
        });
        assertEquals("Height and Width must be positive", exception.getMessage());
    }
    @Test
    public void test_ZeroWidthOrHeight() {
        // ARRANGE & ACT & ASSERT
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PlateauSize.getInstance(0, 20);
        });
        assertEquals("Height and Width must be positive", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            PlateauSize.getInstance(10, 0);
        });
        assertEquals("Height and Width must be positive", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            PlateauSize.getInstance(0, 0);
        });
        assertEquals("Height and Width must be positive", exception.getMessage());
    }
    @Test
    public void test_ValidWidthAndHeight() {
        // ARRANGE
        int width = 15;
        int height = 25;

        // ACT
        PlateauSize plateau = PlateauSize.getInstance(width, height);

        // ASSERT
        assertEquals(width, plateau.getWidth());
        assertEquals(height, plateau.getHeight());
    }
}