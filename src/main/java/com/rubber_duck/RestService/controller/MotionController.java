package com.rubber_duck.RestService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rubber_duck.RestService.model.Motion;
import com.rubber_duck.RestService.service.MotionService;

@RestController
public class MotionController {

    @Autowired
    private MotionService motionService;

    @PostMapping("/motion")
    ResponseEntity<Void> createMotion(@RequestParam("image") MultipartFile file) {
        if (motionService.createMotion(file)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/motion/list/{days}")
    ResponseEntity<List<Motion>> getMotion(@PathVariable String days) {
        Integer intDays = Integer.parseInt(days);
        List<Motion> motionList = motionService.listMotion(intDays);
        return new ResponseEntity<>(motionList, HttpStatus.OK);
    }
}
