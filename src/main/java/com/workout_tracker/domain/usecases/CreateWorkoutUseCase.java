package com.workout_tracker.domain.usecases;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Workout;
import com.workout_tracker.infrastructure.driven_adapter.postgres.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateWorkoutUseCase {

  private final WorkoutRepository workoutRepository;

  public void createWorkout(Workout workout) {
    this.workoutRepository.save(workout);
  }
}
