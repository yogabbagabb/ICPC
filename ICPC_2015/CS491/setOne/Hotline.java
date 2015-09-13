package setOne;
import java.util.StringTokenizer;
public class Hotline 
{
	
	public static final String NOBODY = "nobody";
	public static final String EVERYBODY = "everybody";
	
	public static void main (String[]args)
	{
		Hotline.recognizeSentence("Jimmy dances.");
		Hotline.recognizeSentence("I swim.");
		Hotline.recognizeSentence("does Enrique eat food?");	
		Hotline.recognizeSentence("Enrique eats food.");
		Hotline.recognizeSentence("Enrique eats food today.");
		Hotline.recognizeSentence("Enrique doesn't eat food today.");
		Hotline.recognizeSentence("does Jimmy dance?");
		Hotline.recognizeSentence("does Enrique eat food?");
		Hotline.recognizeSentence("does Enrique eat food today?");
		Hotline.recognizeSentence("do I swim?");
	}
	
	public static void recognizeSentence(String sentence)
	{
		switch (sentence.substring(sentence.length()-1))
		{
			case("."):
			{
				Hotline.breakStatement(sentence.substring(0, sentence.length()-1));
				break;
			}
			case("?"):
			{
				Hotline.recognizeQuestion(sentence.substring(0, sentence.length()-1));
				break;
			}
			case("!"):
			{
				System.out.println("bye!");
				break;
			}
			
		}
	}
	
	public static void breakStatement(String statement)
	{	
		StringTokenizer tokenizer = new StringTokenizer (statement);
		
		String subject = tokenizer.nextToken();
		String predicate = tokenizer.nextToken();
		
		
		boolean negative = false;
		if (predicate.equals("don't") || predicate.equals("doesn't"))
		{
			predicate = tokenizer.nextToken();
			negative = true;	
		}
		
		if (predicate.charAt(predicate.length()-1) == 's')
		{
			predicate = predicate.substring(0,predicate.length()-1);
		}
		
		
		
		if (subject.equals(NOBODY))
		{
			negative = true;
		}
		
		predicate += " ";
		
		while (tokenizer.hasMoreTokens())
		{
			predicate += tokenizer.nextToken() + " ";
		}
		
		predicate = predicate.replaceAll(" $", "");
		
		DataNode subjectNode = new DataNode(subject, SentenceComponent.SUBJECT);
		SentenceComponent predicateComponent;
		
		if (negative)
			predicateComponent = SentenceComponent.NEGATIVE_PREDICATE;
		else
			predicateComponent = SentenceComponent.POSITIVE_PREDICATE;
		
		DataNode predicateNode = new DataNode(predicate, predicateComponent);
				
		subjectNode.add(predicateNode);
		predicateNode.add(subjectNode);
				

	}
	
	public static void recognizeQuestion(String question)
	{
		String firstWord = question.substring(0, question.indexOf(" "));
		
		switch (firstWord)
		{
			case("do"):
			{
				Hotline.analyzeQuestionOne(question);
				break;
			}
			case("does"):
			{
				Hotline.analyzeQuestionOne(question);
				break;
			}
			case("who"):
			{
				Hotline.analyzeQuestionTwo(question);
				break;
			}
			case("what"):
			{
				Hotline.analyzeQuestionThree(question);
				break;
			}
		}
	}
	
	public static void analyzeQuestionOne(String question)
	{
		StringTokenizer tokenizer = new StringTokenizer(question);
		tokenizer.nextToken();
		
		String subject = tokenizer.nextToken();
		
		String predicate = "";
		while (tokenizer.hasMoreTokens())
		{
			predicate += tokenizer.nextToken() + " ";
		}
		predicate = predicate.replaceAll(" $", "");
		
		java.util.HashSet<DataNode> allNodes = DataNode.getAllNodes();
		
		boolean positive = false;
		boolean negative = false;
		boolean everybody = false;
		boolean nobody = false;
		
		DataNode subjectNode;
		for (DataNode node: allNodes)
		{
			if (node.name.equals(subject) || node.name.equals(NOBODY) || node.name.equals(EVERYBODY))
			{
				subjectNode = node;
				DataNode predicateNode;
				
				for (DataNode secondNode: subjectNode.nodes)
				{
					if (secondNode.name.equals(predicate))
					{
						predicateNode = secondNode;
						if (predicateNode.state.equals(SentenceComponent.NEGATIVE_PREDICATE))
							negative = true;
						else
							positive = true;					
						
						nobody = node.name.equals(NOBODY);
						everybody = node.name.equals(EVERYBODY);
						
						break;

					}
				
				}
			}
		}
		
		System.out.println(question + "?");
		
		if (positive && negative)
		{
			System.out.println("I am abroad..");
		}
		else if (everybody)
		{
			System.out.println("yes, " + EVERYBODY + " " + Hotline.getPredicateConjugation(EVERYBODY, predicate));
		}
		else if (nobody)
		{
			System.out.println("no, " + NOBODY + " " + Hotline.getPredicateConjugation(NOBODY, predicate));
		}
		else if (positive)
		{
			String perfectSubject = Hotline.checkSubjectConjugation(subject);
			System.out.println("yes, " + perfectSubject + " " + Hotline.getPredicateConjugation(perfectSubject, predicate));
		}
		else if (negative)
		{
			String perfectSubject = Hotline.checkSubjectConjugation(subject);
			System.out.println("no, " + perfectSubject + "doesn't " + Hotline.getPredicateConjugation(perfectSubject, predicate));
		}
		else
		{
			System.out.println("maybe.");
		}
	
		
		System.out.println("\n");
	}
	
