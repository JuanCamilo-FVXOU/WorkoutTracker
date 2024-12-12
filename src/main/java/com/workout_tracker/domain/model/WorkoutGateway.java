package com.workout_tracker.domain.model;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Workout;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkoutGateway {

    Mono<Workout> save(Workout workout);
    Flux<Workout> findAll();
    Mono<Workout> findById(UUID id);
    void deleteById(UUID id);
}
