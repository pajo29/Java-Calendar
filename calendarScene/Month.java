package calendarScene;

import java.util.ArrayList;

public class Month {
	
	private ArrayList<Day> days;
	
	private int monthNumber;
	private String monthName;
	
	public Month(int monthNumber)
	{
		this.monthNumber = monthNumber;
		days = new ArrayList<>();
		assignName();
	}
	
	private void assignName()
	{
		switch(monthNumber)
		{
		case 1: monthName = "Jan";
				break;
		case 2: monthName = "Feb";
				break;
		case 3: monthName = "March";
				break;
		case 4: monthName = "April";
				break;
		case 5: monthName = "May";
				break;
		case 6: monthName = "Jun";
				break;
		case 7: monthName = "July";
				break;
		case 8: monthName = "Aug";
				break;
		case 9: monthName = "Sept";
				break;
		case 10: monthName = "Oct";
				break;
		case 11: monthName = "Nov";
				break;
		case 12: monthName = "Dec";
				break;
		}
	}

	public ArrayList<Day> getDays() {
		return days;
	}

	public int getMonthNumber() {
		return monthNumber;
	}
	
	@Override
	public String toString() {
		return monthName;
	}

}
