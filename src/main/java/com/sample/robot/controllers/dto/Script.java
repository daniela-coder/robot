package com.sample.robot.controllers.dto;

import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@Getter
public class Script {
    @NotEmpty
    String value;
}
