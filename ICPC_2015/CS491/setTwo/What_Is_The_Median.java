package setTwo;

import java.util.Collections;

public class What_Is_The_Median {
	
	public static void main (String[]args)
	{
		java.util.ArrayList<Integer> list = new java.util.ArrayList <Integer> ();
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		
		while (stdin.hasNext())
		{
			list.add(stdin.nextInt());
			Collections.sort(list);
			
			if (list.size() % 2 == 0)
			{
				int size = list.size();
				int first = list.get(size/2 -1);
				int second = list.get(size/2);
				System.out.println((first + second)/2);
			}
			else
			{
				System.out.println(list.get(list.size()/2));
			}
		}
	}

}
