package playAround;

import java.util.Collections;

public class BishopsProblem 
{
	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		int remainingBishops = stdin.nextInt();
		size = stdin.nextInt();
		
		java.util.HashSet <java.util.List<Coordinate>> finalLinks = new java.util.HashSet <java.util.List<Coordinate>> ();
		
		BishopsProblem.getNumberPositions(remainingBishops, new java.util.HashSet<BishopsProblem.Coordinate>(), new java.util.ArrayList< BishopsProblem.Coordinate> (), finalLinks);
		System.out.println(finalLinks.size());
	}
	private static int size;
	
	public static void getNumberPositions(int remainingBishops, java.util.HashSet <Coordinate> invalidPositions, java.util.List <Coordinate> coordinateLink, java.util.HashSet<java.util.List<Coordinate>> finalLinks)
	{
		if (remainingBishops == 0)
		{
			Collections.sort(coordinateLink);
			finalLinks.add(coordinateLink);
		}
		
		else
		{
			int total = 0;
			for (int i = 0; i < (int)(Math.pow(size,2.0)); i++)	
			{
				int x = i/size;
				int y = i%size;
				
				Coordinate potentialCoordinate = new Coordinate(x,y);
				if (!invalidPositions.contains(potentialCoordinate))
				{
					java.util.HashSet<Coordinate> newSet = BishopsProblem.getInvalidPositions(x, y);
					java.util.HashSet<Coordinate> combinedSet = new java.util.HashSet<Coordinate> ();
					java.util.ArrayList<Coordinate> newLink = new java.util.ArrayList<Coordinate> ();
					newLink.addAll(coordinateLink);
					combinedSet.addAll(newSet);
					combinedSet.addAll(invalidPositions);
					coordinateLink.add(potentialCoordinate);
					BishopsProblem.getNumberPositions(remainingBishops - 1, combinedSet, newLink, finalLinks);
				}
			}
			
		}
	}
	
	public static java.util.HashSet<Coordinate> getInvalidPositions(int x, int y)
	{
		int topLeftX = x, topLeftY = y;
		
		while (topLeftX != 0 && topLeftY != 0)
		{
			topLeftX -= 1;
			topLeftY -= 1;
		}
		
		int topRightX = x, topRightY = y;
		while (topRightX != 0 && topRightY != size -1)
		{
			topRightX -= 1;
			topRightY += 1;
		}
		
		java.util.HashSet<Coordinate> invalidLocations = new java.util.HashSet<Coordinate> ();
		
		while (topLeftX != size && topLeftY != size)
		{
			invalidLocations.add(new Coordinate(topLeftX,topLeftY));
			topLeftX += 1;
			topLeftY += 1;
		}
		while (topRightX != size && topRightY != -1)
		{
			invalidLocations.add(new Coordinate(topRightX,topRightY));
			topRightX += 1;
			topRightY -= 1;
		}
		
		return invalidLocations;
	}
	
	static class Coordinate implements Comparable<Coordinate>
	{
		int x, y;
		
		public Coordinate(int a, int b)
		{
			x = a;
			y = b;
		}
		
		public String toString()
		{
			return "(" + x + "," + y + ")";
		}
		
		@Override
		public boolean equals(Object obj)
		{
			Coordinate object = (Coordinate) obj;
			return (this.x == object.x && this.y == object.y);
	
		}
		
		@Override
		public int hashCode()
		{
			return (int) (Math.pow(x, 31) + y);
		}

		@Override
		public int compareTo(Coordinate o) {
			return this.x - o.x + this.y;
		}
	}
}



