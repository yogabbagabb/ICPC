package setFour;

public class AnotherTest {

	public static void main (String[]args)
	{
		String hello = "hello";
		AnotherTest.add(hello);
		System.out.println(hello);
	}
	
	public static void add(String s)
	{
		s += "foo";
	}
}
