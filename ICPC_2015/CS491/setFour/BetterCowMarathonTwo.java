package setFour;

import java.util.Arrays;


public class BetterCowMarathonTwo
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
			String secondDirection = "";
			
			if (direction.equals("E"))
				secondDirection = "W";
			else if (direction.equals("W"))
				secondDirection = "E";
			else if (direction.equals("N"))
				secondDirection = "S";
			else if (direction.equals("S"))
				secondDirection = "N";
			
			cowList.get(firstCow).add(secondCow + direction + distance);
			cowList.get(secondCow).add(firstCow + secondDirection + distance);
			
			measurements--;

		}

		java.util.ArrayList<String> finalDistances = new java.util.ArrayList<String> ();
		
		for (int i = 0; i < farms; i++)
		{
			BetterCowMarathonTwo.findDistances(finalDistances, i, i, "");
			visitedList.clear();
			for (int j = 0; j < farms; j++)
			{
				visitedList.add(new boolean[farms]);
			}
		}
		
		int[] d = new int[finalDistances.size()];
		for (int i = 0; i < finalDistances.size(); i++)
		{

			d[i] = BetterCowMarathonTwo.processDistance(finalDistances.get(i));

		}

		int max = d[0];
		for (int i = 1; i < d.length; i++)
		{
			if (d[i] > max)
				max = d[i];
		}
		
		System.out.println(finalDistances);
		System.out.println(Arrays.toString(d));
		
		System.out.println(max);

	}

	public static void findDistances(java.util.List<String> finalDistances, int lastIndex, int cowIndex, String developingDistance)
	{

		java.util.LinkedList<String> thisCowList = cowList.get(cowIndex);
		boolean [] alreadyVisited = visitedList.get(cowIndex);
		alreadyVisited[lastIndex] = true;
		
		boolean allVisited = true;
		
		for(String cowInfo: thisCowList)
		{
			java.util.List<boolean[]> snapShot = new java.util.ArrayList<boolean[]> ();
			for (boolean[] array: visitedList)
			{
				snapShot.add(array.clone());
			}
			
			String newDevelopingDistance = developingDistance;
			int possibleCow = Integer.parseInt(cowInfo.substring(0, 1));
			
			if (alreadyVisited[possibleCow] == false)
			{
				allVisited = false;
				newDevelopingDistance += cowInfo.substring(1) + " ";
				alreadyVisited[possibleCow] = true;
				BetterCowMarathonTwo.findDistances(finalDistances, cowIndex, possibleCow, newDevelopingDistance);
			}
			
			visitedList = snapShot;

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