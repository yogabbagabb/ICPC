package setTwo;

public class Rails 
{
	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		java.util.Stack<Integer> stationCars = new java.util.Stack<Integer> ();
		java.util.LinkedList<Integer> originalCars = new java.util.LinkedList<Integer> ();
		int[]orderArray;
		
		int cars;
		while ((cars = stdin.nextInt()) != 0)
		{
			stdin.nextLine();
			String desiredOrder = "";
			orderArray = new int[cars];
			
			while (!(desiredOrder = stdin.nextLine()).equals("0"))
			{
				java.util.StringTokenizer tokenizer = new java.util.StringTokenizer (desiredOrder);
				
				// orderArray prepared
				int count = 0;
				while (tokenizer.hasMoreTokens())
				{
					orderArray[count] = Integer.parseInt(tokenizer.nextToken());
					count++;
				}
				
				// originalCars prepared
				originalCars.clear();
				for (int i = 1; i <= cars; i++)
				{
					originalCars.add(i);
				}
				
				stationCars.clear();
				for (int i = 0; i < orderArray.length; i++)
				{
					int desiredCar = orderArray[i];
					while (originalCars.peek() != null && originalCars.peek() <= desiredCar)
					{
						stationCars.add(originalCars.poll());
					}
					
					if (stationCars.peek() == desiredCar)
					{
						stationCars.pop();
					}
					else
					{
						break;
					}
				}
				
				if (stationCars.size() == 0)
				{
					System.out.println("Yes");
				}
				else
				{
					System.out.println("No");
				}
				
			}
			System.out.println();
			
		}
	}
}
