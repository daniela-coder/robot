package com.sample.robot.script;

import com.sample.robot.events.*;
import com.sample.robot.grid.GridProperties;
import com.sample.robot.states.Direction;
import com.sample.robot.states.Position;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScriptParser {

    private final GridProperties gridProperties;

    public ScriptParser(GridProperties gridProperties) {
        this.gridProperties = gridProperties;
    }

    public List<Event> parseScript(@NonNull String script) {
        if (script.isEmpty()) {
            throw new IllegalArgumentException("Script must be provided!");
        }
        List<Event> events = new ArrayList<>();
        String[] scriptLines = script.split("\n");
        for(String currentLine: scriptLines){
            String[] line = currentLine.split(" ");
            Event event = buildEvent(line);
            events.add(event);
        }
        return events;
    }

    private Event buildEvent(String[] line){
        Event event;
        EventName eventName = EventName.valueOf(line[0]);

        switch (eventName) {
            case POSITION:
                Position position = new Position(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                if (!indexAllowed(position)) {
                    throw new IllegalArgumentException("Position " + position+ " out of the grid!");
                }
                event = new PositionEvent(eventName, position, Direction.valueOf(line[3]));
                break;
            case FORWARD:
                int stepNumber = Integer.parseInt(line[1]);
                event = new ForwardEvent(eventName, stepNumber);
                if (!indexAllowed(stepNumber)) {
                    throw new IllegalArgumentException("StepNumber " + stepNumber + " is out of the grid!");
                }
                break;
            case TURNAROUND:
                event = new TurnEvent(eventName, Direction.TURNAROUND);
                break;
            case RIGHT:
                event = new TurnEvent(eventName, Direction.TURN);
                break;
            case WAIT:
            default:
                event = new WaitEvent(eventName);
                break;
        }
        return event;
    }

    private boolean indexAllowed(Position position){
        return position.row >= 0 && position.row < gridProperties.getRows()
                && position.column >= 0 && position.column < gridProperties.getColumns();
    }

    private boolean indexAllowed(int index){
        return (index >= 0 && index < gridProperties.getRows())
                || (index >= 0 && index < gridProperties.getColumns());
    }
}
