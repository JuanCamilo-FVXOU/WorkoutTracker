package com.workout_tracker.domain.usecases;

import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.WorkoutExerciseDto;
import com.workout_tracker.domain.model.gateways.WorkoutExerciseGateway;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import com.workout_tracker.infrastructure.entry_points.dto.WorkoutRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateWorkoutUseCase {

    private final WorkoutGateway workoutGateway;
    private final WorkoutExerciseGateway workoutExerciseGateway;
    private final ModelMapper modelMapper;

    public Mono<WorkoutDto> execute(WorkoutRequest workout) {
        return this.workoutGateway.create(this.modelMapper.map(workout, WorkoutDto.class))
                .flatMap(savedWorkout ->
                        Flux.fromIterable(workout.getExercisesIds())
                                .flatMap(exerciseId -> {
                                    WorkoutExerciseDto workoutExercise = WorkoutExerciseDto.builder()
                                            .workoutId(savedWorkout.getId())
                                            .exerciseId(exerciseId)
                                            .build();
                                    return this.workoutExerciseGateway.addWorkoutExercise(workoutExercise);
                                }).then(Mono.just(savedWorkout)));
    }
}
