package setFive;

import java.util.Arrays;

public class DynamicPlayaround 
{

	public static void main (String[]args)
	{
		int[] array = new int[] {2,2,4,8,9};
		System.out.println(DynamicPlayaround.getMax(array));
	}
	public static int getMax(int [] array)
	{
		if (array.length == 1)
		{
			return array[0];
		}
		
		else if (array.length == 2)
		{
			return Math.max(array[0], array[1]);
		}
		
		int[] oneMinus = Arrays.copyOf(array, array.length - 1);
		int[] twoMinus = Arrays.copyOf(array, array.length - 2);
		return Math.max(DynamicPlayaround.getMax(oneMinus), DynamicPlayaround.getMax(twoMinus) + 
		array[array.length - 1]);
		
	}
}
