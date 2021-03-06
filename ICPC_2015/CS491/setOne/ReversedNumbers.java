package setOne;
import java.util.Scanner;

public class ReversedNumbers {

	public static void main (String[]args)
	{
		Scanner stdin = new Scanner (System.in);
		int number = stdin.nextInt();
		int[]array = new int[number];
		
		for (int i = 0; i < number; i++)
		{
			int first = ReversedNumbers.reverseNumber(stdin.nextInt());
			int second = ReversedNumbers.reverseNumber(stdin.nextInt());
			
			int sum = first + second;
			array[i] = (ReversedNumbers.reverseNumber(sum));
		}
		
		for (int i: array)
		{
			System.out.println(i);
		}
	}
	
	public static int reverseNumber(int number)
	{
		String num = String.valueOf(number);
		String output = "";
		for (int i = num.length()-1; i >= 0; i--)
		{
			String digit = num.substring(i, i+1);
			if (!(digit.equals("0") && (i == num.length()-1)))
			{
				output += digit;
			}
		}
		
		return Integer.parseInt(output);
	}

}
