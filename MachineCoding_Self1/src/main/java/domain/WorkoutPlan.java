package main.java.domain;

public class WorkoutPlan {

	private String centerName;
	private String day;
	private String slotId;
	private WorkoutType workoutType;
	public WorkoutPlan(String centerName, String day, String slotId, WorkoutType workoutType) {
		super();
		this.centerName = centerName;
		this.day = day;
		this.slotId = slotId;
		this.workoutType = workoutType;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public WorkoutType getWorkoutType() {
		return workoutType;
	}
	public void setWorkoutType(WorkoutType workoutType) {
		this.workoutType = workoutType;
	}
	
	
}
