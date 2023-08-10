package com.fitnessapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trainer {
	private Integer trainerId;
	private String name;
	private int age;
	private Gender gender;
	private String phone;
	private Double hourlyRate;
	private String speciality;
	private int experience;
	private Rating rating;

	public Trainer() {
		super();
	}

	public Trainer(Integer trainerId, String name, int age, Gender gender, String phone, Double hourlyRate,
			String speciality, int experience, Rating rating) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.hourlyRate = hourlyRate;
		this.speciality = speciality;
		this.experience = experience;
		this.rating = rating;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", age=" + age + ", phone=" + phone
				+ ", hourlyRate=" + hourlyRate + ", speciality=" + speciality + ", experience=" + experience + "]";
	}
}