	public static String getPredicateConjugation(String subject, String predicate)
	{
		
		if (predicate.contains(" "))
		{
			switch(subject)
			{
				case(EVERYBODY):
				{
					return predicate.substring(0, predicate.indexOf(" ")) +"s" + predicate.substring(predicate.indexOf(" "));
				}
				case(NOBODY):
				{
					return predicate.substring(0, predicate.indexOf(" ")) +"s" + predicate.substring(predicate.indexOf(" "));
				}
				case("I"):
				{
					return predicate + ".";
				}
				case("you"):
				{
					return predicate + ".";
				}
				
				default:
				{
					return predicate.substring(0, predicate.indexOf(" ")) +"s" + predicate.substring(predicate.indexOf(" ")) + ".";
				}
			}
		}
		
		else
		{
			switch (subject)
			{
				case(EVERYBODY):
				{
					return  predicate +"s.";
				}
				case(NOBODY):
				{
					return  predicate +"s.";
				}
				case("I"):
				{
					return predicate + ".";
				}
				case("you"):
				{
					return predicate + ".";
				}
				default:
				{
					return predicate + "s.";
				}
			
			}
		}
	}
		
		
	
	public static void analyzeQuestionTwo(String question)
	{
		StringTokenizer tokenizer = new StringTokenizer(question);
		tokenizer.nextToken();
		String predicate = tokenizer.nextToken().replaceAll("s$", "") + " ";
		
		while (tokenizer.hasMoreTokens())
		{
			predicate += tokenizer.nextToken() + " ";
		}
		predicate.replaceAll(" $", "");
		
		DataNode positivePredicateNode = new DataNode(predicate, SentenceComponent.POSITIVE_PREDICATE);
		DataNode negativePredicateNode = new DataNode(predicate, SentenceComponent.NEGATIVE_PREDICATE);
		java.util.HashSet<DataNode> allNodes = DataNode.getAllNodes();
		
		java.util.ArrayList<String> positiveSubjects = new java.util.ArrayList<String> ();
		java.util.ArrayList<String> negativeSubjects = new java.util.ArrayList<String> ();

		
		for (DataNode predicateNode: allNodes)
		{
			if (predicateNode.equals(positivePredicateNode))
			{
				for (DataNode innerNode: predicateNode.nodes)
				{
					positiveSubjects.add(innerNode.name);
				}
 			}
			
			if (predicateNode.equals(negativePredicateNode))
			{
				for (DataNode innerNode: predicateNode.nodes)
				{
					negativeSubjects.add(innerNode.name);
				}
 			}
		}
	}
	
	public static void analyzeQuestionThree(String question)
	{
		
	}
	
	/*
	 * To be used only when outputting the subject. Subjects are
	 * not stored by their counterpart (e.g. "you" is not stored internally
	 * as "I"); you cannot therefore check for a node by using this method, or 
	 * more generally, searching for its counterpart.
	 */
	public static String checkSubjectConjugation(String subject)
	{
		if (subject.equals("you"))
		{
			return "I";
		}
		else if (subject.equals("I"))
		{
			return "you";
		}
		else
		{
			return subject;
		}
	}
	
}


enum SentenceComponent
{
	SUBJECT(0), POSITIVE_PREDICATE(1),NEGATIVE_PREDICATE(2), OBJECT(3);
	
	private final int code;
	
	private SentenceComponent(int val)
	{
		code = val;
	}
}

class DataNode
{
	String name;
	SentenceComponent state;
	java.util.HashSet <DataNode> nodes;
	private static java.util.HashSet <DataNode> allNodes = new java.util.HashSet <DataNode> ();
	
	public DataNode(String identifier, SentenceComponent state)
	{
		name = identifier;
		this.state = state;
		nodes = new java.util.HashSet <DataNode> ();
		if (!allNodes.contains(this))
			allNodes.add(this);
	}
	
	public void add(String element, SentenceComponent state)
	{
		DataNode matchingNode = null;
		for (DataNode node: allNodes)
		{
			if (node.name.equals(element) && node.state.equals(state))
			{
				matchingNode = node;
				break;
			}
		}
		
		if (matchingNode == null)
		{
			matchingNode = new DataNode(element, state);
			allNodes.add(matchingNode);
			nodes.add(matchingNode);
		}
		else
		{
			nodes.add(matchingNode);
		}
		
	}
	
	public void add(DataNode node)
	{
		nodes.add(node);
	}
	
	public static java.util.HashSet<DataNode> getAllNodes()
	{
		return allNodes;
	}
	
	
}
