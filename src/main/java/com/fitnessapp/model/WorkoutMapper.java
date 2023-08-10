package com.fitnessapp.model;

import org.springframework.stereotype.Component;

@Component
public class WorkoutMapper {
	public WorkoutDTO convertToDTO(Workout workout) {
		WorkoutDTO workoutDTO = new WorkoutDTO();
		workoutDTO.setCalories(workout.getCalories());
		workoutDTO.setDifficulty(workout.getDifficulty());
		workoutDTO.setDurationInMinutes(workout.getDurationInMinutes());
		workoutDTO.setIntensity(workout.getIntensity());
		workoutDTO.setName(workout.getName());
		workoutDTO.setWorkoutId(workout.getWorkoutId());
		workoutDTO.setTrainer(workout.getTrainer());
		workoutDTO.setWorkoutType(workout.getWorkoutType());

		return workoutDTO;
	}

	public Workout convertToDocument(WorkoutDTO workoutDTO) {
		Workout workout = new Workout();
		workout.setCalories(workoutDTO.getCalories());
		workout.setDifficulty(workoutDTO.getDifficulty());
		workout.setDurationInMinutes(workoutDTO.getDurationInMinutes());
		workout.setIntensity(workoutDTO.getIntensity());
		workout.setName(workoutDTO.getName());
		workout.setWorkoutId(workoutDTO.getWorkoutId());
		workout.setTrainer(workoutDTO.getTrainer());
		workout.setWorkoutType(workoutDTO.getWorkoutType());

		return workout;
	}
}
