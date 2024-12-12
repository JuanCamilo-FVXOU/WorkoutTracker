package com.workout_tracker.domain.model;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ExerciseGateway {
    Mono<Exercise> save(Exercise exercise);
    Flux<Exercise> findAll();
    Mono<Exercise> findById(UUID id);
    void deleteById(UUID id);
}
