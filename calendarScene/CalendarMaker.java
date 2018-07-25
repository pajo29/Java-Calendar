package calendarScene;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CalendarMaker {
	
	private static CalendarMaker instance = null;
	
	private ArrayList<Year> years;

	
	private CalendarMaker()
	{
		years = new ArrayList<>();
		formYears();
	}
	
	private void formYears()
	{
		/*
		 * Generates calendar year from 2000 to 2050. Can be changed in for loop
		 */
		Day Day;
		ArrayList<Day> days = new ArrayList<>();
		Month Month;
		ArrayList<Month> months = new ArrayList<>();
		Year Year;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		
		for(int year = 2000; year <= 2050; year++)
		{
			for(int month = 1; month <= 12; month++)
			{
				for(int day = 1; day <= numberOfMonthDays(year, month); day++)
				{
					Date date = null;
					try {
						date = sdf.parse(Integer.toString(day)+"."
								+Integer.toString(month)+"."
								+Integer.toString(year)+".");
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(date.getDay() == 0)
					{
						int dayOfWeek;
						dayOfWeek = 7;
						Day = new Day(date, dayOfWeek);
					}
					else
					{
						Day = new Day(date, date.getDay());
					}
					days.add(Day);
				}
				Month = new Month(month);
				Month.getDays().addAll(days);
				months.add(Month);
				days.clear();
			}
			Year = new Year(year);
			Year.getMonths().addAll(months);
			years.add(Year);
			months.clear();
		}
		
	}
	
	
	
	private int numberOfMonthDays(int year, int month)
	{
		/*
		 * Returns the number of days in month given
		 */
		if(isLeapYear(year))
		{
			if(month == 2)
				return 29;
		}
		else
		{
			if(month == 2)
				return 28;
		}
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		if(month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		
		return 0;
	}
	
	private boolean isLeapYear(int year)
	{
		/*
		 * Returns true if the year is a leap year, false if not.
		 */
		if(year % 4 == 0)
		{
			if(year % 100 == 0)
			{
				if(year % 400 == 0)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		else
			return false;
		
	}
	
	
	public ArrayList<Year> getYears() {
		return years;
	}

	public ObservableList<Week> getWeeks(Month month)
	{
		/*
		 * Makes a list of weeks used for filling Calendar table.
		 */
		ObservableList<Week> list = FXCollections.observableArrayList();
		ArrayList<Day> days = new ArrayList<>();
		
		for(Day day: month.getDays())
		{
			days.add(day);
			
			if(day.getDayOfWeek() == 7)
			{
				Week week = new Week(days);
				list.add(week);
				days.clear();
			}
		}
		
		Week week = new Week(days);
		list.add(week);
		return list;
	}

	public static CalendarMaker getInstance()
	{
		if(instance == null)
		{
			instance = new CalendarMaker();
		}
		return instance;
	}
}
