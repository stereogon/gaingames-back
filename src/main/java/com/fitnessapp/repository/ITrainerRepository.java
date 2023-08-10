package com.fitnessapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitnessapp.model.Trainer;

@Repository
public interface ITrainerRepository extends MongoRepository<Trainer, Integer> {
	Trainer findByTrainerId(Integer trainerId);
	void deleteByTrainerId(Integer trainerId);
	List<Trainer> findAll();
	List<Trainer> findByNameContaining(String trainerName); 
	List<Trainer> findByName(String trainerName); 
	List<Trainer> findByRating(String rating); 
	List<Trainer> findByExperience(int experience);
	List<Trainer> findBySpeciality(String speciality);
	List<Trainer> findByOrderByHourlyRateAsc(); 
}
