import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		FileScanner f = new FileScanner();
		f.scan();
		HeapSort<String> stringHeap = new HeapSort<String>();
		HeapSort<Integer> intHeap = new HeapSort<Integer>();
		SelectionSort<String> stringSelect = new SelectionSort<String>();
		SelectionSort<Integer> intSelect = new SelectionSort<Integer>();
		InsertionSort<String> stringInsert = new InsertionSort<String>();
		InsertionSort<Integer> intInsert = new InsertionSort<Integer>();
		ArrayList<Student> students = f.getInfo();
		try
		{
			for(int i = 0; i < students.size() - 1; i++)
			{
				if(students.get(i).getScores().size() != students.get(i + 1).getScores().size())
					throw new NullPointerException();
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Invalid file format. All students must have the same number of scores.");
			f = new FileScanner();
			f.scan();
			students = f.getInfo();
		}
		ArrayList<String> names = new ArrayList<String>();
		int longestNameLen = 0;
		for(int i = 0; i < students.size(); i++)
			names.add(students.get(i).getName());
		for(int j = 0; j < names.size(); j++)
		{
			if(names.get(j).length() > longestNameLen)
				longestNameLen = names.get(j).length();
		}
		stringHeap.sort(names, students);
		for(int i = 0; i < students.size(); i++)
		{
			System.out.println(students.get(i).toString());
		}
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input = input.toUpperCase();
		while(input.compareTo("Q") != 0)
		{
			String letter = input.substring(0, 1);
			int number = Integer.parseInt(input.substring(1));
			if(number > students.get(0).getScores().size())
				System.out.println("Invalid number.");
			else
			{
				if(letter.compareTo("O") == 0)
				{
					if(number == 0)
					{
						ArrayList<String> items = new ArrayList<String>();
						for(int i = 0; i < students.size(); i++)
							items.add(students.get(i).getName());
						students = stringHeap.sort(items, students);
					}
					else
					{
						ArrayList<Integer> items = new ArrayList<Integer>();
						for(int i = 0; i < students.size(); i++)
							items.add(students.get(i).getScores().get(number - 1));
						students = intHeap.sort(items, students);
					}
				}
				else if(letter.compareTo("A") == 0)
				{
					if(number == 0)
					{
						ArrayList<String> items = new ArrayList<String>();
						for(int i = 0; i < students.size(); i++)
							items.add(students.get(i).getName());
						students = stringInsert.sort(items, students);
					}
					else
					{
						ArrayList<Integer> items = new ArrayList<Integer>();
						for(int i = 0; i < students.size(); i++)
							items.add(students.get(i).getScores().get(number - 1));
						students = intInsert.sort(items, students);
					}
				}	
				else if(letter.compareTo("F") == 0)
				{
					if(number == 0)
					{
						ArrayList<String> items = new ArrayList<String>();
						for(int i = 0; i < students.size(); i++)
							items.add(students.get(i).getName());
						students = stringSelect.sort(items, students);
					}
					else
					{
						ArrayList<Integer> items = new ArrayList<Integer>();
						for(int i = 0; i < students.size(); i++)
							items.add(students.get(i).getScores().get(number - 1));
						students = intSelect.sort(items, students);
					}
				}
				else
				{
					System.out.println("Invalid letter input.");
				}
			}
			for(int i = 0; i < students.size(); i++)
			{
				System.out.println(students.get(i).toString());
			}
			input = s.nextLine();
			input = input.toUpperCase();
		}
		s.close();
	}

}
