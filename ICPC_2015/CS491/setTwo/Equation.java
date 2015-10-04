package setTwo;

public class Equation {

	
	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		java.util.Stack <String> stack = new java.util.Stack<String> ();
		java.util.ArrayList<String> equationList = new java.util.ArrayList<> ();
		
		int scenarios = stdin.nextInt();
		stdin.nextLine();
		String nextLine = stdin.nextLine();
		
		for (int i = 0; i < scenarios; i++)
		{
			String next = stdin.nextLine();
			while (! next.equals(""))	
			{
				if (!next.equals(")"))
				{
					stack.push(next);
				}
				else
				{
					while (!stack.peek().equals("("))
					{
						equationList.add(0,stack.pop());
					}
					String reAdd = Equation.processEquation(equationList);
					// remove parentheses '('
					stack.pop();
					stack.push(reAdd);
					equationList.clear();
				}
				
				next = stdin.nextLine();
			}
			
			
			while (!stack.isEmpty())
			{
				equationList.add(0,stack.pop());
			}
			
	//		equationList = Equation.orderByPrecedence(equationList);
			System.out.println(Equation.processEquation(equationList));
			System.out.println();
			equationList.clear();
		}
	}
	
	public static String processEquation(java.util.List <String> equation)
	{
		java.util.ArrayList <String> firstRound = new java.util.ArrayList<String> ();
	
		int i = 0;
		while (i < equation.size())
		{
			if (equation.get(i).equals("*") || equation.get(i).equals("/"))
			{
				String previous = firstRound.remove(firstRound.size()-1);
				firstRound.add(previous + equation.get(i+1) + equation.get(i));
				i += 2;
			}
			else
			{
				firstRound.add(equation.get(i));
				i++;
			}
		}
		
//		firstRound = Equation.orderByPrecedence(firstRound);
		String next = "";
		while (!(next = stdin.next()).equals("a"))	
		{
			if (!next.equals(")"))
			{
				stack.push(next);
			}
			else
			{
				while (!stack.peek().equals("("))
				{
					equationList.add(0,stack.pop());
				}
				String reAdd = Equation.processEquation(equationList);
				// remove parentheses '('
				stack.pop();
				stack.push(reAdd);
				equationList.clear();
			}
		}
		
		
		while (!stack.isEmpty())
		{
			equationList.add(0,stack.pop());
		}
		
		equationList = Equation.orderByPrecedence(equationList);
		System.out.println(Equation.processEquation(equationList));
	}
	
//	public static String processEquation(java.util.List <String> equation)
//	{
//		java.util.ArrayList <String> firstRound = new java.util.ArrayList<String> ();
//	
//		int i = 0;
//		while (i < equation.size())
//		{
//			if (equation.get(i).equals("*") || equation.get(i).equals("/"))
//			{
//				String previous = firstRound.remove(firstRound.size()-1);
//				firstRound.add(previous + equation.get(i+1) + equation.get(i));
//				i += 2;
//			}
//			else
//			{
//				firstRound.add(equation.get(i));
//				i++;
//			}
//		}
//		
//		firstRound = Equation.orderByPrecedence(firstRound);
//>>>>>>> branch 'master' of https://github.com/yogabbagabb/ICPC_2015
		
		java.util.ArrayList <String> finalRound = new java.util.ArrayList<String> ();
		i = 0;
		while (i < firstRound.size())
		{
			if (firstRound.get(i).equals("+") || firstRound.get(i).equals("-"))
			{
				String previous = finalRound.remove(finalRound.size()-1);
				finalRound.add(previous + firstRound.get(i+1) + firstRound.get(i));
				i += 2;
			}
			else
			{
				finalRound.add(firstRound.get(i));
				i++;
			}
		}
		
		String output = "";
		for (String letter: finalRound)
			output += letter;
		
		return output;
		
	}
	
	public static java.util.ArrayList<String> orderByPrecedence(java.util.List<String> list)
	{
		java.util.ArrayList<String> finalList = new java.util.ArrayList<String> ();
		
		// if the first index is a postfix, tis fine
		for (int i = 0 + 1; i < list.size(); i++)
		{
			if (Equation.isAPostFix(list.get(i)))
			{
				finalList.add(list.get(i));
				list.remove(i);
				i -= 1;
				
				while (list.get(i).equals("*") || list.get(i).equals("/"))
				{
					finalList.add(list.get(i));
					finalList.add(list.get(i-1));
					list.remove(i);
					list.remove(i-1);
					i -= 2;
				}
					
					
				finalList.add(list.get(i));
				list.remove(i);
				i-= 1;	
			}
		}
		
		for (String remainingString: list)
		{
			finalList.add(remainingString);
		}
		
		return finalList;
		
	}
	
	public static boolean isAPostFix(String postFix)
	{
//		System.out.print(postFix + " ");
//		System.out.println(postFix.matches(".*[0-9].*") && postFix.matches(".*[*+-/].*"));
//		return (postFix.matches("^*([*/+-])*([0-9])$"));
		
		return (postFix.matches(".*[0-9].*") && postFix.matches(".*[*+-/].*"));
	}
}
