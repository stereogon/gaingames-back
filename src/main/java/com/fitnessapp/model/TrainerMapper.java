package com.fitnessapp.model;

import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {
	public TrainerDTO convertToDTO(Trainer trainer) {
		TrainerDTO trainerDTO = new TrainerDTO();
		trainerDTO.setTrainerId(trainer.getTrainerId());
		trainerDTO.setAge(trainer.getAge());
		trainerDTO.setExperience(trainer.getExperience());
		trainerDTO.setGender(trainer.getGender());
		trainerDTO.setHourlyRate(trainer.getHourlyRate());
		trainerDTO.setName(trainer.getName());
		trainerDTO.setPhone(trainer.getPhone());
		trainerDTO.setRating(trainer.getRating());
		trainerDTO.setSpeciality(trainer.getSpeciality());
		
		return trainerDTO;
	}

	public Trainer convertToDocument(TrainerDTO trainerDTO) {
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerDTO.getTrainerId());
		trainer.setAge(trainerDTO.getAge());
		trainer.setExperience(trainerDTO.getExperience());
		trainer.setGender(trainerDTO.getGender());
		trainer.setHourlyRate(trainerDTO.getHourlyRate());
		trainer.setName(trainerDTO.getName());
		trainer.setPhone(trainerDTO.getPhone());
		trainer.setRating(trainerDTO.getRating());
		trainer.setSpeciality(trainerDTO.getSpeciality());
		
		return trainer;
	}
}
