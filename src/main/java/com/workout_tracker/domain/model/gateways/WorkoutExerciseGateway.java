package com.workout_tracker.domain.model.gateways;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.model.WorkoutExerciseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WorkoutExerciseGateway {
    Flux<ExerciseDto> getExercisesByWorkoutId(UUID workoutId);
    Mono<Void> addWorkoutExercise(WorkoutExerciseDto workoutExerciseDto);
}
