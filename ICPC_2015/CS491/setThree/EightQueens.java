package setThree;


public class EightQueens {
	
	
	public static int queenPosition;
	public static int xQueenPos;
	public static int yQueenPos;
	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		int scenarios = stdin.nextInt();
		stdin.nextLine();
		stdin.nextLine();
		while (scenarios > 0)
		{
			xQueenPos = stdin.nextInt() - 1;
			yQueenPos = stdin.nextInt() - 1;
			
			queenPosition = yQueenPos * 8 + xQueenPos;
			java.util.HashSet<Integer> invalidPositions = new java.util.HashSet<Integer> ();
			EightQueens.updateInvalidPositions(invalidPositions, queenPosition);
			
			java.util.ArrayList<Integer> developingPositions = new java.util.ArrayList<Integer> ();
			
			java.util.ArrayList<int[]>finalList;
			
			if (yQueenPos == 0)
			{
				finalList = EightQueens.goDeepHelper(true, invalidPositions, developingPositions);
			}
			else
			{
				finalList = EightQueens.goDeepHelper(false, invalidPositions, developingPositions);
			}
			
			java.util.LinkedHashSet<java.util.List<Integer>> remove = new java.util.LinkedHashSet<java.util.List<Integer>> ();
			for (int[]a: finalList)
			{
				java.util.List<Integer> list = new java.util.ArrayList<Integer> ();
				for (int element: a)
				{
					list.add(element);
				}
				remove.add(list);
			}
			
			
			
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			int count = 1;
			for (java.util.List<Integer> a: remove)
			{
				if (count < 10)
				{
					System.out.print(" " + count + "      ");
				}
				else
				{
					System.out.print(count + "      ");
				}
				for (int el: a)
				{
					System.out.print(el + " ");
				}
				count++;
				System.out.println();
			}
			
			System.out.println();
			scenarios--;
			stdin.nextLine();
			stdin.nextLine();
		}
		stdin.close();
	}
	
	public static java.util.ArrayList<int[]>goDeepHelper(boolean queenIsFirst, java.util.HashSet<Integer> invalidPositions, java.util.List<Integer> developingPositions)
	{
		java.util.ArrayList<int[]>finalList = new java.util.ArrayList<int[]>();
		
		if (queenIsFirst)
		{
			for (int i = 8; i < 16; i++)
			{
				if (!invalidPositions.contains(i))
				EightQueens.goDeep(7, i, invalidPositions, developingPositions, finalList);
			}
		}
		else
		{
			for (int i = 0; i < 8; i++)
			{
				if (!invalidPositions.contains(i))
				EightQueens.goDeep(7, i, invalidPositions, developingPositions, finalList);
			}
		}
		
		return finalList;
	}
	
	public static void goDeep(int remainingQueens, int position, java.util.HashSet<Integer> invalidPositions, java.util.List<Integer> developingPositions, java.util.List<int[]>finalList)
	{
		// hooray, we're done!
		if (remainingQueens == 0)
		{
			int[] solution = new int [8];
			for (int i = 0; i < yQueenPos; i++)
			{
				solution[i] = developingPositions.get(i) + 1;
			}
			
			solution[yQueenPos] = xQueenPos+1;
			for (int i = yQueenPos + 1; i < solution.length; i++)
			{
				solution[i] = developingPositions.get(i-1) + 1;
			}
			
			finalList.add(solution);
		}
		else
		{
			java.util.List<Integer> newDevelopingPositions = new java.util.ArrayList<Integer> ();
			newDevelopingPositions.addAll(developingPositions);
			newDevelopingPositions.add(position - 8*(position/8));
			
			java.util.HashSet<Integer> newInvalidPositions = new java.util.HashSet<Integer> ();
			for (Integer i: invalidPositions)
				newInvalidPositions.add(i);
			newInvalidPositions.add(position);
			EightQueens.updateInvalidPositions(newInvalidPositions, position);
			
			
			
			boolean theQueenIsNext = (position/8 + 1 == queenPosition/8);
			int[] nextPositions = EightQueens.findNextPosition(position, newInvalidPositions, theQueenIsNext);
			

			for (int i = 0; i < nextPositions.length && nextPositions[i] != 0; i++)
				EightQueens.goDeep(remainingQueens - 1, nextPositions[i], newInvalidPositions, newDevelopingPositions, finalList);			
		
		}
	}
	
	public static void updateInvalidPositions(java.util.HashSet<Integer> set, int position)
	{
		int row = position - 8*(position/8);
		int col = position/8;
		
		// go diagonal right up
		for (int i = position, x = row, y = col; x >= 0 && y <= 7; i+= 7, x--, y++)
		{
			set.add(i);
		}
		// go diagonal right down
		for (int i = position, x = row, y = col; x <= 7 && y <= 7; i+= 9, x++, y++)
		{
			set.add(i);
		}
		// go diagonal left up
		for (int i = position, x = row, y = col; x >= 0 && y >= 0; i-= 9, x--, y--)
		{
			set.add(i);
		}
		// go diagonal left down
		for (int i = position, x = row, y = col; x <= 7 && y >= 0; i-= 7, x++, y--)
		{
			set.add(i);
		}
		// consider those left and right
		for (int i = row, count = 0; count < 8; i+= 8, count++)
		{
			set.add(i);
		}
		// consider those up and down
		for (int i = col*8, count = 0; count < 8; i+= 1, count++)
		{
			set.add(i);
		}
	}
	
	public static int[] findNextPosition(int lastPosition, java.util.HashSet<Integer> invalidPositions, boolean theQueenIsNext)
	{
		int offset = 0;
		if (theQueenIsNext)
			offset = 1;
		
		int[] possiblePositions = new int[8];
		int count = 0;

		int firstPossibleLocation = 8*((lastPosition/8)+ 1 + offset);
		
		for (int i = firstPossibleLocation; i < firstPossibleLocation + 8; i++)
		{
			
			if (!invalidPositions.contains(i))
			{	
				possiblePositions[count] = i;
				count++;
			}
		}
		
		return possiblePositions;
	}
	
	
	
}
