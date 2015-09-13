package setOne;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class VerticalHistogram {

	private static java.util.TreeMap<String, Integer> map = new java.util.TreeMap<> ();
	private static int max = 0;
	
	public static void main(String[]args)
	{
		
		Scanner stdin = new Scanner (System.in);
		VerticalHistogram.initializeMap();
		
		for (int i = 0; i < 4; i++)
		{
			StringTokenizer tokenizer = new StringTokenizer (stdin.nextLine());
			while (tokenizer.hasMoreTokens())
			{
				VerticalHistogram.countLettersOfWord(tokenizer.nextToken());
			}
			
		}
		
		
		for (int i = max; i > 0; i--)
		{
			for (int j = 'A'; j <= 'Z'; j++)
			{
				if (map.get(String.valueOf((char)j)) >= i)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
				
				if (j != 'Z')
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		
		for (int j = 'A'; j <= 'Z'; j++)
		{
			System.out.print((char)j);
			
			if (j != 'Z')
			{
				System.out.print(" ");
			}
		}
		
		
	}
	
	public static void initializeMap()
	{
		for (int i = 'A'; i <= 'Z'; i++)
		{
			String letter = new String(new char[]{(char)i});
			map.put(letter, 0);
		}
	}
	public static void countLettersOfWord(String word)
	{
		for (int i = 0; i < word.length(); i++)
		{
			String letter = word.substring(i, i+1);
			
			if (letter.matches("[a-zA-Z]+"))
			{
				int val = map.get(letter);
				map.put(letter, val + 1);
				if (val + 1 > max)
				{
					max = val + 1;
				}
			}
			
		}
	}

}
