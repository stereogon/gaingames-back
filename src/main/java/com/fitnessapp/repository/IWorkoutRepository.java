package com.fitnessapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitnessapp.model.Workout;

@Repository
public interface IWorkoutRepository extends MongoRepository<Workout, Integer> {
	List<Workout> findAll();
	Workout findByWorkoutId(Integer workoutId);
	void deleteByWorkoutId(Integer workoutId);
	List<Workout> findByNameContaining(String workoutName); 
	List<Workout> findByName(String workoutName);
	List<Workout> findByDifficulty(String difficulty); 
	List<Workout> findByIntensity(String intensity); 
	List<Workout> findByCaloriesLessThan(Double calories); 
	List<Workout> findByWorkoutType(String workoutType);
	List<Workout> findByTrainer(Integer trainerId);
}
