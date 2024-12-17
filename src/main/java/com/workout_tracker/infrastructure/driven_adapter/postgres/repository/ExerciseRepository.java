package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ExerciseRepository extends ReactiveCrudRepository<Exercise, UUID>,
    ReactiveQueryByExampleExecutor<Exercise> {
}
