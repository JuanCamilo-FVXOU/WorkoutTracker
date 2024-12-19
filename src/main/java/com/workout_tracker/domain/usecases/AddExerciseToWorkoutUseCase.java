package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.WorkoutExerciseDto;
import com.workout_tracker.domain.model.gateways.WorkoutExerciseGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddExerciseToWorkoutUseCase {

  private final WorkoutExerciseGateway workoutExerciseGateway;

  public Mono<Void> execute(WorkoutExerciseDto workoutExerciseDto) {
    return this.workoutExerciseGateway.create(workoutExerciseDto).then();
  }

}
