package com.sample.robot.services;

import com.sample.robot.events.Event;
import com.sample.robot.grid.Grid;
import com.sample.robot.script.ScriptParser;
import com.sample.robot.states.RobotState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotService {

    private final ScriptParser scriptParser;
    private final Grid grid;

    RobotService(ScriptParser scriptParser, Grid grid) {
        this.scriptParser = scriptParser;
        this.grid = grid;
    }

    public List<RobotState> executeScript(String script) {
        List<Event> events = scriptParser.parseScript(script);
       return triggerEvents(events);
    }

    private List<RobotState> triggerEvents(List<Event> eventsToTrigger) {
        List<RobotState> robotStates = new ArrayList<>();
        RobotState previousRobotState = new RobotState(null, null);
        for (Event event: eventsToTrigger) {
            RobotState robotState = event.action(previousRobotState, grid);
            robotStates.add(robotState);
            previousRobotState = robotState;
        }
        return robotStates;
    }

}
