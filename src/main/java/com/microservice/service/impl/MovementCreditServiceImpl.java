package com.microservice.service.impl;

import com.microservice.model.MovementCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementCreditServiceImpl {

    Flux<MovementCredit> getAllMovementCredits();

    Mono<MovementCredit> getMovementCreditById(String id);

    Mono<MovementCredit> createMovementCredit(MovementCredit movementCredit);

    Mono<MovementCredit> updateMovementCredit(String id, MovementCredit movementCredit);

    Mono<Void> deleteMovementCredit(String id);

}
