package setThree;

public class PermuteSeats 
{

	public static void main (String[]args)
	{
		java.util.ArrayList<String> someList = new java.util.ArrayList<String> ();
		for (int i = 'a'; i < 'j'; i++)
		{
			someList.add(String.valueOf((char)i));
		}
		
		java.util.ArrayList<String> finalList = new java.util.ArrayList<String> ();
		PermuteSeats.getPermutation(someList, finalList, "");
		System.out.println(finalList);
		System.out.println(finalList.size());
	}
	
	public static void getPermutation(java.util.List<String> list, java.util.List<String> finalList, String developing)
	{
		if (list.size() == 1)
		{
			finalList.add(developing + list.get(0));
		}
		else
		{
			String addendum = "";
			
			for (int i = 0; i < list.size(); i++)
			{
				
				java.util.List<String> copyList = new java.util.ArrayList<String> (list.size());
				addendum = list.get(i);
				for (String item: list)
				{
					if (!item.equals(addendum))
						copyList.add(item);
				}
				
				PermuteSeats.getPermutation(copyList, finalList, developing + addendum); 
			}
			
		}
	}
	
//	public static String permute(String s, int index)
//	{
//		for (int i = index; i < s.length(); i++)
//		{
//			// some function to swap two letters
//			// and then permute the newly constructed sring with index moved one down
//		}
//	}


}
