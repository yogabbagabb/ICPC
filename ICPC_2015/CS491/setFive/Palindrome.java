package setFive;

public class Palindrome {

	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner(System.in);
		int num = stdin.nextInt();
		String input = stdin.next();
		
		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--)
		{
			reverse += input.substring(i, i+1);
		}
		
		int[][] array = new int[num+1][num+1];
		for (int i = 0; i <= num; i++)
		{
			array[i][0] = 0;
		}
		for (int i = 0; i <= num; i++)
		{
			array[0][i] = 0;
		}
		
		for (int i = 1; i <= num; i++)
		{
			for (int j = 1; j <= num; j++)
			{
				if (input.charAt(j-1) == reverse.charAt(i-1))
				{
					array[i][j] = array[i-1][j-1] + 1;
				}
				else
				{
					array[i][j] = Math.max(array[i-1][j],array[i][j-1]);
				}
			}
		}
		
		int lcs = array[num][num];
		System.out.println(num - lcs);
	}
	
//	public static int getMaxS(String a, int a1, String b, int b1)
//	{
//		if (a1 == -1 || b1 == -1)
//			return 0;
//		
//		if (a.charAt(a1) == b.charAt(b1))
//			return 1+ Palindrome.getMaxS(a, a1-1, b, b1-1);
//		else
//		{
//			return Math.max(Palindrome.getMaxS(a, a1-1, b, b1),Palindrome.getMaxS(a, a1, b, b1-1));
//		}
//	}
	
}
