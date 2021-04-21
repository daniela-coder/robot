package com.sample.robot.events;

import com.sample.robot.grid.Grid;
import com.sample.robot.states.Direction;
import com.sample.robot.states.Position;
import com.sample.robot.states.RobotState;
import lombok.ToString;

@ToString
public class PositionEvent extends Event {

    Position position;
    Direction direction;

    public PositionEvent(EventName eventName, Position position, Direction direction) {
        super(eventName);
        this.position = position;
        this.direction = direction;
    }

    public RobotState action(RobotState robotState, Grid grid) {
        return new RobotState(this.position, this.direction);
    }

}
