package setOne;

import java.math.BigDecimal;

public class SimplerFinancialManager {

	public static void main (String[]args)
	{
		
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		double total = 0;
		
		for (int i = 0 ; i < 12; i++)
		{
			total += stdin.nextDouble();
		}
		
		double average = total/12;
		average = (average*1000);
		average = average - (average % 1.0);
		average = (average/1000);
		BigDecimal format = new BigDecimal(average);
		format = format.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("$" + format);
	}

}
