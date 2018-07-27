package calendarScene;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Day {
	
	private Date dateofDay;
	private int dayOfWeek = 0;
	

	public Day(Date dateofDay, int dayOfWeek) {
		this.dateofDay = dateofDay;
		this.dayOfWeek = dayOfWeek;
	}


	public Date getDateofDay() {
		return dateofDay;
	}

	public void setDateofDay(Date dateofDay) {
		this.dateofDay = dateofDay;
	}
	
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		
		return sdf.format(dateofDay)+".\n"+"\n ";
	}

}
