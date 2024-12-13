package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.WorkoutExercise;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface WorkoutExerciseRepository extends ReactiveCrudRepository<WorkoutExercise, UUID>,
        ReactiveQueryByExampleExecutor<WorkoutExercise> {

    @Query("SELECT e.* FROM exercises e " +
            "JOIN workout_exercise we ON e.id = we.exercise_id " +
            "WHERE we.workout_id = :workoutId")
    Flux<Exercise> getByWorkoutId(UUID workoutId);
}
