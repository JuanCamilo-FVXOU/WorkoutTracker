package com.workout_tracker.infrastructure.entry_points.exercise;

import com.workout_tracker.domain.model.ExerciseDto;
import com.workout_tracker.domain.usecases.CreateExerciseUseCase;
import com.workout_tracker.domain.usecases.GetExerciseUseCase;
import com.workout_tracker.infrastructure.entry_points.dto.ExerciseRequest;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class HandlerExercise {
    private final CreateExerciseUseCase createExerciseUseCase;
    private final GetExerciseUseCase getExerciseUseCase;

    public Mono<ServerResponse> createExercise(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ExerciseRequest.class)
                .flatMap(createExerciseUseCase::save)
                .flatMap(result -> ServerResponse.ok().bodyValue(result))
                .onErrorResume(ex -> ServerResponse.badRequest().bodyValue(ex.getMessage()));
    }
    public Mono<ServerResponse> getExercises() {
        return ServerResponse.ok().body(this.getExerciseUseCase.getExercises(), ExerciseDto.class);
    }

    public Mono<ServerResponse> getExerciseById(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        return this.getExerciseUseCase.getExerciseById(id)
                .flatMap(result -> ServerResponse.ok().bodyValue(result))
                .onErrorResume(ex -> ServerResponse.badRequest().bodyValue(ex.getMessage()));
    }
}
