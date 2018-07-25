package calendarScene;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Week {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	
	private Day monday;
	private Day tuesday;
	private Day wednesday;
	private Day thursday;
	private Day friday;
	private Day saturday;
	private Day sunday;
	
	public Week(ArrayList<Day> days)
	{
		try {
			Day emptyDay = new Day(sdf.parse("01.01.1998."), 1);
				monday = emptyDay;
				tuesday = emptyDay;
				wednesday = emptyDay;
				thursday = emptyDay;
				friday = emptyDay;
				saturday = emptyDay;
				sunday = emptyDay;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for(Day day: days)
		{
			if(day.getDayOfWeek() == 1)
				monday = day;
			if(day.getDayOfWeek() == 2)
				tuesday = day;
			if(day.getDayOfWeek() == 3)
				wednesday = day;
			if(day.getDayOfWeek() == 4)
				thursday = day;
			if(day.getDayOfWeek() == 5)
				friday = day;
			if(day.getDayOfWeek() == 6)
				saturday = day;
			if(day.getDayOfWeek() == 7)
				sunday = day;
		}
	}

	public String getMonday() {
		return monday.toString();
	}

	public String getTuesday() {
		return tuesday.toString();
	}

	public String getWednesday() {
		return wednesday.toString();
	}

	public String getThursday() {
		return thursday.toString();
	}

	public String getFriday() {
		return friday.toString();
	}

	public String getSaturday() {
		return saturday.toString();
	}

	public String getSunday() {
		return sunday.toString();
	}
	
	

}
