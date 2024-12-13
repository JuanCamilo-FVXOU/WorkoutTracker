package com.workout_tracker.infrastructure.driven_adapter.postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table("workout_exercise")
public class WorkoutExercise {

    @Id
    private UUID id;
    private UUID workoutId;
    private UUID exerciseId;
}
