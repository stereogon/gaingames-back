package com.fitnessapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitnessapp.exception.TrainerNotFoundException;
import com.fitnessapp.model.Trainer;
import com.fitnessapp.model.TrainerDTO;
import com.fitnessapp.model.TrainerMapper;
import com.fitnessapp.repository.ITrainerRepository;

@Service
public class TrainerService implements ITrainerService {
	ITrainerRepository iTrainerRepository;
	TrainerMapper trainerMapper;

	public TrainerService(ITrainerRepository iTrainerRepository, TrainerMapper trainerMapper) {
		this.iTrainerRepository = iTrainerRepository;
		this.trainerMapper = trainerMapper;
	}

	@Override
	public void addTrainer(TrainerDTO trainerDTO) {
		Trainer trainer = trainerMapper.convertToDocument(trainerDTO);
		iTrainerRepository.insert(trainer);
	}

	@Override
	public TrainerDTO updateTrainer(TrainerDTO trainerDTO) {
		Trainer trainer = iTrainerRepository.save(trainerMapper.convertToDocument(trainerDTO));
		return trainerMapper.convertToDTO(trainer);
	}

	@Override
	public void deleteTrainer(Integer trainerId) {
		iTrainerRepository.deleteByTrainerId(trainerId);
	}

	@Override
	public TrainerDTO getByTrainerId(Integer trainerId) throws TrainerNotFoundException {
		Trainer trainer = iTrainerRepository.findByTrainerId(trainerId);
		if (trainer == null) {
			throw new TrainerNotFoundException("no trainer found");
		}
		return trainerMapper.convertToDTO(trainer);
	}

	@Override
	public List<TrainerDTO> getAll() {
		return iTrainerRepository.findAll().stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}

	@Override
	public List<TrainerDTO> getByTrainerNameContains(String trainerName) throws TrainerNotFoundException {
		List<Trainer> trainers = iTrainerRepository.findByNameContaining(trainerName);

		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("no trainers found");
		}

		return trainers.stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}

	@Override
	public List<TrainerDTO> getByRating(String rating) throws TrainerNotFoundException {
		List<Trainer> trainers = iTrainerRepository.findByRating(rating);
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("no trainers found");
		}
		return trainers.stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}

	@Override
	public List<TrainerDTO> getByExperience(int experience) throws TrainerNotFoundException {
		List<Trainer> trainers = iTrainerRepository.findByExperience(experience);
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("no trainers found");
		}
		return trainers.stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}

	@Override
	public List<TrainerDTO> getBySpeciality(String speciality) throws TrainerNotFoundException {
		List<Trainer> trainers = iTrainerRepository.findBySpeciality(speciality);
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("no trainers found");
		}
		return trainers.stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}

	@Override
	public List<TrainerDTO> getByHourlyRateSorted() throws TrainerNotFoundException {
		List<Trainer> trainers = iTrainerRepository.findByOrderByHourlyRateAsc();
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("no trainers found");
		}
		return trainers.stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}

	@Override
	public List<TrainerDTO> getByTrainerName(String trainerName) throws TrainerNotFoundException {
		List<Trainer> trainers = iTrainerRepository.findByName(trainerName);
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("no trainers found");
		}
		return trainers.stream().map((trainer) -> trainerMapper.convertToDTO(trainer)).toList();
	}
}
