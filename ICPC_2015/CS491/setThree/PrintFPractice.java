package setThree;

import java.util.Calendar;

public class PrintFPractice {
	
	public static void main (String[]args)
	{
		double toRound = 1.3445;
		System.out.printf("Here is the rounded number : %.3f",toRound);
		System.out.println();
		// the line below will produce an error: if you don't specify the particular argument
		// to be modified using your format String, then java simply uses the next String
		// in the varArgs list -- that is, the first string that hasn't yet been formatted.
//		System.out.format("Hello %s.\nToday is the %.3f day of your life", "Aahan", "Joe", 3.3446);
		Calendar c = Calendar.getInstance();
		System.out.format("This ist the %tD hour and %tl:%tM", c);
	}

}
