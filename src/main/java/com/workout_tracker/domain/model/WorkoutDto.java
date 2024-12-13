package com.workout_tracker.domain.model;

import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class WorkoutDto {

  UUID id;
  String name;
  LocalDateTime date;
  Boolean isActive;
  List<ExerciseDto> exercises;
}
