import java.util.ArrayList;

public class SelectionSort <T extends Comparable<T>> {
	
	public ArrayList<Student> sort(ArrayList<T> items, ArrayList<Student> students)
	{
		for(int i = 0; i < items.size(); i++)
		{
			int smallestIndex = i;
			for(int j = i + 1; j < items.size(); j++)
			{
				if(items.get(smallestIndex).compareTo(items.get(j)) > 0)
				{
					smallestIndex = j;
				}
			}
			T temp = items.get(i);
			items.set(i, items.get(smallestIndex));
			items.set(smallestIndex, temp);
			Student temp2 = students.get(i);
			students.set(i, students.get(smallestIndex));
			students.set(smallestIndex, temp2);
		}
		return students;
	}

}
