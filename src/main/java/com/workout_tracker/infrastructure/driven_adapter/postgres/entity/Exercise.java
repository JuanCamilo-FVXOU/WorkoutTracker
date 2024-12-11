package com.workout_tracker.infrastructure.driven_adapter.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    UUID id;
    String name;
    Integer sets;
    Integer reps;
    Integer weight;

    @ManyToMany(mappedBy = "exercises")
    Set<Workout> workouts;
}
