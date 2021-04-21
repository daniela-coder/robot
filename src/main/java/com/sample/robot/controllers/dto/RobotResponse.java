package com.sample.robot.controllers.dto;

import com.sample.robot.states.RobotState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class RobotResponse {
    List<RobotState> robotStates;
}
