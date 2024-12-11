package com.workout_tracker.infrastructure.entry_points;

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

  public Mono<ServerResponse> createWorkout(ServerRequest severRequest) {
    return Mono.empty();
  }
}
