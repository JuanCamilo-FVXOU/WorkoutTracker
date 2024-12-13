package com.workout_tracker.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class WorkoutExerciseDto {

    private UUID id;
    private UUID workoutId;
    private UUID exerciseId;
}
