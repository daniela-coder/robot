package com.sample.robot.grid;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Setter
@Getter
@ConfigurationProperties("grid")
public class GridProperties {

    @NotNull
    int rows;

    @NotNull
    int columns;
}
