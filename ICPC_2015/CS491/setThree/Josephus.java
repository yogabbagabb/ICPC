package setThree;

public class Josephus {
	
	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		int numberPeople = stdin.nextInt();
		int startingPos = stdin.nextInt();
		int skip = stdin.nextInt();
		
		int deleted = 0;
		 
		while (deleted < numberPeople)
		{
			startingPos += (skip + deleted);
			if (startingPos != numberPeople)
				startingPos = startingPos % numberPeople;
			deleted++;
		}
		
		System.out.println(startingPos);
	}

}
