package setOne;
import java.util.Scanner;
public class Exponentiation 
{
	
	public static void main (String[]args)
	{
		Scanner stdin = new Scanner (System.in);
		double num = stdin.nextDouble();

		double expo = stdin.nextDouble();
		num = Math.pow(num, expo);
		System.out.println(num);
		java.util.Formatter formatter = new java.util.Formatter ();
		String numS = formatter.format("%f", num).toString();
		System.out.println(numS);
		if (!(numS.indexOf(".") < 0))
		{
			numS = numS.replaceAll("0*$", "");
		}
		
		System.out.println(numS);
	}
	
	

	
}
