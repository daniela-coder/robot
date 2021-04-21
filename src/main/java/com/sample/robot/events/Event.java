package com.sample.robot.events;

import com.sample.robot.grid.Grid;
import com.sample.robot.states.RobotState;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public abstract class Event {

    EventName eventName;

    public abstract RobotState action(RobotState robotState, Grid grid);

}
