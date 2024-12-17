package com.workout_tracker.domain.model.gateways;

import com.workout_tracker.domain.model.ExerciseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ExerciseGateway {
    Mono<ExerciseDto> create(ExerciseDto exercise);
    Mono<ExerciseDto> getById(UUID exerciseId);
    Flux<ExerciseDto> getAll();
    Mono<Void> delete(UUID id);
}