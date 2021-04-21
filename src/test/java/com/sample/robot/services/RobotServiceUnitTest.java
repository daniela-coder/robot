package com.sample.robot.services;

import com.sample.robot.states.Direction;
import com.sample.robot.states.Position;
import com.sample.robot.states.RobotState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RobotServiceUnitTest {

    @Autowired
    RobotService robotService;

    @Test
    public void empty_script_returns_error() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            robotService.executeScript("");
        });

        String expectedMessage = "Script must be provided!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void valid_script_return_valid_robot_states() {

        List<RobotState> actualRobotState = robotService.executeScript(
                "POSITION 1 3 EAST \n" +
                "FORWARD 3 \n" +
                "WAIT \n" +
                "TURNAROUND \n" +
                "FORWARD 1 \n" +
                "RIGHT \n" +
                "FORWARD 2 \n");

        List<RobotState> expectedRobotStates = Arrays.asList(
                new RobotState(new Position(1, 3), Direction.EAST),
                new RobotState(new Position(1, 3), Direction.EAST),
                new RobotState(new Position(1, 3), Direction.EAST),
                new RobotState(new Position(1, 3), Direction.WEST),
                new RobotState(new Position(1, 2), Direction.WEST),
                new RobotState(new Position(1, 2), Direction.NORTH),
                new RobotState(new Position(1, 2), Direction.NORTH)
        );
        assertEquals(expectedRobotStates, actualRobotState);
    }

}
