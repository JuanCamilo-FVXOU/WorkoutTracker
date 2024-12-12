package com.workout_tracker.infrastructure.entry_points;

import com.workout_tracker.domain.model.WorkoutDto;
import com.workout_tracker.domain.usecases.CreateWorkoutUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class HandlerWorkout {

  private final CreateWorkoutUseCase createWorkoutUseCase;

  public Mono<ServerResponse> getAllWorkouts(ServerRequest severRequest) {
    return ServerResponse.ok().body(this.createWorkoutUseCase.getWorkouts(), WorkoutDto.class);
  }
}
