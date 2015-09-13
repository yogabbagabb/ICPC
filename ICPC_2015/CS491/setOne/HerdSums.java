package setOne;
import java.util.Scanner;

public class HerdSums
{

	public static void main(String[]args)
	{
		Scanner stdin = new Scanner (System.in);
		int number = stdin.nextInt();
		int count = 0;
		
		for (int i = 1; i <= number; i++)
		{
			int sum = i;
			int j = i;
			while (sum < number)
			{
				j++;
				sum += j;
			}
			
			if (sum == number)
			{
				count++;
				System.out.println(i);
			}
		}
		
		System.out.println(count);
		stdin.close();
	}

}
