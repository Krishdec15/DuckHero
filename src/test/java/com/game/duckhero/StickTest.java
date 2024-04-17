package com.game.duckhero;

import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StickTest {
    @Test
    public void testIsStickFallen() {
        Line line = new Line(1,2,3,4);
        Stick stick = new Stick(line); //Initial value false
        assertFalse(stick.isStickFallen(), "Stick should not be fallen initially");
        stick.setStickStatus(true); //stick has fallen
        assertTrue(stick.isStickFallen(), "Stick should be fallen after falling action");
    }

}