/*
ID: aahanag1
LANG: JAVA
TASK: ride
*/



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {

	private static String[] array;
	
	public static void initalizeArray()
	{
		array = new String[26];
		for (int i = 'a', count = 0; i <= 'z'; i++, count++)
		{
			array[count] = String.valueOf((char)i).toUpperCase();
		}
	}
	
	
	
	
	public static void main (String[]args) throws IOException
	{
		
		String comet = "";
		String group = "";
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader ("ride.in"));
			comet = reader.readLine();
			group = reader.readLine();
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		
		int cometValue = ride.getValueB(comet);
		int groupValue = ride.getValueB(group);
		boolean go = false;
		
		if (cometValue % 47 == groupValue % 47)
		{
			go = true;
		}
		else
		{
			go = false;
		}
		
		PrintWriter writer = new PrintWriter(new FileWriter("ride.out"));
		
		if (go)
		{
			writer.write("GO" + "\n");
		}
		else
		{
			writer.write("STAY" +"\n");
		}
		writer.close();
		System.exit(0);
		
		
	}
	
	
	public static int getValueB(String s)
	{
		int val = 1;
		for (int i = 0; i < s.length(); i++)
		{
			val *= s.charAt(i) - 'A' + 1;
		}
		return val;
	}
	
	public static int getNumValue(String s)
	{
		int mid = array.length/2;
		int start = 0; 
		int last = array.length - 1;
		boolean keepRunning = true;
		int output = 0;
		while (keepRunning)
		{
			if (array[mid].equals(s))
			{
				output = (mid + 1);
				keepRunning = false;
			}
			else if (array[mid].compareTo(s) < 0)
			{
				start = mid;
				mid = (start + last)/2;
			}
			else
			{
				last = mid;
				mid = (start + last)/2;
			}
		}
		
		return output;
	}
	
	public static int getValue(String s)
	{
		int value = 1;
		
		for (int i = 0; i < s.length(); i++)
		{
			int term = ride.getNumValue(s.substring(i, i+1));
			value *= term;
		}
		
		return value;
	}

}
