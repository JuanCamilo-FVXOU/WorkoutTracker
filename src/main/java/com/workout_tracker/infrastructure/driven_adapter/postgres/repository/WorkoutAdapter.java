package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;


import com.workout_tracker.domain.model.WorkoutGateway;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Workout;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class WorkoutAdapter implements WorkoutGateway {
    private final WorkoutRepository workoutRepository;

    public Mono<Workout> save(Workout workout) {
        return this.workoutRepository.save(workout);
    }

    public Flux<Workout> findAll() {
        return this.workoutRepository.findAll();
    }

    public Mono<Workout> findById(UUID id) {
        return this.workoutRepository.findById(id);
    }

    public void deleteById(UUID id) {
        this.workoutRepository.deleteById(id);
    }
}