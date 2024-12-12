package com.workout_tracker.infrastructure.driven_adapter.postgres.adapters;


import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Workout;
import com.workout_tracker.infrastructure.driven_adapter.postgres.helper.ReactiveAdapterOperations;
import com.workout_tracker.infrastructure.driven_adapter.postgres.repository.WorkoutRepository;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class WorkoutAdapter extends
    ReactiveAdapterOperations<WorkoutDto, Workout, UUID, WorkoutRepository>
    implements WorkoutGateway {

  public WorkoutAdapter(WorkoutRepository repository, ModelMapper mapper) {
    super(repository, mapper, d -> mapper.map(d, WorkoutDto.class));
  }

  public Mono<WorkoutDto> create(WorkoutDto workout) {
    return this.save(workout);
  }

  public Flux<WorkoutDto> getAll() {
    return this.findAll();
  }

  public Mono<WorkoutDto> getById(UUID id) {
    return Mono.empty();
  }

  public Mono<Void> delete(UUID id) {
    return Mono.empty();
  }
}