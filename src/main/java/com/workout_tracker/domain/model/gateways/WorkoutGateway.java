package com.workout_tracker.domain.model.gateways;

import com.workout_tracker.domain.model.WorkoutDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkoutGateway {

    Mono<WorkoutDto> create(WorkoutDto workout);
    Flux<WorkoutDto> getAll();
    Mono<WorkoutDto> getById(UUID id);
    Mono<Void> delete(UUID id);
}
