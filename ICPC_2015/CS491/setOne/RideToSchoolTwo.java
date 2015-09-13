package setOne;
import java.util.Scanner;
import java.math.MathContext;
import java.math.BigDecimal;

public class RideToSchoolTwo {
	
	public static final double MAX_DISTANCE = 4500;
	public static final double KPH_TO_MPS = 3.6;
	
	public static void main (String[]args)
	{
		Scanner stdin = new Scanner (System.in);
		int cases = 0;
		double leastTime = 0;
		
		while ((cases = stdin.nextInt()) != 0)
		{
			
			int count = 0;
			
			while(leastTime <= 0)
			{
				double speed = KPH_TO_MPS * stdin.nextDouble();
				double timeOff = stdin.nextDouble();
					
				if (speed > 0 && timeOff > 0)
				{
					leastTime = (timeOff + MAX_DISTANCE/speed);
				}
				
				count++;
			}	
				
			
			for (int i = 0; i < cases - count; i++)
			{
				double speed = KPH_TO_MPS * stdin.nextDouble();
				double timeOff = stdin.nextDouble();
				
				if (speed > 0 && timeOff > 0 && (timeOff + MAX_DISTANCE/speed) < leastTime)
				{
					leastTime = (timeOff + MAX_DISTANCE/speed);
				}
			}
			
			MathContext context = new MathContext (RideToSchoolTwo.getOrder(leastTime), java.math.RoundingMode.HALF_UP);
			BigDecimal output = new BigDecimal (leastTime);
			output = output.round(context);
			System.out.println(output);
			leastTime = 0;
			
		}
		
	}
	
	public static int getOrder(double value)
	{
		int count = 0;
		int powerOfTen = 1;
		while ((int)value/powerOfTen != 0)
		{
			count++;
			powerOfTen *= 10;
		}
		
		return count;
	}

}
