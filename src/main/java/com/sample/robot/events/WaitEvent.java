package com.sample.robot.events;

import com.sample.robot.grid.Grid;
import com.sample.robot.states.RobotState;
import lombok.ToString;

@ToString
public class WaitEvent extends Event {

    public WaitEvent(EventName eventName) {
        super(eventName);
    }

    public RobotState execute(RobotState robotState, Grid grid) {
        return robotState;
    }
}
