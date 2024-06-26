package main.java.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Slot {

	private String slotId;
	private Map<WorkoutType, Integer> seatsLimit;
	private Map<WorkoutType, Integer> occupiedSeats;
	
	public Slot(String slotId, Map<WorkoutType, Integer> seatsLimit) {
		super();
		this.slotId = slotId;
		this.seatsLimit = seatsLimit;
		this.occupiedSeats = initializeWorkoutSeats(seatsLimit);
	}
	
	public Slot() {
		super();
		seatsLimit = new HashMap();
		occupiedSeats = new HashMap();
	}

	private Map<WorkoutType, Integer> initializeWorkoutSeats(Map<WorkoutType, Integer> seatsLimit) {
		return seatsLimit.keySet().stream().collect(Collectors.toMap(Function.identity(), n -> 0));
	}
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public Map<WorkoutType, Integer> getSeatsLimit() {
		return seatsLimit;
	}
	public void setSeatsLimit(Map<WorkoutType, Integer> seatsLimit) {
		this.seatsLimit = seatsLimit;
	}
	public Map<WorkoutType, Integer> getOccupiedSeats() {
		return occupiedSeats;
	}
	public void setOccupiedSeats(Map<WorkoutType, Integer> occupiedSeats) {
		this.occupiedSeats = occupiedSeats;
	}

	public void addSlotAndWorkout(WorkoutType workoutType, int seats) {
		seatsLimit.put(workoutType, seats);
		occupiedSeats.put(workoutType, 0);
	}
	
	
}
