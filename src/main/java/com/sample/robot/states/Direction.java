package com.sample.robot.states;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Direction {

    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270),
    RIGHT(90),
    TURN(90),
    TURNAROUND(180);

    public int absoluteValue;

    Direction(int absoluteValue) {
        this.absoluteValue = absoluteValue;
    }

    private static Direction getDirectionFromAbsoluteValue(int absoluteValue) {
        Stream<Direction> directionStream = Arrays.stream(Direction.values())
                .filter(direction -> direction.absoluteValue == absoluteValue);
        return directionStream.findFirst().orElseThrow(IllegalStateException::new);
    }

    public static Direction calculateDirection(Direction currentDirection, Direction targetDirection) {
        Direction compassTargetDirection;
        int targetDirectionAbsoluteValue = currentDirection.absoluteValue + targetDirection.absoluteValue;
        if (targetDirectionAbsoluteValue >= 360) {
            compassTargetDirection = Direction.getDirectionFromAbsoluteValue(
                    Direction.NORTH.absoluteValue + (targetDirectionAbsoluteValue - 360)
            );
        } else {
            compassTargetDirection = Direction.getDirectionFromAbsoluteValue(targetDirectionAbsoluteValue);
        }
        return compassTargetDirection;
    }

}
