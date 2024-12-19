package com.workout_tracker.infrastructure.entry_points.workout;

import com.workout_tracker.domain.model.WorkoutExerciseDto;
import com.workout_tracker.domain.usecases.AddExerciseToWorkoutUseCase;
import com.workout_tracker.domain.usecases.CreateWorkoutUseCase;
import com.workout_tracker.domain.usecases.GetWorkoutUseCase;
import com.workout_tracker.infrastructure.entry_points.dto.WorkoutRequest;
import com.workout_tracker.infrastructure.entry_points.dto.WorkoutWithoutExercisesResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class HandlerWorkout {

  // USE CASES
  private final CreateWorkoutUseCase createWorkoutUseCase;
  private final GetWorkoutUseCase getWorkoutUseCase;
  private final AddExerciseToWorkoutUseCase addExerciseToWorkoutUseCase;

  // OTHER LIBRARIES
  private final ModelMapper mapper;

  public Mono<ServerResponse> createWorkout(ServerRequest serverRequest) {
    return serverRequest.bodyToMono(WorkoutRequest.class)
        .flatMap(this.createWorkoutUseCase::execute)
        .flatMap(result -> {
          WorkoutWithoutExercisesResponse response = this.mapper.map(result,
              WorkoutWithoutExercisesResponse.class);
          return ServerResponse.ok().bodyValue(response);
        })
        .onErrorResume(ex -> ServerResponse.badRequest().bodyValue(ex.getMessage()));
  }

  public Mono<ServerResponse> getWorkouts() {
    return ServerResponse.ok().body(this.getWorkoutUseCase.getWorkouts()
            .map(result ->
                this.mapper.map(result, WorkoutWithoutExercisesResponse.class)),
        WorkoutWithoutExercisesResponse.class);
  }

  public Mono<ServerResponse> getWorkoutById(ServerRequest serverRequest) {
    UUID id = UUID.fromString(serverRequest.pathVariable("id"));
    return this.getWorkoutUseCase.getWorkoutById(id)
        .flatMap(result -> ServerResponse.ok().bodyValue(result))
        .onErrorResume(ex -> ServerResponse.badRequest().bodyValue(ex.getMessage()));
  }

  public Mono<ServerResponse> addExerciseToExistingWorkout(ServerRequest serverRequest) {
    return serverRequest.bodyToMono(WorkoutExerciseDto.class)
        .flatMap(this.addExerciseToWorkoutUseCase::execute)
        .then(Mono.defer(() -> ServerResponse.ok().build()));
  }
}
