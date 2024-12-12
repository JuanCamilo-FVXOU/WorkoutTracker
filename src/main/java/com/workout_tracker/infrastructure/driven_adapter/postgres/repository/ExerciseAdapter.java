package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class ExerciseAdapter {
private final ExerciseRepository exerciseRepository;

    public Mono<Exercise> save(Exercise exercise) {
        return this.exerciseRepository.save(exercise);
    }

    public Flux<Exercise> findAll() {
        return this.exerciseRepository.findAll();
    }

    public Mono<Exercise> findById(UUID id) {
        return this.exerciseRepository.findById(id);
    }

    public void deleteById(UUID id) {
        this.exerciseRepository.deleteById(id);
    }
}
