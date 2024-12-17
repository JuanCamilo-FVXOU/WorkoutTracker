package com.workout_tracker.infrastructure.entry_points;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.usecases.CreateExerciseUseCase;
import com.workout_tracker.domain.usecases.GetExerciseUseCase;
import com.workout_tracker.infrastructure.entry_points.dto.WorkoutRequest;
import com.workout_tracker.infrastructure.entry_points.dto.WorkoutWithoutExercisesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class HandlerExercise {
    private final CreateExerciseUseCase createExerciseUseCase;
    private final GetExerciseUseCase getExerciseUseCase;
    private final ModelMapper mapper;


    public Mono<ServerResponse> getExercises(ServerRequest serverRequest) {
        return ServerResponse.ok().body(this.getExerciseUseCase.getExercises(), ExerciseDto.class);
    }

    public Mono<ServerResponse> getExerciseById(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        return this.getExerciseUseCase.getExerciseById(id)
                .flatMap(result -> ServerResponse.ok().bodyValue(result))
                .onErrorResume(ex -> ServerResponse.badRequest().bodyValue(ex.getMessage()));
    }
}
