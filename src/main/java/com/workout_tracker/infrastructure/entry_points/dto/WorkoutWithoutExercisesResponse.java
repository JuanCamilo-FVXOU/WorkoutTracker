package com.workout_tracker.infrastructure.entry_points.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class WorkoutWithoutExercisesResponse {
    UUID id;
    String name;
    LocalDateTime date;
    Boolean isActive;
}
