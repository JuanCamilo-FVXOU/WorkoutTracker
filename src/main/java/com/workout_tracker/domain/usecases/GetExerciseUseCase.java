package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.model.gateways.ExerciseGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RequiredArgsConstructor
public class GetExerciseUseCase {

    private final ExerciseGateway exerciseGateway;

    public Flux<ExerciseDto> getExercises() {
        return this.exerciseGateway.getAll();
    }

    public Mono<ExerciseDto> getExerciseById (UUID exerciseId){
       return exerciseGateway.getById(exerciseId);
    }

}
