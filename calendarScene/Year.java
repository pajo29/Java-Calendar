package calendarScene;

import java.util.ArrayList;

public class Year {
	
	private ArrayList<Month> months;
	
	private int yearNumber;
	
	public Year(int yearNumber)
	{
		this.yearNumber = yearNumber;
		months = new ArrayList<>();
	}

	public ArrayList<Month> getMonths() {
		return months;
	}

	public int getYearNumber() {
		return yearNumber;
	}

	@Override
	public String toString() {
		return yearNumber+"";
	}
	

}
