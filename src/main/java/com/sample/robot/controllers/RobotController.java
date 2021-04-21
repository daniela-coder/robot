package com.sample.robot.controllers;

import com.sample.robot.controllers.dto.RobotResponse;
import com.sample.robot.controllers.dto.Script;
import com.sample.robot.services.RobotService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RobotController {

    private final RobotService robotService;

    RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/script")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(origins = "*")
    public RobotResponse createScript(@Valid @RequestBody Script script, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String message = errors.stream().map(ObjectError::toString).reduce(" ", String::concat);
            throw new IllegalArgumentException(message);
        }
        return new RobotResponse(robotService.executeScript(script.getValue()));
    }
}
