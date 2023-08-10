package com.fitnessapp.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessapp.exception.TrainerNotFoundException;
import com.fitnessapp.model.TrainerDTO;
import com.fitnessapp.service.ITrainerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/trainers/v1")
public class TrainerController {
	private ITrainerService trainerService;

	public TrainerController(ITrainerService trainerService) {
		super();
		this.trainerService = trainerService;
	}

	@PostMapping("/trainers")
	ResponseEntity<Void> addTrainer(@RequestBody TrainerDTO trainerDTO) {
		trainerService.addTrainer(trainerDTO);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/trainers")
	ResponseEntity<TrainerDTO> updateTrainer(@RequestBody TrainerDTO trainerDTO) {
		TrainerDTO ntrainerDTO = trainerService.updateTrainer(trainerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "updating one trainer");

		return ResponseEntity.accepted().headers(headers).body(ntrainerDTO);
	}

	@DeleteMapping("/trainers/trainer-id/{trainerId}")
	ResponseEntity<Void> deleteTrainer(@PathVariable("trainerId") Integer trainerId) {
		trainerService.deleteTrainer(trainerId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/trainers/trainer-id/{trainerId}")
	ResponseEntity<TrainerDTO> getTrainerById(@PathVariable("trainerId") Integer trainerId)
			throws TrainerNotFoundException {
		TrainerDTO trainerDTO = trainerService.getByTrainerId(trainerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one trainer by id");
		return ResponseEntity.ok().headers(headers).body(trainerDTO);
	}

	@GetMapping("/trainers")
	ResponseEntity<List<TrainerDTO>> getTrainersAll() {
		List<TrainerDTO> trainerDTOs = trainerService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}

	@GetMapping("/trainers/name-contains/{name}")
	ResponseEntity<List<TrainerDTO>> getTrainersByNameContains(@PathVariable("name") String name)
			throws TrainerNotFoundException {
		List<TrainerDTO> trainerDTOs = trainerService.getByTrainerNameContains(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}

	@GetMapping("/trainers/name/{name}")
	ResponseEntity<List<TrainerDTO>> getTrainersByName(@PathVariable("name") String name)
			throws TrainerNotFoundException {
		List<TrainerDTO> trainerDTOs = trainerService.getByTrainerName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}

	@GetMapping("/trainers/rating/{rating}")
	ResponseEntity<List<TrainerDTO>> getTrainersByRating(@PathVariable("rating") String rating)
			throws TrainerNotFoundException {
		List<TrainerDTO> trainerDTOs = trainerService.getByRating(rating);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}

	@GetMapping("/trainers/experience/{experience}")
	ResponseEntity<List<TrainerDTO>> getAllTrainers(@PathVariable("experience") int experience)
			throws TrainerNotFoundException {
		List<TrainerDTO> trainerDTOs = trainerService.getByExperience(experience);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}

	@GetMapping("/trainers/speciality/{speciality}")
	ResponseEntity<List<TrainerDTO>> getTrainersBySpeciality(@PathVariable("speciality") String speciality)
			throws TrainerNotFoundException {
		List<TrainerDTO> trainerDTOs = trainerService.getBySpeciality(speciality);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}
	
	@GetMapping("/trainers/hourly-rate/asc")
	ResponseEntity<List<TrainerDTO>> getTrainersOrderByHourlyRate()
			throws TrainerNotFoundException {
		List<TrainerDTO> trainerDTOs = trainerService.getByHourlyRateSorted();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting the list of trainers");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(trainerDTOs);
	}

	
	
}
