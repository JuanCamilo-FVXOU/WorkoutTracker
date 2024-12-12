package com.workout_tracker.infrastructure.driven_adapter.postgres.adapters;

import com.workout_tracker.domain.model.gateways.ExerciseGateway;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import com.workout_tracker.infrastructure.driven_adapter.postgres.repository.ExerciseRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ExerciseAdapter implements ExerciseGateway {
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
