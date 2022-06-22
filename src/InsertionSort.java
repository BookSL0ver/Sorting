import java.util.ArrayList;

public class InsertionSort <T extends Comparable<T>> {
	
	public ArrayList<Student> sort(ArrayList<T> items, ArrayList<Student> students)
	{
		int j;
		for(int i = 1; i < items.size(); i++)
		{
			j = i;
			while(j > 0 && items.get(j).compareTo(items.get(j - 1)) < 0)
			{
				T temp = items.get(j);
				items.set(j, items.get(j - 1));
				items.set(j - 1, temp);
				Student temp2 = students.get(j);
				students.set(j, students.get(j - 1));
				students.set(j - 1, temp2);
				j--;
			}
		}
		return students;
	}

}
