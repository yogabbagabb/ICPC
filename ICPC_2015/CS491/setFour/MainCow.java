package setFour;

import java.util.Arrays;


public class Main
{
	

public static java.util.List<java.util.LinkedList<String>> cowList = new java.util.ArrayList<java.util.LinkedList<String>> ();
public static java.util.List<boolean[]> visitedList = new java.util.ArrayList<boolean[]> ();


	public static void main (String[]args)
	{

		java.util.Scanner stdin = new java.util.Scanner (System.in);

		int farms = stdin.nextInt();
		int measurements = stdin.nextInt();
		cowList.clear();
		for (int i = 0; i < farms; i++)

		{
			cowList.add(new java.util.LinkedList<String> ());
			visitedList.add(new boolean[farms]);
		}

		while (measurements > 0)
		{

			int firstCow = stdin.nextInt() - 1;
			int secondCow = stdin.nextInt() - 1;
			int distance = stdin.nextInt();

			String direction = stdin.next();
			
			cowList.get(firstCow).add(secondCow + direction + distance);
			cowList.get(secondCow).add(firstCow + direction + distance);
			
			measurements--;

		}

		java.util.ArrayList<String> finalDistances = new java.util.ArrayList<String> ();
		
		for (int i = 0; i < farms; i++)
		{
			Main.findDistances(finalDistances, i, i, "", new boolean[farms]);
			visitedList.clear();
			for (int j = 0; j < farms; j++)
			{
				visitedList.add(new boolean[farms]);
			}
		}
		
		int[] d = new int[finalDistances.size()];
		for (int i = 0; i < finalDistances.size(); i++)
		{

			d[i] = Main.processDistance(finalDistances.get(i));

		}

		int max = d[0];
		for (int i = 1; i < d.length; i++)
		{
			if (d[i] > max)
				max = d[i];
		}
		
		System.out.println(max);

	}

	public static void findDistances(java.util.List<String> finalDistances, int lastIndex, int cowIndex, String developingDistance, boolean[] alreadyVisited)
	{

		java.util.LinkedList<String> thisCowList = cowList.get(cowIndex);
		alreadyVisited[lastIndex] = true;
		
		boolean allVisited = true;
		
		for(String cowInfo: thisCowList)
		{
			
			String newDevelopingDistance = developingDistance;
			int possibleCow = Integer.parseInt(cowInfo.substring(0, 1));
			
			if (alreadyVisited[possibleCow] == false)
			{
				allVisited = false;
				newDevelopingDistance += cowInfo.substring(1) + " ";
				alreadyVisited[possibleCow] = true;
				Main.findDistances(finalDistances, cowIndex, possibleCow, newDevelopingDistance, alreadyVisited);
			}

		}

		if (allVisited)
		{
			finalDistances.add(developingDistance);
		}

	}
	
	public static int processDistance(String s)
	{

		int total = 0;
		java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(s);

		while (tokenizer.hasMoreTokens())
		{
			String next = tokenizer.nextToken();
			total += Integer.parseInt(next.substring(1));
		}

		return total;

	}

}