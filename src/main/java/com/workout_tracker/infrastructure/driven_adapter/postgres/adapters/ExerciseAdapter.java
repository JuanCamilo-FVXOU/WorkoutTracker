package com.workout_tracker.infrastructure.driven_adapter.postgres.adapters;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.model.gateways.ExerciseGateway;
import com.workout_tracker.infrastructure.driven_adapter.postgres.entity.Exercise;
import com.workout_tracker.infrastructure.driven_adapter.postgres.helper.ReactiveAdapterOperations;
import com.workout_tracker.infrastructure.driven_adapter.postgres.repository.ExerciseRepository;
import java.util.UUID;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ExerciseAdapter extends ReactiveAdapterOperations<ExerciseDto, Exercise, UUID, ExerciseRepository>
    implements ExerciseGateway {

  public ExerciseAdapter(ExerciseRepository repository, ModelMapper mapper) {
    super(repository, mapper, d -> mapper.map(d, ExerciseDto.class));
  }

}
