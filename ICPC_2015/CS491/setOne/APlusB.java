package setOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB 
{

	public static void main (String[]args)
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			String line = input.readLine();
			String[] array = line.split(" ");
			int output = Integer.parseInt(array[0]) + Integer.parseInt(array[1]); 
			System.out.println(output);
			input.close();
		} 
		
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}
