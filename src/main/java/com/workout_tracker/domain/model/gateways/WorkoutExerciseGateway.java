package com.workout_tracker.domain.model.gateways;

import com.workout_tracker.domain.model.ExerciseDto;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface WorkoutExerciseGateway {
    Flux<ExerciseDto> getExercisesByWorkoutId(UUID workoutId);
}
