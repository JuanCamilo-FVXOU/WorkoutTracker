package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.gateways.ExerciseGateway;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetWorkoutUseCase {

  private final WorkoutGateway workoutGateway;
  private final ExerciseGateway exerciseGateway;

  public Flux<WorkoutDto> getWorkouts() {
    return this.workoutGateway.getAll();
  }

  private Mono<List<Exercise>> getAllExercisesByWorkoutId(UUID workoutId) {
    return this.exerciseGateway.findAll().collectList();
  }

}
