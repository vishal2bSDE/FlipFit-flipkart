package main.java.domain;

import java.util.HashMap;
import java.util.Map;

public class WorkoutCenter {

	private String name;
	private Map<String, Map<String, Slot>> daysSlot;//days, slotId, slot
	
	public WorkoutCenter(String name, Map<String, Map<String, Slot>> daysSlot) {
		super();
		this.name = name;
		this.daysSlot = daysSlot;
	}
	
	public WorkoutCenter(String name) {
		super();
		this.name=name;
		this.daysSlot=new HashMap();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Map<String, Slot>> getDaysSlot() {
		return daysSlot;
	}
	public void setDaysSlot(Map<String, Map<String, Slot>> daysSlot) {
		this.daysSlot = daysSlot;
	}
	
	
}
