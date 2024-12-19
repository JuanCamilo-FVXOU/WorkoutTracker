package com.workout_tracker.infrastructure.entry_points.exercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterExercise {

  @Bean
  public RouterFunction<ServerResponse> exerciseRouter(HandlerExercise handlerExercise) {
    return RouterFunctions
        .route()
        .path("/api/v1/exercise", builder -> builder
            .GET(item -> handlerExercise.getExercises())
            .GET("/{id}", handlerExercise::getExerciseById)
            .POST(handlerExercise::createExercise))
        .build();
  }
}
