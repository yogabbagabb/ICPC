package setThree;

public class ExploringBitwiseOperations {
	
	public static void main(String[]args)
	{
		for (int i = 1; i <= 10; i++)
		{
			System.out.println("The " + i +"th" + " push: " + (i >> 1));
		}
	}

}
