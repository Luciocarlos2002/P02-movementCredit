package com.microservice.controller;

import com.microservice.model.MovementCredit;
import com.microservice.service.MovementCreditService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movementCredit")
public class MovementCreditController {

    private final MovementCreditService movementCreditService;

    private static final String MOVEMENTCREDIT = "movementcredit";

    @GetMapping(value = "/allMovementCredits")
    public Flux<MovementCredit>getAllMovementCredits(){
        return movementCreditService.getAllMovementCredits();
    }

    @GetMapping(value = "/{id}")
    public Mono<MovementCredit> getByIdMovementCredit(@PathVariable String id){
        return movementCreditService.getMovementCreditById(id);
    }

    @PostMapping(value = "/create")
    @CircuitBreaker(name = MOVEMENTCREDIT, fallbackMethod = "movementcredit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovementCredit> createMovementCredit(@RequestBody MovementCredit movementCredit){
        return movementCreditService.createMovementCredit(movementCredit);
    }

    @PutMapping(value = "/update/{id}")
    @CircuitBreaker(name = MOVEMENTCREDIT, fallbackMethod = "movementcredit")
    public Mono<MovementCredit> updateMovementCredit(@PathVariable String id, @RequestBody MovementCredit movementCredit){
        return movementCreditService.updateMovementCredit(id, movementCredit);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> deleteMovementCredit(@PathVariable String id){
        return movementCreditService.deleteMovementCredit(id);
    }

}
