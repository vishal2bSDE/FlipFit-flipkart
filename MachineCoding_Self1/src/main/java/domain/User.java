package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private String email;
	private List<WorkoutPlan> workoutPlans;
	
	
	public User(String name, String email, List<WorkoutPlan> workoutPlans) {
		super();
		this.name = name;
		this.email = email;
		this.workoutPlans = workoutPlans;
	}
	
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.workoutPlans = new ArrayList<>();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<WorkoutPlan> getWorkoutPlans() {
		return workoutPlans;
	}
	public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
		this.workoutPlans = workoutPlans;
	}
	
	public void addToWorkoutPlans(WorkoutPlan plan) {
		workoutPlans.add(plan);
	}
	
}
