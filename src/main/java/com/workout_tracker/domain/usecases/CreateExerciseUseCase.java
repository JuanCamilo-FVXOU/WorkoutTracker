package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.model.gateways.ExerciseGateway;
import com.workout_tracker.infrastructure.entry_points.dto.ExerciseRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateExerciseUseCase {
    private final ExerciseGateway exerciseGateway;
    public Mono<ExerciseDto> save(ExerciseRequest exercise) {
        return exerciseGateway.create(exercise);
    }
}
