package setTwo;

public class Conformity {
	
	public static void main(String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		int nums;
		while ((nums = stdin.nextInt()) != 0)
		{
			java.util.HashMap<String, Integer> combinations = new java.util.HashMap<String,Integer> ();
			
			
			for (int i = 0; i < nums; i++)
			{
				String[] array = new String[5];
				for (int j = 0; j < 5; j++)
				{
					array[j] = stdin.next();
				}
				
				Conformity.sortStringArray(array);
				String combination = Conformity.getCombination(array);
				
				int value = 1;
				if (!combinations.containsKey(combination))
				{
					combinations.put(combination, value);
				}
				else
				{
					combinations.put(combination, combinations.get(combination) + 1);
				}
			}
			
			

			int maxValue = 1;
<<<<<<< HEAD
			int numOccurences = 1;
			for (java.util.Map.Entry<String, Integer> entry: combinations.entrySet())
			{
				if (entry.getValue() > maxValue)
				{
					maxValue = entry.getValue();
					numOccurences = 1;
				}
				else if (entry.getValue() == maxValue)
				{
					numOccurences++;
				}
			}
			
			System.out.println(numOccurences * maxValue);
			
			
=======
			for (java.util.Map.Entry<String, Integer> entry: combinations.entrySet())
			{
				if (entry.getValue() > maxValue)
				{
					maxValue = entry.getValue();
				}
			}
			
			System.out.println(maxValue);
>>>>>>> branch 'master' of https://github.com/yogabbagabb/ICPC_2015
		}
	}
	
	public static void sortStringArray(String[]array)
	{
		for (int i = 0; i < array.length; i++)
		{
			
			for (int j = i; j-1 >= 0; j--)
			{
				if (array[j].compareTo(array[j-1]) > 0)
				{
					String swap = array[j];
					array[j] = array[j-1];
					array[j-1] = swap;
				}
			}
		}
	}
	
	public static String getCombination(String[]array)
	{
		String combination = "";
		
		for(String member: array)
		{
			combination += member + " ";
		}
		
		combination.replaceAll(" $", "");
		return combination;
	}

}
