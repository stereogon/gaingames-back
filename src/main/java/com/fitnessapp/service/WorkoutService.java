package com.fitnessapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitnessapp.exception.TrainerNotFoundException;
import com.fitnessapp.exception.WorkoutNotFoundException;
import com.fitnessapp.model.TrainerDTO;
import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutDTO;
import com.fitnessapp.model.WorkoutMapper;
import com.fitnessapp.repository.IWorkoutRepository;

@Service
public class WorkoutService implements IWorkoutService {
	IWorkoutRepository iWorkoutRepository;
	ITrainerService iTrainerService;
	WorkoutMapper workoutMapper;

	public WorkoutService(IWorkoutRepository iWorkoutRepository, WorkoutMapper workoutMapper, ITrainerService iTrainerService) {
		this.iWorkoutRepository = iWorkoutRepository;
		this.workoutMapper = workoutMapper;
		this.iTrainerService = iTrainerService;
	}

	@Override
	public void addWorkout(WorkoutDTO workoutDTO) throws TrainerNotFoundException {
		try {
			TrainerDTO trainerDTO = iTrainerService.getByTrainerId(workoutDTO.getTrainer());
			iWorkoutRepository.insert(workoutMapper.convertToDocument(workoutDTO));
		} catch(TrainerNotFoundException e) {
			throw e;
		}
	}

	@Override
	public WorkoutDTO updateWorkout(WorkoutDTO workoutDTO) {
		Workout workout = iWorkoutRepository.save(workoutMapper.convertToDocument(workoutDTO));
		return workoutMapper.convertToDTO(workout);
	}

	@Override
	public void deleteWorkout(Integer workoutId) {
		iWorkoutRepository.deleteByWorkoutId(workoutId);
	}

	@Override
	public WorkoutDTO getByWorkoutId(Integer workoutId) throws WorkoutNotFoundException {
		Workout workout = iWorkoutRepository.findByWorkoutId(workoutId);
		if (workout == null) {
			throw new WorkoutNotFoundException("no workout found");
		}
				
		return workoutMapper.convertToDTO(workout);
	}

	@Override
	public List<WorkoutDTO> getAll() {
		return iWorkoutRepository.findAll().stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByWorkoutNameContains(String workoutName) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByNameContaining(workoutName);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByWorkoutName(String workoutName) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByName(workoutName);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByDifficulty(String difficulty) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByDifficulty(difficulty);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByIntensity(String intensity) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByIntensity(intensity);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByCaloriesLessThan(Double calories) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByCaloriesLessThan(calories);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByWorkoutType(String workoutType) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByWorkoutType(workoutType);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

	@Override
	public List<WorkoutDTO> getByTrainer(Integer trainerId) throws WorkoutNotFoundException {
		List<Workout> workouts = iWorkoutRepository.findByTrainer(trainerId);
		if (workouts.isEmpty()) {
			throw new WorkoutNotFoundException("no workouts found");
		}

		return workouts.stream().map((workout) -> workoutMapper.convertToDTO(workout)).toList();
	}

}
