package com.fitnessapp.service;

import java.util.List;

import com.fitnessapp.exception.TrainerNotFoundException;
import com.fitnessapp.exception.WorkoutNotFoundException;
import com.fitnessapp.model.WorkoutDTO;

public interface IWorkoutService {
	// CRUD
	void addWorkout(WorkoutDTO workoutDTO) throws TrainerNotFoundException;
	WorkoutDTO updateWorkout(WorkoutDTO workoutDTO);
	void deleteWorkout(Integer workoutId);
	WorkoutDTO getByWorkoutId(Integer workoutId) throws WorkoutNotFoundException;
	
	// Queries
	List<WorkoutDTO> getAll();
	List<WorkoutDTO> getByWorkoutNameContains(String workoutName) throws WorkoutNotFoundException;
	List<WorkoutDTO> getByWorkoutName(String workoutName) throws WorkoutNotFoundException;
	List<WorkoutDTO> getByDifficulty(String difficulty) throws WorkoutNotFoundException;
	List<WorkoutDTO> getByIntensity(String intensity) throws WorkoutNotFoundException;
	List<WorkoutDTO> getByCaloriesLessThan(Double calories) throws WorkoutNotFoundException;
	List<WorkoutDTO> getByWorkoutType(String workoutType) throws WorkoutNotFoundException;
	List<WorkoutDTO> getByTrainer(Integer trainerId) throws WorkoutNotFoundException;
}
