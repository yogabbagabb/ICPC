package setOne;

public class Hangover {

	public static void main (String[]args)
	{
		java.util.Scanner scan = new java.util.Scanner (System.in);
		String store = "";
		
		double next = 0;
		while ((next = scan.nextDouble()) != 0.00)
		{
			store += "" + next + " ";
		}
		
		String[] array = store.split(" ");
		for (String member: array)
		{
			System.out.println(Hangover.getCardLength(Double.parseDouble(member)) + " cards(s)");
		}
		
	}
	
	public static int getCardLength(double value)
	{
		float length = 0;
		int card = 0;
		while (length < value)
		{
			length += (1/(card+2.0));
			card++;
		}
		
		return card;
	}
	
}
