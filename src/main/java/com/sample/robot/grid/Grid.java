package com.sample.robot.grid;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Grid {

    GridProperties gridProperties;

    int rowNumber;

    int columnNumber;

    public Grid(GridProperties gridProperties) {
        this.gridProperties = gridProperties;
        this.rowNumber = gridProperties.rows;
        this.columnNumber = gridProperties.columns;
    }
}
