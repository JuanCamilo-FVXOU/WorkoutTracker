package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class CreateWorkoutUseCase {

  private final WorkoutGateway workoutGateway;

  public Flux<WorkoutDto> getWorkouts(){
    return this.workoutGateway.getAll();
  }

//  public void createWorkout(WorkoutDto workout) {
//    this.workoutGateway.save(workout);
//  }
}
