package setFour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;



public class BetterCowMarathonTwo
{
	
	public static List<LinkedList<String>> cowList = new ArrayList<LinkedList<String>> ();
	public static void main (String[]args)
	{
		Scanner stdin = new Scanner (System.in);

		int farms = stdin.nextInt();
		int measurements = stdin.nextInt();
		cowList.clear();
		for (int i = 0; i < farms; i++)

		{
			cowList.add(new LinkedList<String> ());
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

		ArrayList<Integer> finalDistances = new ArrayList<Integer> ();
		
		for (int i = 0; i < farms; i++)
		{
			BetterCowMarathonTwo.findDistances(finalDistances, i, i, 0, new boolean[farms],true);
		}
		
		System.out.println(Collections.max(finalDistances));
		

	}

	public static void findDistances(List<Integer> finalDistances, int lastIndex, int cowIndex, int developingDistance, boolean[] alreadyVisited, boolean firstTime)
	{

		LinkedList<String> thisCowList = cowList.get(cowIndex);
		
		if (!firstTime)
			alreadyVisited[lastIndex] = true;
		
		boolean allVisited = true;
		
		for(String cowInfo: thisCowList)
		{
			
			int newDevelopingDistance = developingDistance;
			int possibleCow = Integer.parseInt(cowInfo.substring(0, 1));
			
			if (alreadyVisited[possibleCow] == false)
			{
				allVisited = false;
				newDevelopingDistance += Integer.parseInt(cowInfo.substring(2));
				alreadyVisited[possibleCow] = true;
				BetterCowMarathonTwo.findDistances(finalDistances, cowIndex, possibleCow, newDevelopingDistance, alreadyVisited, false);
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
		StringTokenizer tokenizer = new StringTokenizer(s);

		while (tokenizer.hasMoreTokens())
		{
			String next = tokenizer.nextToken();
			total += Integer.parseInt(next.substring(1));
		}

		return total;

	}

}