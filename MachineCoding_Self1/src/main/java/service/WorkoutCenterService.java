package main.java.service;

import java.util.HashMap;
import java.util.Map;

import main.java.domain.Slot;
import main.java.domain.User;
import main.java.domain.WorkoutCenter;
import main.java.domain.WorkoutPlan;
import main.java.domain.WorkoutType;

public class WorkoutCenterService {

	public WorkoutCenter createCenter(String name) {
		return new WorkoutCenter(name);
	}
	
	public void addSlot(WorkoutCenter center, String day, String slotId, WorkoutType workoutType, int seats) {
		Map<String, Map<String, Slot>> daysSlot = center.getDaysSlot();
		if(!daysSlot.containsKey(day)) daysSlot.put(day, new HashMap());
		if(!daysSlot.get(day).containsKey(slotId)) daysSlot.get(day).put(slotId, new Slot());
		daysSlot.get(day).get(slotId).addSlotAndWorkout(workoutType, seats);
	}
	
	public void printAllWorkoutsForDay(WorkoutCenter center, String day) {
		Map<String, Map<String, Slot>> slots = center.getDaysSlot();
		if(!slots.containsKey(day)) {
			System.out.println("No Slots present for day "+day);
			return;
		}
		slots.get(day).forEach((slotId, slot)->{
			Map<WorkoutType, Integer> seatsLimit = slot.getSeatsLimit();
			Map<WorkoutType, Integer> occupiedSeats = slot.getOccupiedSeats();
			seatsLimit.forEach((workout, seats)-> 
			System.out.println("Center: "+ center.getName() +" - day: "+ day +" - slotId: "+slotId+" - workout: "+workout+" seatsAvailable: "+(seats-occupiedSeats.get(workout))));		
		});
	}
	
	public void bookSlotIfAvailable(WorkoutCenter center, String day, String slotId, WorkoutType workoutType, User user) {
		Slot slot = center.getDaysSlot().get(day).get(slotId);
		System.out.println("Booking for day "+day+" slot "+slotId+" workoutType "+workoutType+" at center "+center.getName());
		if(slot.getSeatsLimit().get(workoutType)-slot.getOccupiedSeats().get(workoutType)<=0) {
			System.out.println("Seats is not available");
			return;
		}
		slot.getOccupiedSeats().put(workoutType, slot.getOccupiedSeats().get(workoutType)+1);
		user.getWorkoutPlans().add(new WorkoutPlan(center.getName(), day, slotId, workoutType));
		System.out.println("Seats is booked");
	}

	public void printWorkoutPlanForUser(User user) {
		System.out.println("All plans for user "+user.getName());
		user.getWorkoutPlans().forEach(plan -> System.out.println("Center: "+plan.getCenterName()+" day: "+plan.getDay()+" slot: "+plan.getSlotId()+" workoutPlan: "+plan.getWorkoutType()));
	}
}
