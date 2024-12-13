package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.gateways.WorkoutExerciseGateway;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class GetWorkoutUseCase {

    private final WorkoutGateway workoutGateway;
    private final WorkoutExerciseGateway workoutExerciseGateway;

    public Flux<WorkoutDto> getWorkouts() {
        return this.workoutGateway.getAll();
    }

    public Mono<WorkoutDto> getWorkoutById(UUID id) {
        return this.workoutGateway.getById(id)
                .flatMap(
                        workout -> this.workoutExerciseGateway
                                .getExercisesByWorkoutId(workout.getId())
                                .collectList()
                                .map(exercises -> {
                                    workout.setExercises(exercises);
                                    return workout;
                                }));
    }
}
