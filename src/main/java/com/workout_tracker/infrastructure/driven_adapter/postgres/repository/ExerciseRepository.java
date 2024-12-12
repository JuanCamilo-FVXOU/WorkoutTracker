package com.workout_tracker.infrastructure.driven_adapter.postgres.repository;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ExerciseRepository extends ReactiveCrudRepository<Exercise, UUID> {
}
