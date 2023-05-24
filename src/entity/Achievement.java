package entity;

import java.util.ArrayList;

public class Achievement {
	private String name;
	public ArrayList<Integer> skill_index = new ArrayList<Integer>();
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
