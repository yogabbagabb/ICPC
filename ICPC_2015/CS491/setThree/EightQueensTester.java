package setThree;

public class EightQueensTester {

	
	public static void main (String[]args)
	{
		int position = 32;
		int row = position - 8*(position/8);
		int col = position/8;
		for (int i = position, x = row, y = col; x <= 7 && y <= 7; i+= 9, x++, y++)
		{
			System.out.println(i);
		}
	}
}
