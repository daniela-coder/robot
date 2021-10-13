package com.sample.robot.events;

import lombok.ToString;

@ToString
public enum EventName {
    POSITION,
    FORWARD,
    WAIT,
    TURNAROUND,
    RIGHT;

    public static EventName getEventName(String eventName) {
        try {
            EventName.valueOf(eventName);
        } catch (Exception e) {
            throw new IllegalArgumentException("Command not yet implemented! ");
        }
    }
}
