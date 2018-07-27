# Java-Calendar
Can be just added as a package and used as a BorderPane. You can either change that, or add the existing BorderPane to the Scene.
Year span from 2000-2050. Can be changed in for loop in CalendarMaker.java. 
# If you go below 1998, change the emptyDate in Week.java to something before and the condition in Day.java.

To use it. Import the package, and use CalendarScene.getInstance();

CalendarMaker.getInstance().getWeeks(Month month);
  -Gets the weeks of the given month
CalendarMaker.getInstance().isLeapYear(int year);
  -Returns true if the given year is a Leap year
CalendarMaker.getInstance().numberOfMonthsDays(int year, int month);
  -Retruns the number of days in the given months of the year. Months go from 1-12
CalendarMaker.getInstance().formYears();
  -Forms the years with the given conditions in the foor loop. (Year span)
