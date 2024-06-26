package main.java;

import java.util.HashMap;
import java.util.Map;

import main.java.domain.Day;
import main.java.domain.SlotId;
import main.java.domain.User;
import main.java.domain.WorkoutCenter;
import main.java.domain.WorkoutType;
import main.java.service.WorkoutCenterService;

public class Main {

	private static WorkoutCenterService workoutCenterService;
	private static Map<String, WorkoutCenter> centerMap;
	private static Map<String, User> usersPlans;
	public static void main(String[] args) {
		System.out.println("Flipfit app started");
		workoutCenterService = new WorkoutCenterService();
		centerMap = createCenters(workoutCenterService);
		usersPlans = new HashMap();
		addSlots();
		addUsers();
		printSeatsForDay(Day.DAY1);
		
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.CARDIO, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.CARDIO, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.CARDIO, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.CARDIO, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.SWIMMING, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.SWIMMING, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.SWIMMING, usersPlans.get("user1"));
		bookSlot("Koramangala",  Day.DAY1, SlotId.SLOT1, WorkoutType.SWIMMING, usersPlans.get("user1"));
		
		printWorkoutPlansForUser("user1");
		System.out.println("Flipfit app Stopped");
	}

	private static void printWorkoutPlansForUser(String userId) {
		workoutCenterService.printWorkoutPlanForUser(usersPlans.get(userId));
	}

	private static void addUsers() {
		usersPlans.put("user1", new User("user1", "u1@gmail.com"));
		usersPlans.put("user2", new User("user2", "u2@gmail.com"));
		usersPlans.put("user3", new User("user3", "u3@gmail.com"));
	}

	private static void bookSlot(String centerName, Day day1, SlotId slot1, WorkoutType workoutType, User user) {
		workoutCenterService.bookSlotIfAvailable(centerMap.get(centerName), day1.toString(), slot1.toString(), workoutType, user);
	}

	private static void printSeatsForDay(Day day1) {
		centerMap.values().forEach(center -> workoutCenterService.printAllWorkoutsForDay(center, day1.toString()));
		
	}

	private static void addSlots() {
		addSlot(centerMap.get("Koramangala"), Day.DAY1, SlotId.SLOT1, WorkoutType.CARDIO, 2);
		addSlot(centerMap.get("Koramangala"), Day.DAY1, SlotId.SLOT1, WorkoutType.SWIMMING, 2);
		addSlot(centerMap.get("Koramangala"), Day.DAY2, SlotId.SLOT2, WorkoutType.SWIMMING, 2);
		addSlot(centerMap.get("Bellandur"), Day.DAY1, SlotId.SLOT1, WorkoutType.CARDIO, 2);
		addSlot(centerMap.get("Bellandur"), Day.DAY1, SlotId.SLOT1, WorkoutType.SWIMMING, 2);
		addSlot(centerMap.get("Bellandur"), Day.DAY2, SlotId.SLOT2, WorkoutType.SWIMMING, 2);
	}

	private static void addSlot(WorkoutCenter workoutCenter, Day day2, SlotId slot2, WorkoutType swimming, int seats) {
		workoutCenterService.addSlot(workoutCenter, day2.toString(), slot2.toString(), swimming, seats);
		System.out.println("Seats added at center "+ workoutCenter.getName());
	}

	private static Map<String, WorkoutCenter> createCenters(WorkoutCenterService workoutCenterService) {
		Map<String, WorkoutCenter> map=new HashMap();
		map.put("Koramangala", workoutCenterService.createCenter("Koramangala"));
		map.put("Bellandur", workoutCenterService.createCenter("Bellandur"));
		System.out.println("Workout centers created");
		return map;
	}

}
