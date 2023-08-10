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
import com.fitnessapp.exception.WorkoutNotFoundException;
import com.fitnessapp.model.WorkoutDTO;
import com.fitnessapp.service.IWorkoutService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/workouts/v1")
public class WorkoutController {
	private IWorkoutService workoutService;

	public WorkoutController(IWorkoutService workoutService) {
		super();
		this.workoutService = workoutService;
	}

	@PostMapping("/workouts")
	ResponseEntity<Void> addWorkout(@RequestBody WorkoutDTO workoutDTO) throws TrainerNotFoundException {
		workoutService.addWorkout(workoutDTO);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/workouts")
	ResponseEntity<WorkoutDTO> updateWorkout(@RequestBody WorkoutDTO workoutDTO) {
		WorkoutDTO nworkoutDTO = workoutService.updateWorkout(workoutDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "updating one workout");

		return ResponseEntity.accepted().headers(headers).body(nworkoutDTO);
	}

	@DeleteMapping("/workouts/workout-id/{workoutId}")
	ResponseEntity<Void> deleteWorkout(@PathVariable("workoutId") Integer workoutId) {
		workoutService.deleteWorkout(workoutId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/workouts/workout-id/{workoutId}")
	ResponseEntity<WorkoutDTO> getWorkoutById(@PathVariable("workoutId") Integer workoutId)
			throws WorkoutNotFoundException {
		WorkoutDTO workoutDTO = workoutService.getByWorkoutId(workoutId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTO);
	}

	@GetMapping("/workouts")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsAll() throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/name-contains/{name}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByNameContains(@PathVariable("name") String name)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByWorkoutNameContains(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/name/{name}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByName(@PathVariable("name") String name)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByWorkoutName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/difficulty/{difficulty}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByDifficulty(@PathVariable("difficulty") String difficulty)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByDifficulty(difficulty);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/intensity/{intensity}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByIntensity(@PathVariable("intensity") String intensity)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByIntensity(intensity);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/calories-less-than/{calories}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByCaloriesLessThan(@PathVariable("calories") Double calories)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByCaloriesLessThan(calories);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/workout-type/{workoutType}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByWorkoutType(@PathVariable("workoutType") String workoutType)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByWorkoutType(workoutType);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}

	@GetMapping("/workouts/trainer-id/{trainerId}")
	ResponseEntity<List<WorkoutDTO>> getWorkoutsByTrainerId(@PathVariable("trainerId") Integer trainerId)
			throws WorkoutNotFoundException {
		List<WorkoutDTO> workoutDTOs = workoutService.getByTrainer(trainerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "getting one workout by id");
		return ResponseEntity.ok().headers(headers).body(workoutDTOs);
	}
}
