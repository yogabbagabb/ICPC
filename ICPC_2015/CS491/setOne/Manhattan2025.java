package setOne;
import java.util.Scanner;

public class Manhattan2025 {
	
	
	public static int slices;
	public static int mid;
	public static int scenarios;
	public static void main (String[]args)
	{
		Scanner stdin = new Scanner (System.in);
		scenarios = stdin.nextInt();
		int[] fuelCases = new int[scenarios];
		
		for (int i = 0; i < scenarios; i++)
		{
			fuelCases[i] = stdin.nextInt();
		}
		
		
		
		for (int j = 0; j < scenarios; j++)
		{
			System.out.println("Scenario #" + (j+1) + ":");
			int fuel = fuelCases[j];
			slices = 2*fuel + 1;
			mid = fuel + 1;
			
			for (int i = 1; i <= slices; i++)
			{
				int fuelConsumed = (int)(Math.abs(i - mid));
				if (fuelConsumed > fuel)
				{
					System.out.println("slice #" + i);
					System.out.println(0);
				}
				
				else
				{
					System.out.println("slice #" + i + ":");
					Manhattan2025.examineSlice(fuel - fuelConsumed, fuelConsumed, j, i);
				}
				
			}
			
			if (j != scenarios-1)
			{
				System.out.println();
			}
			
		}
		
	}
	
	
	public static void examineSlice(int fuelLeft, int fuelConsumed, int scenario, int slice)
	{
		for (int i = 1; i <= slices; i++)
		{
			for (int j = 1; j <= slices; j++)
			{
				int farAway = (int)(Math.abs(mid - j) + Math.abs(mid - i));
				if (farAway > fuelLeft)
				{
					System.out.print(".");
				}
				else
				{
					System.out.print(String.valueOf(farAway + fuelConsumed));
				}
				
				if (j != slices)
				{
					System.out.print(" ");
				}
			
			}
			
			if (scenario != scenarios-1 || slice != slices || i != slices)
			{
				System.out.println();
			}
		}
	}

}
