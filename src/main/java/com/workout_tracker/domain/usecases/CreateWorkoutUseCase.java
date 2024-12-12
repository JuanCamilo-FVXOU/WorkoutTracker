package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import java.util.ArrayList;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateWorkoutUseCase {

  private final WorkoutGateway workoutGateway;

  public Mono<WorkoutDto> execute(WorkoutDto workout) {
    return this.workoutGateway.create(workout)
        .flatMap(result -> {
          if (Objects.isNull(result.getExercises())) {
            result.setExercises(new ArrayList<>());
            return Mono.just(result);
          }
          return Mono.just(result);
        });
  }
}
