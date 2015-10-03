package setThree;

public class BetterJosephus {

	public static void main (String[]args)
	{
		java.util.LinkedList<Integer> list = new java.util.LinkedList <> ();
		int N = 7;
		int S = 0;
		int K = 2;
		
		for (int i = 1; i <= N; i++)
		{
			list.add(i);
		}
		
		for (int i = 1; i < N; i++)
		{
			for (int j = 1; j <= K-1; j++)
			{
				S++;
				S = S % list.size();
			}
			list.remove(S);
			System.out.println(list);
		}
		
		System.out.println(list.get(0));
	}
}
