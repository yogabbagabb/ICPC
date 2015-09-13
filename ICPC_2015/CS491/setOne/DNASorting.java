package setOne;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class DNASorting {

	public static void main (String[]args)
	{
		Scanner stdin = new Scanner (System.in);
		java.util.StringTokenizer t = new java.util.StringTokenizer(stdin.nextLine());
		int length = Integer.parseInt(t.nextToken());
		int number = Integer.parseInt(t.nextToken());
		
		String[] sequences = new String[number];
		for (int i = 0; i < number; i++)
		{
			sequences[i] = stdin.nextLine();
		}
		
		java.util.Comparator<java.util.Map.Entry<String,Integer>> comparator = new java.util.Comparator <java.util.Map.Entry<String,Integer>> ()
		{

			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}

			
		};
		
		java.util.TreeMap <String, Integer> map = new java.util.TreeMap <String, Integer> ();
		for (String sequence: sequences)
			map.put(sequence, DNASorting.countDisarray(sequence));
		
		java.util.List <Map.Entry<String, Integer>> list = new java.util.ArrayList<Map.Entry<String,Integer>> (map.entrySet());
		Collections.sort(list, comparator);

		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).getKey());
		}
		
	}
	
	public static int countDisarray(String s)
	{
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i+1; j < s.length(); j++)
			{
				if (s.substring(i, i+1).compareTo(s.substring(j, j+1)) > 0)
				{
					count++;
				}
			}
		}
		
		return count;
	}

}
