package com.sample.robot.events;

import com.sample.robot.grid.Grid;
import com.sample.robot.states.Direction;
import com.sample.robot.states.Position;
import com.sample.robot.states.RobotState;
import lombok.ToString;

@ToString
public class ForwardEvent extends Event {

    int stepNumber;

    public ForwardEvent(EventName eventName, int stepNumber) {
        super(eventName);
        this.stepNumber = stepNumber;
    }

    public RobotState action(RobotState robotState, Grid grid) {
        Position position = robotState.getPosition();
        Direction direction = robotState.getDirection();
        Position newPosition;
        switch (direction) {
            case NORTH:
                newPosition = new Position(position.row - stepNumber, position.column);
                break;
            case SOUTH:
                newPosition = new Position(position.row + stepNumber, position.column);
                break;
            case EAST:
                newPosition = new Position(position.row, position.column + stepNumber);
                break;
            case WEST:
                newPosition = new Position(position.row, position.column - stepNumber);
                break;
            default:
                newPosition = position;
        }
        if (!fitsTheGrid(newPosition, grid)) {
            return robotState;
        }
        return new RobotState(newPosition, direction);
    }

    private boolean fitsTheGrid(Position position, Grid grid) {
        return position.column < grid.getColumnNumber() &&
                position.row < grid.getRowNumber() &&
                position.column >= 0 &&
                position.row >= 0;
    }

}
