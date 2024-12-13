package com.workout_tracker.domain.model.gateways;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ExerciseGateway {
    Flux<Exercise> findAll();
}
