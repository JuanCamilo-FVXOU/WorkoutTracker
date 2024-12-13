package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Workout;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;
import reactor.core.publisher.Flux;

public interface WorkoutRepository extends ReactiveCrudRepository<Workout, UUID>,
    ReactiveQueryByExampleExecutor<Workout> {
}
