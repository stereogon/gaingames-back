package com.fitnessapp.service;

import java.util.List;

import com.fitnessapp.exception.TrainerNotFoundException;
import com.fitnessapp.model.TrainerDTO;

public interface ITrainerService {
	// CRUD
	void addTrainer(TrainerDTO trainerDTO); 
	TrainerDTO updateTrainer(TrainerDTO trainerDTO);
	void deleteTrainer(Integer trainerId);
	TrainerDTO getByTrainerId(Integer trainerId) throws TrainerNotFoundException;
	
	// Queries
	List<TrainerDTO> getAll();
	List<TrainerDTO> getByTrainerNameContains(String trainerName) throws TrainerNotFoundException;
	List<TrainerDTO> getByTrainerName(String trainerName) throws TrainerNotFoundException;
	List<TrainerDTO> getByRating(String rating) throws TrainerNotFoundException;
	List<TrainerDTO> getByExperience(int experience) throws TrainerNotFoundException;
	List<TrainerDTO> getBySpeciality(String speciality) throws TrainerNotFoundException;
	List<TrainerDTO> getByHourlyRateSorted() throws TrainerNotFoundException;
}
