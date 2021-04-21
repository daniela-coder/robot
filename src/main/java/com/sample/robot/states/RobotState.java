package com.sample.robot.states;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RobotState {

    private Position position;
    private Direction direction;

}
