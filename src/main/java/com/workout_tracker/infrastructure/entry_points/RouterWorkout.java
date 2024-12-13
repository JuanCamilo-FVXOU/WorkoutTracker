package com.workout_tracker.infrastructure.entry_points;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterWorkout {

    @Bean
    public RouterFunction<ServerResponse> workoutRouter(HandlerWorkout handlerWorkout) {
        return RouterFunctions
                .route()
                .path("/api/v1/workout", builder -> builder
                        .GET("/", handlerWorkout::getWorkouts)
                        .GET("/{id}", handlerWorkout::getWorkoutById)
                        .POST(handlerWorkout::createWorkout))
                .build();
    }
}
