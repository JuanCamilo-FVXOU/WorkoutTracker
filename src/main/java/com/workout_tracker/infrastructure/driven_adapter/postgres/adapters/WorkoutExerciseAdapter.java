package com.workout_tracker.infrastructure.driven_adapter.postgres.adapters;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.model.WorkoutExerciseDto;
import com.workout_tracker.domain.model.gateways.WorkoutExerciseGateway;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.WorkoutExercise;
import com.workout_tracker.infrastructure.driven_adapter.postgres.helper.ReactiveAdapterOperations;
import com.workout_tracker.infrastructure.driven_adapter.postgres.repository.WorkoutExerciseRepository;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class WorkoutExerciseAdapter extends
    ReactiveAdapterOperations<WorkoutExerciseDto, WorkoutExercise
        , UUID, WorkoutExerciseRepository>
    implements WorkoutExerciseGateway {

  protected WorkoutExerciseAdapter(WorkoutExerciseRepository repository, ModelMapper mapper) {
    super(repository, mapper, d -> mapper.map(d, WorkoutExerciseDto.class));
  }

  @Override
  public Flux<ExerciseDto> getExercisesByWorkoutId(UUID workoutId) {
    return this.repository.getByWorkoutId(workoutId)
        .map(result -> mapper.map(result, ExerciseDto.class));
  }

  @Override
  public Mono<Void> addWorkoutExercise(WorkoutExerciseDto workoutExerciseDto) {
    return this.save(workoutExerciseDto).then();
  }

  @Override
  public Mono<Void> create(WorkoutExerciseDto workoutExerciseDto) {
    return this.save(workoutExerciseDto).then();
  }
}
