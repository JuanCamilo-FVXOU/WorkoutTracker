package com.workout_tracker.infrastructure.driven_adapter.postgres.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table("exercises")
public class Exercise {
    @Id
    UUID id;
    String name;
    Integer sets;
    Integer reps;
    Integer weight;
}
