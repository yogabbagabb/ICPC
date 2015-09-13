package setOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class BigSquare 
{
	
	public static String[][] coordinateArray;
	public static final String KEY = "J";
	public static final String ANTI_KEY = "B";
	public static final String OPEN = "*";
	
	public static void main (String[]args)
	{
		
		Scanner stdin = new Scanner (System.in);
		int size = stdin.nextInt();
		
		coordinateArray = new String[size][size];
		int count = 0;
		
		for (int i = 0; i < size; i++)
		{
			String line = stdin.next();
			for (int j = 0; j < line.length(); j++)
			{	
				coordinateArray[count/size][count%size] = line.substring(j, j+1);
				count++;
			}
		}
		
		
		ArrayList<Integer> list = new ArrayList <Integer> ();
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				list.add(BigSquare.getOptimumLocation(i, j));
			}
		}
		
		System.out.println(BigSquare.getListMax(list));
		
	}
	
	public static int getOptimumLocation(int x, int y)
	{
		ArrayList<Integer> list = new ArrayList <Integer> ();

		list.add(BigSquare.goRight(x, y));
		list.add(BigSquare.goDown(x, y));
		
		return BigSquare.getListMax(list);
	}
	
	public static int goDown(int x, int y)
	{
		ArrayList<Integer> list = new ArrayList <Integer> ();
		
		if (coordinateArray[x][y].equals(KEY))
			for (int i = x+1; i < coordinateArray.length; i++)
			{
				if (coordinateArray[i][y].equals(KEY))
				{
					// to the Right case
					if (y + (i-x) < coordinateArray.length)
					{
						boolean condition = 
								(coordinateArray[i][y+(i-x)].equals(KEY) || coordinateArray[x][y+(i-x)].equals(KEY))
								&& (!coordinateArray[i][y+(i-x)].equals(ANTI_KEY) && !coordinateArray[x][y+(i-x)].equals(ANTI_KEY));
						
						if (condition)
							list.add((int)Math.pow(i-x, 2));
						
					}
					
					// to the Left case
					if (y - (i-x) >= 0)
					{
						boolean condition =  
								(coordinateArray[i][y-(i-x)].equals(KEY) || coordinateArray[x][y-(i-x)].equals(KEY))
								&& (!coordinateArray[i][y-(i-x)].equals(ANTI_KEY) && !coordinateArray[x][y-(i-x)].equals(ANTI_KEY));
						
						if (condition)
							list.add((int)Math.pow(i-x, 2));
					}
					
					// diagonal case
					if (y + (i-x)/2 < coordinateArray.length && y - (i-x)/2 >= 0 && (i-x)%2 == 0)
					{
						boolean condition = 
								(coordinateArray[x+(i-x)/2][y + (i-x)/2].equals(KEY) || coordinateArray[x+(i-x)/2][y - (i-x)/2].equals(KEY))
								&& (!coordinateArray[x+(i-x)/2][y + (i-x)/2].equals(ANTI_KEY) && !coordinateArray[x+(i-x)/2][y - (i-x)/2].equals(ANTI_KEY));
						
						if (condition)
								list.add((int)(2*Math.pow((i-x)/2, 2)));
						
					}
						
				}
			}
			
		return BigSquare.getListMax(list);
		
	
		
	}
	public static int goRight(int x, int y)
	{
		ArrayList<Integer> list = new ArrayList <Integer> ();
		
		if (coordinateArray[x][y].equals(KEY))
			for (int i = y+1; i < coordinateArray.length; i++)
			{
				if (coordinateArray[x][i].equals(KEY))
				{
					if (x + (i-y) < coordinateArray.length)
					{
						boolean condition = 
								(coordinateArray[x+(i-y)][y].equals(KEY) || coordinateArray[x+(i-y)][i].equals(KEY))
								&& (!coordinateArray[x+(i-y)][y].equals(ANTI_KEY) && !coordinateArray[x+(i-y)][i].equals(ANTI_KEY));
						
						if (condition)
							list.add((int)Math.pow(i-y, 2));
						
					}
					
					if ((i-y)%2 == 0 && x + (i-y)/2 < coordinateArray.length && x- (i-y)/2 >= 0)
					{
						boolean condition = 
								(coordinateArray[x-(i-y)/2][y+(i-y)/2].equals(KEY) || coordinateArray[x+(i-y)/2][y+(i-y)/2].equals(KEY))
								&& (!coordinateArray[x-(i-y)/2][y+(i-y)/2].equals(ANTI_KEY) && !coordinateArray[x+(i-y)/2][y+(i-y)/2].equals(ANTI_KEY));
						
						if (condition)
							list.add((int)(2*Math.pow((i-y)/2, 2)));

					}
						
				}
			}
			
		
		return BigSquare.getListMax(list);
		
	
		
	}
	

	
	public static int getListMax(java.util.List <Integer> list)
	{
		if (list.size() == 0)
			return 0;
		
		
		int max = list.get(0);
		for (int spot : list)
		{
			if (spot > max)
			{
				max = spot;
			}
		}
		return max;
	}
	
	
}


class PotentialSpot
{
	public int x, y;
	public int xo, yo;
	public int area;
	
	public PotentialSpot(int a, int b, int c, int d, int e)
	{
		x = a;
		y = b;
		xo = c;
		yo = d;
		area = e;
	}

	
}
