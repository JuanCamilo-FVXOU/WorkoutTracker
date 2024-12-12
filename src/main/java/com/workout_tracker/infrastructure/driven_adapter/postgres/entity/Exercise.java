package com.workout_tracker.infrastructure.driven_adapter.postgres.entity;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @Column("id")
    UUID id;
    @Column("name")
    String name;
    @Column("sets")
    Integer sets;
    @Column("reps")
    Integer reps;
    @Column("weight")
    Integer weight;
}
