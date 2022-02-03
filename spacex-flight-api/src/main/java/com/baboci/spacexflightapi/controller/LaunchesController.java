package com.baboci.spacexflightapi.controller;

import com.baboci.spacexflightapi.service.DragonService;
import com.baboci.spacexflightapi.service.LaunchesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("launches")
public class LaunchesController {

    final LaunchesService launchesService;

    public LaunchesController(LaunchesService launchesService) {
        this.launchesService = launchesService;
    }

    @Operation(summary = "Get total number of launches")
    @GetMapping("total")
    public ResponseEntity<?> getTotalLaunches(){
        int totalLaunches = launchesService.totalLaunches();
        return ResponseEntity.ok().body("Total Launches: "+ totalLaunches);
    }

    @Operation(summary = "Get total number of successful launches")
    @GetMapping("/successful")
    public ResponseEntity<?> getSuccessfulLaunches(){
        int successfulLaunches = launchesService.successfulLaunches();
        return ResponseEntity.ok().body("Successful launches: "+ successfulLaunches);
    }
}
