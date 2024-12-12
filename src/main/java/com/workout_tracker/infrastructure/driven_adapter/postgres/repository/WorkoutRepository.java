package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Workout;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface WorkoutRepository extends ReactiveCrudRepository<Workout, UUID> {

}
