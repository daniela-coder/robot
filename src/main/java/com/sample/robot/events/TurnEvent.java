package com.sample.robot.events;

import com.sample.robot.grid.Grid;
import com.sample.robot.states.Direction;
import com.sample.robot.states.RobotState;
import lombok.ToString;

@ToString
public class TurnEvent extends Event {

    Direction direction;

    public TurnEvent(EventName eventName, Direction direction) {
        super(eventName);
        this.direction = direction;
    }

    public RobotState execute(RobotState currentRobotState, Grid grid) {
        Direction currentDirection = currentRobotState.getDirection();
        Direction targetDirection = Direction.calculateDirection(currentDirection, this.direction);
        return new RobotState(currentRobotState.getPosition(), targetDirection);
    }
}
