package com.workout_tracker.application.config;

import com.workout_tracker.domain.model.gateways.WorkoutExerciseGateway;
import com.workout_tracker.domain.model.gateways.WorkoutGateway;
import com.workout_tracker.domain.usecases.CreateWorkoutUseCase;
import com.workout_tracker.domain.usecases.GetWorkoutUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.workout_tracker.domain.usecases",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

    @Bean
    public CreateWorkoutUseCase createWorkoutUseCase(WorkoutGateway workoutGateway) {
        return new CreateWorkoutUseCase(workoutGateway);
    }

    @Bean
    public GetWorkoutUseCase getWorkoutUseCase(WorkoutGateway workoutGateway, WorkoutExerciseGateway workoutExerciseGateway) {
        return new GetWorkoutUseCase(workoutGateway, workoutExerciseGateway);
    }
}
