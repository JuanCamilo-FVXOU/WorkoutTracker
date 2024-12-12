package com.workout_tracker.infrastructure.driven_adapter.postgres.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table("workout")
public class Workout {

    @Id
    @Column("id")
    UUID id;
    @Column("name")
    String name;
    @Column("date")
    LocalDateTime date;
}
