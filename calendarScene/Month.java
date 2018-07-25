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
		case 1: monthName = "Januar";
				break;
		case 2: monthName = "Februar";
				break;
		case 3: monthName = "Mart";
				break;
		case 4: monthName = "April";
				break;
		case 5: monthName = "Maj";
				break;
		case 6: monthName = "Jun";
				break;
		case 7: monthName = "Jul";
				break;
		case 8: monthName = "Avgust";
				break;
		case 9: monthName = "Septembar";
				break;
		case 10: monthName = "Oktobar";
				break;
		case 11: monthName = "Novembar";
				break;
		case 12: monthName = "Decembar";
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
