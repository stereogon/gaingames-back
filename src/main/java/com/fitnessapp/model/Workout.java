package com.fitnessapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Workout {
	private Integer workoutId;
	private String name;
	private int durationInMinutes;
	private Intensity intensity;
	private Double calories;
	private Difficulty difficulty;
	private String workoutType;
	private Integer trainer;

	public Workout() {
		super();
	}
	
	public Workout(Integer workoutId, String name, int durationInMinutes, Intensity intensity, Double calories,
			Difficulty difficulty, String workoutType, Integer trainer) {
		super();
		this.workoutId = workoutId;
		this.name = name;
		this.durationInMinutes = durationInMinutes;
		this.intensity = intensity;
		this.calories = calories;
		this.difficulty = difficulty;
		this.workoutType = workoutType;
		this.trainer = trainer;
	}

	public Integer getTrainer() {
		return trainer;
	}

	public void setTrainer(Integer trainer) {
		this.trainer = trainer;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public Intensity getIntensity() {
		return intensity;
	}

	public void setIntensity(Intensity intensity) {
		this.intensity = intensity;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	@Override
	public String toString() {
		return "Workout [workoutId=" + workoutId + ", name=" + name + ", durationInMinutes=" + durationInMinutes
				+ ", intensity=" + intensity + ", calories=" + calories + ", difficulty=" + difficulty
				+ ", workoutType=" + workoutType + "]";
	}
}
