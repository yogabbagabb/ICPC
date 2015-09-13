package playAround;

public class TryCharSet {

	public static void main (String[]args)
	{
		int[] array = new int[26];
		int count = 0;
		
		for (int i = 'A'; i <= 'Z'; i++)
		{
			array[count] = i;
			count++;
		}
		
		byte[] secondArray = new byte[26];
		count = 0;
		for (int i: array)
		{
			secondArray[count] = (byte) i;
			count++;
		}
		
		String s = new String (secondArray);
		System.out.println(s);
		
		for (int a: array)
		{
			System.out.println(a);
		}
	}
	
	
	

}
