package setOne;

import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.math.BigDecimal;

public class FinancialManager {

	public static void main (String[]args)
	{
		java.util.Scanner scan = new java.util.Scanner (System.in);
		double total = 0;
		
		for (int i = 0 ; i < 1; i++)
		{
			total += scan.nextDouble();
		}
		
		DecimalFormat style = new DecimalFormat ("##.###");
		// How would you pattern the parameter to only take two significant digits
		total = Double.parseDouble(style.format(total));
		System.out.println(total);
//		MathContext context = new MathContext (2, RoundingMode.HALF_UP);
		// What precision does this give? Decimal precision or significant number precision
		BigDecimal output = new BigDecimal(total);
		output = output.setScale(2, RoundingMode.HALF_UP);
		// How can this specify decimal precision? If it does, why is the rounding off?
		System.out.println(output);

		//		System.out.println("$" + "" + total/12);
		
		
	}

}
